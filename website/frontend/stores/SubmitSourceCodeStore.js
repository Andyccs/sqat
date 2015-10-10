import alt from '../alt';
import SubmitSourceCodeAction from '../actions/SubmitSourceCodeAction';
import SubmitSourceCodeState from '../constants/SubmitSourceCodeState';
import styleCheckerReportSource from '../sources/StyleCheckerReportSource';
import {datasource} from 'alt/utils/decorators';

@datasource(styleCheckerReportSource)
class SubmitSourceCodeStore {
  constructor() {
    this.currentState = SubmitSourceCodeState.INITIAL;
    this.errorMessage = null;
    this.report = null;
    this.sourceCode = null;

    this.bindListeners({
      handleFetchStyleCheckerReport: SubmitSourceCodeAction.fetchStyleCheckerReport,
      handleSourceCodeSubmitSuccess: SubmitSourceCodeAction.fetchStyleCheckerReportSuccess,
      handleFetchStyleCheckerReportFailed: SubmitSourceCodeAction.fetchStyleCheckerReportFailed,
      handleSubmitAgain: SubmitSourceCodeAction.submitAgain,
      handleSourceCodeChanged: SubmitSourceCodeAction.sourceCodeChanged
    });
  }

  handleSourceCodeSubmitSuccess(result) {
    this.currentState = SubmitSourceCodeState.SUCCESS;
    this.report = result.reports;
    // optionally return false to suppress the store change event
  }

  handleFetchStyleCheckerReport() {
    this.currentState = SubmitSourceCodeState.SUBMITTING;
    if(!this.getInstance().isLoading()) {
      this.getInstance().performStyleCheck();
    }
  }

  handleFetchStyleCheckerReportFailed(errorMessage) {
    this.currentState = SubmitSourceCodeState.ERROR;
    this.errorMessage = errorMessage.message;
    console.log(errorMessage.message);
  }

  handleSubmitAgain() {
    this.currentState = SubmitSourceCodeState.INITIAL;
    this.errorMessage = null;
    this.report = null;
  }

  handleSourceCodeChanged(sourceCode) {
    this.sourceCode = sourceCode;
  }
}

module.exports = alt.createStore(SubmitSourceCodeStore, 'SubmitSourceCodeStore');