/*
This function will make a rpc call to stylechecker service to get a style reports
Two possible errors will be returned:
1. 404 Not Found, when the stylechecker service is not available
2. Error message: When the provided souce code is not in Java
*/

import grpc from 'grpc';

const PROTO_PATH = '../stylechecker/src/main/proto/style_check.proto';
const styleCheckProto = grpc.load(PROTO_PATH).stylechecker;

export default function submitSourceCode(request, response) {
  response.setHeader('Content-Type', 'application/json');

  let sourceCode = request.body.sourceCode;

  let client = new styleCheckProto.StyleCheck(
    'stylechecker:50051',
    grpc.Credentials.createInsecure());

  let configuration =
    '{"methodNameFormat": "camelCase","wildCardImport": "noWildCard","braceStyle":"kr"}';
  let checkStyleRequest = {
    sourceCode,
    configuration
  };

  client.check(checkStyleRequest, (err, qualityCheckResponse) => {
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

    if(qualityCheckResponse.error) {
      let responseBody = {
        error: qualityCheckResponse.error
      };

      console.log(qualityCheckResponse.error);
      response.send(JSON.stringify(responseBody));
      return;
    }

    let result = [];

    for(let i = 0; i < qualityCheckResponse.reports.length; i++) {
      let report = {
        lineNumber: qualityCheckResponse.reports[i].lineNumber,
        columnNumber: qualityCheckResponse.reports[i].columnNumber,
        reportMessage: qualityCheckResponse.reports[i].reportMessage,
        suggestion: qualityCheckResponse.reports[i].suggestion,
      };

      result.push(report);
    }

    let metricReport = qualityCheckResponse.metricReport;

    let responseBody = {
      styleReport: result,
      metricReport: metricReport
    };

    response.send(JSON.stringify(responseBody));
  });
}
