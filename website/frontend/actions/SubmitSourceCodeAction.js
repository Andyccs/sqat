var alt = require('../alt');

class SubmitSourceCodeAction {
  updateClicked(clicked) {
    this.dispatch(clicked);
  }
}

module.exports = alt.createActions(SubmitSourceCodeAction);