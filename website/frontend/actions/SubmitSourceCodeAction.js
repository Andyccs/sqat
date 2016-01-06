import alt from '../alt';
import StyleCheckerReportSource from '../sources/StyleCheckerReportSource';

class SubmitSourceCodeAction {

  fetchStyleCheckerReport() {
    return null;
  }

  fetchStyleCheckerReportSuccess(report) {
    return report;
  }

  fetchStyleCheckerReportFailed(errorMessage) {
    return errorMessage;
  }

  submitAgain() {
    return null;
  }

  sourceCodeChanged(sourceCode) {
    return sourceCode;
  }
}

module.exports = alt.createActions(SubmitSourceCodeAction);
