import React from 'react';
import SubmitSourceCodeState from '../constants/SubmitSourceCodeState';

export default class ErrorMessage extends React.Component {
  constructor() {
    super();
  }

  render() {
    let currentState = this.props.data.currentState;
    let message = this.props.data.errorMessage;

    if(currentState != SubmitSourceCodeState.ERROR) {
      return false;
    }

    return <p>{message}</p>;
  }
}