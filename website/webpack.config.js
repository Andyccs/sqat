var path = require('path');
var webpack = require('webpack');

var buildPath = path.resolve(__dirname, 'public', 'build');
var srcPath = path.resolve(__dirname, 'frontend');
var mainPath = path.resolve(__dirname, 'frontend', 'index.jsx');
var htmlPath = path.resolve(__dirname, 'frontend', 'index.html');

module.exports = {
  // Makes sure errors in console map to the correct file
  // and line number
  devtool: 'eval',
  entry: [
    'webpack-hot-middleware/client?reload=true',
    mainPath,
    htmlPath
  ],
  output: {
    // We need to give Webpack a path. It does not actually need it,
    // because files are kept in memory in webpack-dev-server, but an
    // error will occur if nothing is specified. We use the buildPath
    // as that points to where the files will eventually be bundled
    // in production
    path: buildPath,
    filename: 'bundle.js',
  },
  module: {
    loaders: [{
      test: /\.jsx$/,
      include: srcPath,
      loader: 'babel',
    }, {
      test: /\.js$/,
      include: srcPath,
      loader: 'babel',
    }, {
      test: /\.html$/,
      include: srcPath,
      loader: 'file?name=[name].[ext]',
    }]
  },
  externals: {
    // don't bundle the 'react' npm package with our bundle.js
    // but get it from a global 'React' variable
    'react': 'React'
  },
  resolve: {
    // you can now require('file') instead of require('file.js') or require('file.jsx')
    extensions: ['', '.js', '.jsx']
  },
  plugins: [ 
    new webpack.optimize.OccurenceOrderPlugin(),
    new webpack.HotModuleReplacementPlugin(),
    new webpack.NoErrorsPlugin(),
  ]
};
