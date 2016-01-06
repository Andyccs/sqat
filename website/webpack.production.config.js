var path = require('path');
var webpack = require('webpack');

var buildPath = path.resolve(__dirname, 'public', 'build');
var srcPath = path.resolve(__dirname, 'frontend');
var mainPath = path.resolve(__dirname, 'frontend', 'index.jsx');
var htmlPath = path.resolve(__dirname, 'frontend', 'index.html');

module.exports = {
  devtool: 'source-map',
  entry: [
    mainPath,
    htmlPath
  ],
  output: {
    path: buildPath,
    filename: 'bundle.js'
  },
  module: {
    loaders: [{
      test: /\.jsx$/,
      include: srcPath,
      loaders: ['babel'],
    }, {
      test: /\.js$/,
      include: srcPath,
      loaders: ['babel'],
    }, {
      test: /\.html$/,
      include: srcPath,
      loader: 'file?name=[name].[ext]',
    }]
  },
  // we only include 'external' section for production, else, react hot loader won't works
  // https://github.com/gaearon/react-hot-loader/issues/53
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
