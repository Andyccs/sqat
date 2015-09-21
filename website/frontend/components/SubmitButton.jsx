import React from 'react';
import SubmitSourceCodeState from '../constants/SubmitSourceCodeState';

export default class SubmitButton extends React.Component {
  constructor() {
    super();
  }

  render() {
    var handleSubmit = this.props.onSourceCodeSubmit;
    var handleSubmitAgain = this.props.onSubmitAgain;
    var currentState = this.props.data.currentState;
    var disabled = currentState == SubmitSourceCodeState.SUBMITTING;

    if(currentState == SubmitSourceCodeState.SUCCESS ||
      currentState == SubmitSourceCodeState.ERROR) {

      var buttonVariation =
        currentState == SubmitSourceCodeState.ERROR ? 'btn-danger' : 'btn-success';

      return  <button
                className={'btn ' + buttonVariation}
                onClick={handleSubmitAgain}>

                Submit Again

              </button>;
    } else {
      return  <button
                className='btn btn-primary'
                onClick={handleSubmit}
                disabled={disabled}>

                Submit

              </button>;
    }
  }
}