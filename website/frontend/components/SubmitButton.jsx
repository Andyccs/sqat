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

    let props = {};
    let buttonText = '';

    if(currentState == SubmitSourceCodeState.SUCCESS) {
      props.className = 'btn btn-success';
      props.onClick = handleSubmitAgain;
      buttonText = 'Submit Again';
    } else if(currentState == SubmitSourceCodeState.ERROR) {
      props.className = 'btn btn-danger';
      props.onClick = handleSubmitAgain;
      buttonText = 'Submit Again';
    } else if(currentState == SubmitSourceCodeState.INITIAL) {
      props.className = 'btn btn-primary';
      props.onClick = handleSubmit;
      buttonText = 'Submit';
    } else {
      return false;
    }

    return <button {...props}>{buttonText}</button>;
  }
}