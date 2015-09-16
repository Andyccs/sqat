import React from 'react';

class HelloReact extends React.Component {
  render() {
    return <div>Hello React</div>;
  }
}

// es6 export is not working for webpack
// export default HelloReact;
module.exports = HelloReact;
