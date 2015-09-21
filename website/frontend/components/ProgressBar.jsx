import React from 'react';
import SubmitSourceCodeState from '../constants/SubmitSourceCodeState';

export default class ProgressBar extends React.Component {
  constructor() {
    super();
  }

  render() {
    var hidden = this.props.data.currentState != SubmitSourceCodeState.SUBMITTING;

    return  <div className='progress'>
              <div
                hidden={hidden}
                className='progress-bar progress-bar-striped active'
                style={{width: 99 + '%'}}>
              </div>
            </div>;
  }
}