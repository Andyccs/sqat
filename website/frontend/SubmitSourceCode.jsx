import React from 'react';

class Title extends React.Component {
  render() {
    var clicked = this.props.data.clicked;

    if(clicked) {
      return <h1>Thank you for submitting your codes</h1>;
    } else {
      return <h1>Software Quality Analysis Tool</h1>;
    }
  }
}

class InputArea extends React.Component {
  constructor() {
    super();
  }

  render() {
    return  <textarea
              className='form-control'
              rows='10'
              placeholder='Paste your source code here'>
            </textarea>;
  }
}

class ProgressBar extends React.Component {
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

class SubmitButton extends React.Component {
  constructor() {
    super();
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleSubmit(e) {
    this.props.onSourceCodeSubmit();
  }

  render() {
    var clicked = this.props.data.clicked;

    return  <button
              className='btn btn-material-blue primary'
              onClick={this.handleSubmit}
              disabled={clicked}>

              Submit

            </button>;
  }
}

class SubmitSourceCode extends React.Component {

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

// es6 export is not working for webpack
// export default SubmitSourceCode;
module.exports = SubmitSourceCode;
