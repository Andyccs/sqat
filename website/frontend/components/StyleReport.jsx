import React from 'react';
import SubmitSourceCodeState from '../constants/SubmitSourceCodeState';

export default class StyleReport extends React.Component {
  constructor() {
    super();
  }

  aggregateSourceAndReport(sourceCode, reports) {
    let lineSourceCodes = sourceCode.split('\n');
    let lineReports = [];

    for(let i = 0; i < reports.length; i++) {
      let report = reports[i];

      lineReports[report.lineNumber] = {
        columnNumber: report.columnNumber,
        reportMessage: report.reportMessage,
        suggestion: report.suggestion,
      };
    }

    let aggregatedReports = [];

    for(let i = 0; i < lineSourceCodes.length; i++) {
      let source = lineSourceCodes[i].replace(/ /g, '\u00a0');

      if(lineReports[i + 1] != null) {
        let message = lineReports[i + 1].reportMessage;
        let suggestion = lineReports[i + 1].suggestion;

        aggregatedReports[i] = new Report(i + 1, source, message, suggestion);
      } else {
        aggregatedReports[i] = new Report(i + 1, source);
      }
    }

    return aggregatedReports;
  }

  render() {
    let currentState = this.props.data.currentState;
    let sourceCode = this.props.data.sourceCode;
    let report = this.props.data.report;
    let hidden = currentState != SubmitSourceCodeState.SUCCESS;

    let aggregatedReports = [];

    if(!hidden) {
      aggregatedReports = this.aggregateSourceAndReport(sourceCode, report);
    }

    return  <table
              hidden={hidden}>

                {aggregatedReports.map((report) => {
                  return  <tr>
                            <td>{report.lineNumber}</td>
                            <td>{report.sourceCode}</td>
                            <td>{report.message}</td>
                            <td>{report.suggestion}</td>
                          </tr>;
                })}

            </table>;
  }
}

class Report {

  constructor(lineNumber, sourceCode, message = '', suggestion = '') {
    this._lineNumber = lineNumber;
    this._sourceCode = sourceCode;
    this._message = message;
    this._suggestion = suggestion;
  }

  get lineNumber() {
    return this._lineNumber;
  }

  set lineNumber(lineNumber) {
    this._lineNumber = lineNumber;
  }

  get sourceCode() {
    return this._sourceCode;
  }

  set sourceCode(sourceCode) {
    this._sourceCode = sourceCode;
  }

  get message() {
    return this._message;
  }

  set message(message) {
    this._message = message;
  }

  get suggestion() {
    return this._suggestion;
  }

  set suggestion(suggestion) {
    this._suggestion = suggestion;
  }
}