var path = require('path');

module.exports = {
  entry: './frontend/index.jsx',
  output: {
    path: path.join(__dirname, './public/'),
    filename: 'bundle.js',
    // at this directory our bundle file will be available
    // make sure port 8090 is used when launching webpack-dev-server
    publicPath: 'http://localhost:8090/assets'
  },
  module: {
    loaders: [{
      test: /\.css$/,
      loader: 'style!css'
    }, {
      // tell webpack to use jsx-loader for all *.jsx files
      test: /\.jsx$/,
      loaders: ['jsx-loader?insertPragma=React.DOM&harmony', 'babel']
    }, {
      test: /\.js$/,
      loaders: ['babel?stage=1']
    }]
  },
  externals: {
    // don't bundle the 'react' npm package with our bundle.js
    // but get it from a global 'React' variable
    'react': 'React'
  },
  resolve: {
    // you can now require('file') instead of require('file.coffee')
    extensions: ['', '.js', '.jsx']
  }
};