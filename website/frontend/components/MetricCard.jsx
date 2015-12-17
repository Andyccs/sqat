import Radium from 'radium';
import React from 'react';

@Radium
export default class MetricCard extends React.Component {
  constructor() {
    super();
  }

  render() {
    let percentage = this.props.data.percentage;
    let infoText = this.props.data.infoText;

    return  <div className='well infobox'
              style={percentage >= 80 ? [styles.goodMetric] : [styles.badMetric]}>
              <h2>{percentage}%</h2>
              {infoText}
            </div>;
  }
}

var styles = {
  goodMetric: {
    backgroundColor: '#66BB6A'
  },
  badMetric: {
    backgroundColor: '#E57373'
  }
};

