import alt from '../alt';
import StyleCheckerReportSource from '../sources/StyleCheckerReportSource';

class SubmitSourceCodeAction {

  fetchStyleCheckerReport() {
    this.dispatch();
  }

  fetchStyleCheckerReportSuccess(report) {
    this.dispatch(report);
  }

  fetchStyleCheckerReportFailed(errorMessage) {
    this.dispatch(errorMessage);
  }

  submitAgain() {
    this.dispatch();
  }

  sourceCodeChanged(sourceCode) {
    this.dispatch(sourceCode);
  }
}

module.exports = alt.createActions(SubmitSourceCodeAction);