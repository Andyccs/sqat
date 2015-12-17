import React from 'react';
import MetricCard from './MetricCard';

export default class MetricReport extends React.Component {
  constructor() {
    super();
  }

  render() {
    let overallData = {
      percentage: 80,
      infoText: 'Overall Quality'
    };
    let analysabilityData = {
      percentage: 70,
      infoText: 'Analysability'
    };
    let testabilityData = {
      percentage: 90,
      infoText: 'Testability'
    };

    return  <div className='row'>
              <div className='col-md-3'>
                <MetricCard data={overallData}/>
              </div>
              <div className='col-md-3'>
                <MetricCard data={analysabilityData}/>
              </div>
              <div className='col-md-3'>
                <MetricCard data={testabilityData}/>
              </div>
            </div>;
  }
}

