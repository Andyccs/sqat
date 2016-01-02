var path = require('path');
var webpack = require('webpack');

var buildPath = path.resolve(__dirname, 'public', 'build');
var mainPath = path.resolve(__dirname, 'frontend', 'index.jsx');

module.exports = {
  // Makes sure errors in console map to the correct file
  // and line number
  devtool: 'eval',
  entry: [
    'webpack-hot-middleware/client?reload=true',
    mainPath
  ],
  output: {
    // We need to give Webpack a path. It does not actually need it,
    // because files are kept in memory in webpack-dev-server, but an
    // error will occur if nothing is specified. We use the buildPath
    // as that points to where the files will eventually be bundled
    // in production
    path: buildPath,
    filename: 'bundle.js',

    // Everything related to Webpack should go through a build path,
    // localhost:8080/build. That makes proxying easier to handle
    publicPath: '/build/'
  },
  module: {
    loaders: [{
      test: /\.css$/,
      loader: 'style!css'
    }, {
      // tell webpack to use jsx-loader for all *.jsx files
      test: /\.jsx$/,
      loaders: ['jsx-loader?insertPragma=React.DOM&harmony', 'babel?stage=1']
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
  },
  // We have to manually add the Hot Replacement plugin when running
  // from Node
  plugins: [ 
    new webpack.optimize.OccurenceOrderPlugin(),
    new webpack.HotModuleReplacementPlugin(),
    new webpack.NoErrorsPlugin(),
  ]
};
