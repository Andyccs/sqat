import React from 'react';

export default class Title extends React.Component {
  render() {
    var clicked = this.props.data.clicked;

    if(clicked) {
      return <h1>Thank you for submitting your codes</h1>;
    } else {
      return <h1>Software Quality Analysis Tool</h1>;
    }
  }
}