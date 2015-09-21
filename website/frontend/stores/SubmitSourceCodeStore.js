var alt = require('../alt');
var SubmitSourceCodeAction = require('../actions/SubmitSourceCodeAction');

class SubmitSourceCodeStore {
  constructor() {
    this.clicked = false;
    this.bindListeners({
      handleSourceCodeSubmit: SubmitSourceCodeAction.updateClicked
    });
  }

  handleSourceCodeSubmit(locations) {
    this.clicked = true;
    // optionally return false to suppress the store change event
  }
}

module.exports = alt.createStore(SubmitSourceCodeStore, 'LocationStore');