import React from 'react';

export default class ProgressBar extends React.Component {
  constructor() {
    super();
  }

  render() {
    return  <div className='progress'>
              <div
                className='progress-bar progress-bar-striped active'
                style={{width: 99 + '%'}}>
              </div>
            </div>;
  }
}
