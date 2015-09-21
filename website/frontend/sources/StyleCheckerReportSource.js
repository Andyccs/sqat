require('es6-promise').polyfill();
require('isomorphic-fetch');

export default class StyleCheckerReportSource {
  fetch() {
    return new Promise(function(resolve, reject) {

      fetch('submitSourceCode').
        then(function(response) {
          if (response.status >= 400) {
            throw new Error('Bad response from server');
          }

          return response.json();
        }).
        then(function(report) {
          resolve(report);
        });
    });
  }
}