import alt from '../alt';
import StyleCheckerReportSource from '../sources/StyleCheckerReportSource';

class SubmitSourceCodeAction {

  fetchStyleCheckerReport() {
    this.dispatch();
    new StyleCheckerReportSource().fetch().
      then((report) => {
        // we can access other actions within our action through `this.actions`
        this.actions.fetchStyleCheckerReportSuccess(report);
      }).
      catch((errorMessage) => {
        this.actions.locationsFailed(errorMessage);
      });
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
}

module.exports = alt.createActions(SubmitSourceCodeAction);