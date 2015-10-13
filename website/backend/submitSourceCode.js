import grpc from 'grpc';

const PROTO_PATH = '../stylechecker/src/main/proto/style_check.proto';
const styleCheckProto = grpc.load(PROTO_PATH).stylechecker;

export default function submitSourceCode(request, response) {
  response.setHeader('Content-Type', 'application/json');

  let sourceCode = request.body.sourceCode;

  let client = new styleCheckProto.StyleCheck(
    'localhost:50051',
    grpc.Credentials.createFake());

  let configuration =
    '{"methodNameFormat": "camelCase","wildCardImport": "noWildCard","braceStyle":"kr"}';
  let checkStyleRequest = {
    sourceCode,
    configuration
  };

  client.check(checkStyleRequest, (err, styleCheckResponse) => {
    if(err) {
      let responseBody = {
        error: {
          code: 404,
          message: 'Not Found'
        }
      };

      response.send(JSON.stringify(responseBody));
      return;
    }

    if(styleCheckResponse.error) {
      let responseBody = {
        error: styleCheckResponse.error
      };

      console.log(styleCheckResponse.error);
      response.send(JSON.stringify(responseBody));
      return;
    }

    let result = [];

    for(let i = 0; i < styleCheckResponse.reports.length; i++) {
      let report = {
        lineNumber: styleCheckResponse.reports[i].lineNumber,
        columnNumber: styleCheckResponse.reports[i].columnNumber,
        reportMessage: styleCheckResponse.reports[i].reportMessage,
        suggestion: styleCheckResponse.reports[i].suggestion,
      };

      result.push(report);
    }

    let responseBody = {
      reports: result
    };

    response.send(JSON.stringify(responseBody));
  });
}
