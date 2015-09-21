import React from 'react';

export default class InputArea extends React.Component {
  constructor() {
    super();
  }

  render() {
    var disable = this.props.data.loading || this.props.data.success;

    return  <textarea
              disabled={disable}
              className='form-control'
              rows='10'
              placeholder='Paste your source code here'>
            </textarea>;
  }
}
