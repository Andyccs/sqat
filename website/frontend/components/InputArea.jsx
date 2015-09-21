import React from 'react';
import SubmitSourceCodeState from '../constants/SubmitSourceCodeState';

export default class InputArea extends React.Component {
  constructor() {
    super();
  }

  render() {

    var disable = this.props.data.currentState != SubmitSourceCodeState.INITIAL;

    return  <textarea
              disabled={disable}
              className='form-control'
              rows='10'
              placeholder='Paste your source code here'>
            </textarea>;
  }
}
