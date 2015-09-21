import React from 'react';
import InputArea from './InputArea';
import ProgressBar from './ProgressBar';
import SubmitButton from './SubmitButton';
import Title from './Title';

export default class SubmitSourceCode extends React.Component {

  constructor() {
    super();
    this.state = {data: []};
    this.handleSourceCodeSubmit = this.handleSourceCodeSubmit.bind(this);
  }

  handleSourceCodeSubmit() {
    this.setState({
      data: {
        clicked: true
      }
    });
  }

  render() {
    return  <div className='container'>
              <div className='row'>
                <Title data={this.state.data}/>
              </div>
              <div className='row'>
                <InputArea />
              </div>
              <div className='row'>
                <ProgressBar />
              </div>
              <div className='row'>
                <SubmitButton
                  data={this.state.data}
                  onSourceCodeSubmit={this.handleSourceCodeSubmit}/>
              </div>
            </div>;
  }
}
