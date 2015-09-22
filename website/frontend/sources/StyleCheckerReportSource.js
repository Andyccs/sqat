import alt from '../alt';
require('es6-promise').polyfill();
require('isomorphic-fetch');
// import SubmitSourceCodeAction from '../actions/SubmitSourceCodeAction';

const StyleCheckerReportSource = (alt) => {
  return {
    performStyleCheck: {
      remote(state) {
        return new Promise((resolve, reject) => {
          fetch(`submitSourceCode?source=${state.sourceCode}`).
            then((response) => {
              if(response.status >= 400) {
                throw new Error('Bad response from server');
              }

              return response.json();
            }).
            then((report) => {
              resolve(report);
            });
        });

      },

      // (optional)
      // this function checks in our local cache first
      // if the value is present it'll use that instead (optional)
      // local(state) {
      // },

      // (optional)
      // here we setup some actions to handle our response
      // loading: SubmitSourceCodeAction.loadingResults

      success: alt.actions.SubmitSourceCodeAction.fetchStyleCheckerReportSuccess,

      error: alt.actions.SubmitSourceCodeAction.fetchStyleCheckerReportFailed,

      // (optional)
      // Should fetch has precedence over the value returned by local in determining whether
      // remote should be called.
      // In this particular example if the value is present locally it would return but
      // still fire off the remote request.
      shouldFetch(state) {
        return true;
      }
    }
  };
};

export default StyleCheckerReportSource;