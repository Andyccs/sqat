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
    var success = this.props.data.success;

    return  <button
              className='btn btn-material-blue primary'
              onClick={this.handleSubmit}
              disabled={success}>

              Submit

            </button>;
  }
}