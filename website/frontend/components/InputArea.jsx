import React from 'react';
import SubmitSourceCodeState from '../constants/SubmitSourceCodeState';
import 'babel/polyfill';
import TextAreaAutosize from 'react-textarea-autosize';

export default class InputArea extends React.Component {
  constructor() {
    super();
  }

  _onTextChange() {
    console.log('change');
  }

  render() {

    var disable = this.props.data.currentState != SubmitSourceCodeState.INITIAL;

    return  <TextAreaAutosize
              disabled={disable}
              className='form-control'
              rows='10'
              placeholder='Paste your source code here'
              onChange={this._onTextChange}
              useCacheForDOMMeasurements />;
  }
}
