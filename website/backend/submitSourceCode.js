import grpc from 'grpc';

const PROTO_PATH = '../stylechecker/src/main/proto/style_check.proto';
const styleCheckProto = grpc.load(PROTO_PATH).stylechecker;

export default function submitSourceCode(request, response) {
  let sourceCode = request.body.sourceCode;

  let client = new styleCheckProto.StyleCheck(
    'localhost:50051',
    grpc.Credentials.createFake());

  let configuration =
    '{"methodNameFormat": "camelCase","wildCardImport": "noWildCard"}';
  let checkStyleRequest = {
    sourceCode,
    configuration
  };

  client.check(checkStyleRequest, (err, styleCheckResponse) => {
    if(err) {
      console.log(err);
      return;
    }

    let result = [];

    for(let i = 0; i < styleCheckResponse.reports.length; i++) {
      let report = {
        lineNumber: styleCheckResponse.reports[0].lineNumber,
        columnNumber: styleCheckResponse.reports[0].columnNumber,
        reportMessage: styleCheckResponse.reports[0].reportMessage,
        suggestion: styleCheckResponse.reports[0].suggestion,
      };

      result.push(report);
    }

    response.setHeader('Content-Type', 'application/json');
    // Send a dummy data back
    response.send(JSON.stringify(result));
  });
}
