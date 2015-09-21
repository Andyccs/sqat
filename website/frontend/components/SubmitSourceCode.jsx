import React from 'react';
import InputArea from './InputArea';
import ProgressBar from './ProgressBar';
import SubmitButton from './SubmitButton';
import Title from './Title';
import SubmitSourceCodeStore from '../stores/SubmitSourceCodeStore';
import SubmitSourceCodeAction from '../actions/SubmitSourceCodeAction';

export default class SubmitSourceCode extends React.Component {

  constructor() {
    super();
    this.state = SubmitSourceCodeStore.getState();
    this.onChange = this.onChange.bind(this);
  }

  componentDidMount() {
    SubmitSourceCodeStore.listen(this.onChange);
  }

  componentWillUnmount() {
    SubmitSourceCodeStore.unlisten(this.onChange);
  }

  onChange(state) {
    this.setState(state);
  }

  _onSourceCodeSubmit() {
    SubmitSourceCodeAction.updateClicked(true);
  }

  render() {
    return  <div className='container'>
              <div className='row'>
                <Title data={this.state}/>
              </div>
              <div className='row'>
                <InputArea />
              </div>
              <div className='row'>
                <ProgressBar />
              </div>
              <div className='row'>
                <SubmitButton
                  data={this.state}
                  onSourceCodeSubmit={this._onSourceCodeSubmit}/>
              </div>
            </div>;
  }
}
