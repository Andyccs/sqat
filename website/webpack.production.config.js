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
    // you can now require('file') instead of require('file.coffee')
    extensions: ['', '.js', '.jsx']
  },
  plugins: [ 
    new webpack.optimize.DedupePlugin(),
    new webpack.optimize.UglifyJsPlugin(),
    new webpack.DefinePlugin({
      "process.env": {
        // Signal production mode for React JS and other libs.
        NODE_ENV: JSON.stringify("production")
      }
    }),
  ]
};
