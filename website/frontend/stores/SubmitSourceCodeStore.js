import alt from '../alt';
import SubmitSourceCodeAction from '../actions/SubmitSourceCodeAction';
import SubmitSourceCodeState from '../constants/SubmitSourceCodeState';

class SubmitSourceCodeStore {
  constructor() {
    this.currentState = SubmitSourceCodeState.INITIAL;
    this.errorMessage = null;
    this.report = null;

    this.bindListeners({
      handleFetchStyleCheckerReport: SubmitSourceCodeAction.fetchStyleCheckerReport,
      handleSourceCodeSubmitSuccess: SubmitSourceCodeAction.fetchStyleCheckerReportSuccess,
      handleFetchStyleCheckerReportFailed: SubmitSourceCodeAction.fetchStyleCheckerReportFailed,
      handleSubmitAgain: SubmitSourceCodeAction.submitAgain
    });
  }

  handleSourceCodeSubmitSuccess(report) {
    this.currentState = SubmitSourceCodeState.SUCCESS;
    this.report = report;
    console.log(this.report);
    // optionally return false to suppress the store change event
  }

  handleFetchStyleCheckerReport() {
    this.currentState = SubmitSourceCodeState.SUBMITTING;
  }

  handleFetchStyleCheckerReportFailed(errorMessage) {
    this.currentState = SubmitSourceCodeState.ERROR;
    this.errorMessage = errorMessage;
  }

  handleSubmitAgain() {
    this.currentState = SubmitSourceCodeState.INITIAL;
    this.errorMessage = null;
    this.report = null;
  }
}

module.exports = alt.createStore(SubmitSourceCodeStore, 'SubmitSourceCodeStore');