import React from 'react';

export default class Title extends React.Component {
  render() {
    var success = this.props.data.success;

    if(success) {
      return <h1>Thank you for submitting your codes</h1>;
    } else {
      return <h1>Software Quality Analysis Tool</h1>;
    }
  }
}