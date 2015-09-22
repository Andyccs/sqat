import React from 'react';
import SubmitSourceCodeState from '../constants/SubmitSourceCodeState';

export default class SubmitButton extends React.Component {
  constructor() {
    super();
  }

  render() {
    let handleSubmit = this.props.onSourceCodeSubmit;
    let handleSubmitAgain = this.props.onSubmitAgain;
    let currentState = this.props.data.currentState;
    let disabled = currentState == SubmitSourceCodeState.SUBMITTING;

    if(currentState == SubmitSourceCodeState.SUCCESS ||
      currentState == SubmitSourceCodeState.ERROR) {

      let buttonVariation =
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