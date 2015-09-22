import React from 'react';
import SubmitSourceCodeState from '../constants/SubmitSourceCodeState';

export default class ProgressBar extends React.Component {
  constructor() {
    super();
  }

  render() {
    let hidden = this.props.data.currentState != SubmitSourceCodeState.SUBMITTING;

    return  <div className='progress' hidden={hidden}>
              <div
                className='progress-bar progress-bar-striped active'
                style={{width: 99 + '%'}}>
              </div>
            </div>;
  }
}