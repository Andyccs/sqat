import React from 'react';
import MetricCard from './MetricCard';

export default class MetricReport extends React.Component {
  constructor() {
    super();
  }

  render() {
    let metricReport = this.props.data.metricReport;

    return  <div>
              <div className='row'>
                <div className='col-md-3'>
                  <MetricCard data={metricReport.overallData}/>
                </div>
                <div className='col-md-3'>
                  <MetricCard data={metricReport.analysabilityData}/>
                </div>
                <div className='col-md-3'>
                  <MetricCard data={metricReport.testabilityData}/>
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
                  <tr className={metricReport.lineOfCode.score < 80 ? 'danger' : ''}>>
                    <td>Line of codes</td>
                    <td>{metricReport.lineOfCode.value}</td>
                    <td>{metricReport.lineOfCode.benchmark}</td>
                    <td>{metricReport.lineOfCode.score}%</td>
                  </tr>
                  <tr className={metricReport.depthOfConditionalNesting.score < 80 ? 'danger' : ''}>
                    <td>Depth of conditional nesting</td>
                    <td>{metricReport.depthOfConditionalNesting.value}</td>
                    <td>{metricReport.depthOfConditionalNesting.benchmark}</td>
                    <td>{metricReport.depthOfConditionalNesting.score}%</td>
                  </tr>
                  <tr className={metricReport.lengthOfIdentifier.score < 80 ? 'danger' : ''}>
                    <td>Average length of identifier</td>
                    <td>{metricReport.lengthOfIdentifier.value}</td>
                    <td>{metricReport.lengthOfIdentifier.benchmark}</td>
                    <td>{metricReport.lengthOfIdentifier.score}%</td>
                  </tr>
                  <tr className={metricReport.weightedMethodPerClass.score < 80 ? 'danger' : ''}>
                    <td>Weighted method per class</td>
                    <td>{metricReport.weightedMethodPerClass.value}</td>
                    <td>{metricReport.weightedMethodPerClass.benchmark}</td>
                    <td>{metricReport.weightedMethodPerClass.score}%</td>
                  </tr>
                  <tr className={metricReport.numberOfAttribute.score < 80 ? 'danger' : ''}>>
                    <td>Number of attributes</td>
                    <td>{metricReport.numberOfAttribute.value}</td>
                    <td>{metricReport.numberOfAttribute.benchmark}</td>
                    <td>{metricReport.numberOfAttribute.score}%</td>
                  </tr>
                </tbody>
              </table>
            </div>;
  }
}

