import Radium from 'radium';
import React from 'react';
import SubmitSourceCodeState from '../constants/SubmitSourceCodeState';

@Radium
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

    let aggregatedReports = [];

    if(currentState == SubmitSourceCodeState.SUCCESS) {
      aggregatedReports = this.aggregateSourceAndReport(sourceCode, report);
    }

    return  <table>
              <tbody>
                {aggregatedReports.map((report) => {
                  return  <tr key={report.lineNumber} style={[styles.row]}>
                            <td style={[styles.columnBase, styles.lineNumber]}>
                              {report.lineNumber}
                            </td>
                            <td style={[styles.columnBase, styles.code]}>
                              {report.sourceCode}
                            </td>
                            <td style={[styles.columnBase, styles.message]}>
                              {report.message}
                            </td>
                            <td style={[styles.columnBase, styles.suggestion]}>
                              {report.suggestion}
                            </td>
                          </tr>;
                })}
              </tbody>
            </table>;
  }
}

// You can create your style objects dynamically or share them for
// every instance of the component.
var styles = {
  row: {
    backgroundColor: 'white',
    boxSizing: 'border-box',
    color: 'black',
    fontSize: 12,
    wordWrap: 'break-word',
  },
  columnBase: {
    paddingLeft: 10,
    paddingRight: 10,
    borderStyle: 'solid',
    borderColor: '#eee',
    borderWidth: '0 1px 0 0',
    verticalAlign: 'top',
    borderCollapse: 'collapse',
  },
  lineNumber: {
    color: '#999',
    cursor: 'pointer',
    minWidth: 50,
    textAlign: 'right',
    width: '1%',
  },
  code: {
    fontFamily: 'Consolas',
    width: '50%',
  },
  message: {
    color: 'red',
    fontWeight: 'bold',
  },
  suggestion: {
    color: 'green',
    fontWeight: 'bold',
  }
};

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