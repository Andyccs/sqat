import React from 'react';

export default class SubmitButton extends React.Component {
  constructor() {
    super();
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleSubmit(e) {
    this.props.onSourceCodeSubmit();
  }

  render() {
    var clicked = this.props.data.clicked;

    return  <button
              className='btn btn-material-blue primary'
              onClick={this.handleSubmit}
              disabled={clicked}>

              Submit

            </button>;
  }
}