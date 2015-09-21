var alt = require('../alt');
var SubmitSourceCodeAction = require('../actions/SubmitSourceCodeAction');

class SubmitSourceCodeStore {
  constructor() {
    this.success = false;
    this.loading = false;
    this.errorMessage = null;
    this.report = null;

    this.bindListeners({
      handleFetchStyleCheckerReport: SubmitSourceCodeAction.fetchStyleCheckerReport,
      handleSourceCodeSubmitSuccess: SubmitSourceCodeAction.fetchStyleCheckerReportSuccess,
      handleFetchStyleCheckerReportFailed: SubmitSourceCodeAction.fetchStyleCheckerReportFailed
    });
  }

  handleSourceCodeSubmitSuccess(report) {
    this.success = true;
    this.loading = false;
    this.report = report;
    console.log(this.report);
    // optionally return false to suppress the store change event
  }

  handleFetchStyleCheckerReport() {
    // reset the array while we're fetching new locations so React can
    // be smart and render a spinner for us since the data is empty.
    if(!this.loading) {
      this.loading = true;
    }
  }

  handleFetchStyleCheckerReportFailed(errorMessage) {
    this.errorMessage = errorMessage;
    this.loading = false;
  }
}

module.exports = alt.createStore(SubmitSourceCodeStore, 'SubmitSourceCodeStore');