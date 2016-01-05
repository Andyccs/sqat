var path = require('path');
var webpack = require('webpack');

var nodeModulesPath = path.resolve(__dirname, 'node_modules');
var buildPath = path.resolve(__dirname, 'public', 'build');
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
      test: /\.css$/,
      loader: 'style!css'
    }, {
      // tell webpack to use jsx-loader for all *.jsx files
      test: /\.jsx$/,
      loaders: ['babel']
    }, {
      test: /\.js$/,
      exclude: [nodeModulesPath],
      loaders: ['babel']
    }, {
      test: /\.html$/,
      loader: 'file?name=[name].[ext]',
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
