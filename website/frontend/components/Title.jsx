import SubmitSourceCodeState from '../constants/SubmitSourceCodeState';
import React from 'react';

export default class Title extends React.Component {
  render() {
    let currentState = this.props.data.currentState;
    // == SubmitSourceCodeState.SUCCESS ||
    // this.props.data.currentState == SubmitSourceCodeState.SUBMITTING ;

    if(currentState == SubmitSourceCodeState.INITIAL) {
      return <h1>Software Quality Analysis Tool</h1>;
    } else if(currentState == SubmitSourceCodeState.SUBMITTING) {
      return <h1>Submitting Source Code</h1>;
    } else if(currentState == SubmitSourceCodeState.SUCCESS) {
      return <h1>Your Quality Report</h1>;
    } else {
      return <h1>Error</h1>;
    }
  }
}