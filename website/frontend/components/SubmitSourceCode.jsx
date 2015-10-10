import React from 'react';
import Header from './Header';
import Footer from './Footer';
import InputArea from './InputArea';
import ProgressBar from './ProgressBar';
import SubmitButton from './SubmitButton';
import ErrorMessage from './ErrorMessage';
import Title from './Title';
import StyleReport from './StyleReport';
import SubmitSourceCodeStore from '../stores/SubmitSourceCodeStore';
import SubmitSourceCodeAction from '../actions/SubmitSourceCodeAction';
import SubmitSourceCodeState from '../constants/SubmitSourceCodeState';

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

  _onTextChange(e) {
    SubmitSourceCodeAction.sourceCodeChanged(e.target.value);
  }

  render() {
    let renderInputArea = this.state.currentState == SubmitSourceCodeState.INITIAL;
    let renderProgressBar = this.state.currentState == SubmitSourceCodeState.SUBMITTING;
    let renderStyeReport = this.state.currentState == SubmitSourceCodeState.SUCCESS;
    let renderErrorMessage = this.state.currentState == SubmitSourceCodeState.ERROR;

    return  <div>

              <Header />

              <div className='container'>

                <div className='row'>
                  <Title data={this.state}/>
                </div>

                { renderErrorMessage &&
                <div className='row'>
                  <ErrorMessage data={this.state}/>
                </div>
                }

                { renderInputArea &&
                <div className='row'>
                  <InputArea
                    data={this.state}
                    onTextChanged={this._onTextChange}/>
                </div>
                }

                { renderProgressBar &&
                <div className='row'>
                  <ProgressBar
                    data={this.state} />
                </div>
                }

                { renderStyeReport &&
                <div className='row'>
                  <StyleReport
                    data={this.state} />
                </div>
                }

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
