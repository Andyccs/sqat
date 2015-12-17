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

    // TODO: change fake data to real data
    let metricReport = {
      overallData: {
        percentage: 99,
        descriptionText: 'Overall Quality'
      },
      analysabilityData: {
        percentage: 70,
        descriptionText: 'Analysability'
      },
      testabilityData: {
        percentage: 90,
        descriptionText: 'Testability'
      },
      lineOfCode: {
        value: 1005,
        benchmark: 1500,
        score: 85
      },
      depthOfConditionalNesting: {
        value: 3,
        benchmark: 1.5,
        score: 80
      },
      lengthOfIdentifier: {
        value: 25,
        benchmark: 10,
        score: 50
      },
      weightedMethodPerClass: {
        value: 6,
        benchmark: 5,
        score: 90
      },
      numberOfAttribute: {
        value: 8,
        benchmark: 6,
        score: 80
      }
    };

    let responseBody = {
      styleReport: result,
      metricReport: metricReport
    };

    response.send(JSON.stringify(responseBody));
  });
}
