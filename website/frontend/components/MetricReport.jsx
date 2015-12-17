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

    return  <div>
              <div className='row'>
                <div className='col-md-3'>
                  <MetricCard data={overallData}/>
                </div>
                <div className='col-md-3'>
                  <MetricCard data={analysabilityData}/>
                </div>
                <div className='col-md-3'>
                  <MetricCard data={testabilityData}/>
                </div>
              </div>
              <table className='table table-striped table-hover'>
                <thead>
                  <tr>
                    <th>Metric</th>
                    <th>Your value</th>
                    <th>Benchmark value</th>
                    <th>Score</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>Line of codes</td>
                    <td>1000</td>
                    <td>1050</td>
                    <td>90%</td>
                  </tr>
                  <tr>
                    <td>Depth of conditional nesting</td>
                    <td>3</td>
                    <td>1.5</td>
                    <td>80%</td>
                  </tr>
                  <tr className="danger">
                    <td>Average length of identifier</td>
                    <td>20</td>
                    <td>10</td>
                    <td>50%</td>
                  </tr>
                  <tr>
                    <td>Weighted method per class</td>
                    <td>10</td>
                    <td>5</td>
                    <td>50%</td>
                  </tr>
                  <tr>
                    <td>Number of attributes</td>
                    <td>6</td>
                    <td>10</td>
                    <td>100%</td>
                  </tr>
                </tbody>
              </table>
            </div>;
  }
}

