import React from 'react';
import Header from './Header';
import Footer from './Footer';
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
    SubmitSourceCodeAction.fetchStyleCheckerReport();
  }

  _onSubmitAgain() {
    SubmitSourceCodeAction.submitAgain();
  }

  render() {
    return  <div>

              <Header />

              <div className='container'>

                <div className='row'>
                  <Title data={this.state}/>
                </div>

                <div className='row'>
                  <InputArea
                    data={this.state} />
                </div>

                <div className='row'>
                  <ProgressBar
                    data={this.state} />
                </div>

                <div className='row'>
                  <SubmitButton
                    data={this.state}
                    onSubmitAgain={this._onSubmitAgain}
                    onSourceCodeSubmit={this._onSourceCodeSubmit} />
                </div>

              </div>

              <Footer />

            </div>;
  }
}
