import React from 'react';
import SubmitSourceCodeState from '../constants/SubmitSourceCodeState';
import 'babel/polyfill';
import TextAreaAutosize from 'react-textarea-autosize';

export default class InputArea extends React.Component {
  constructor() {
    super();
  }

  render() {
    let handleTextChanged = this.props.onTextChanged;
    let disable = this.props.data.currentState != SubmitSourceCodeState.INITIAL;
    let hidden = this.props.data.currentState == SubmitSourceCodeState.SUCCESS;

    return  <div hidden={hidden}>
              <TextAreaAutosize
                disabled={disable}
                className='form-control'
                rows='10'
                placeholder='Paste your source code here'
                onChange={handleTextChanged}
                useCacheForDOMMeasurements />
            </div>;
  }
}
