import React from 'react';
import TextAreaAutosize from 'react-textarea-autosize';

export default class InputArea extends React.Component {
  constructor() {
    super();
  }

  render() {
    let handleTextChanged = this.props.onTextChanged;

    return  <div>
              <TextAreaAutosize
                className='form-control'
                rows='10'
                placeholder='Paste your source code here'
                onChange={handleTextChanged}
                useCacheForDOMMeasurements />
            </div>;
  }
}
