import React from 'react';

export default class InputArea extends React.Component {
  constructor() {
    super();
  }

  render() {
    return  <textarea
              className='form-control'
              rows='10'
              placeholder='Paste your source code here'>
            </textarea>;
  }
}
