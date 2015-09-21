import React from 'react';

export default class ProgressBar extends React.Component {
  constructor() {
    super();
  }

  render() {
    return  <div className='progress'>
              <div
                className='progress-bar'
                style={{width: 60 + '%'}}>
              </div>
            </div>;
  }
}