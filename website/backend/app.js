var express = require('express');
var http = require('http');
var path = require('path');
var jadeAutoRouting = require('./jadeAutoRouting');

var PORT = process.env.PORT || 8080;
var app = express();

app.set('port', PORT);

// public folder
var PUBLIC_DIR = path.join(__dirname, '../public');
var staticDir = express.static(PUBLIC_DIR);

app.use(staticDir);

// Setting view Engine
var VIEWS_PATH = path.join(__dirname, '../views');

app.set('views', VIEWS_PATH);
app.set('view engine', 'jade');

// You can add exlude paths for jade auto routing using regex
jadeAutoRouting(app);

// Routing

// Create and start the server
var server = http.createServer(app);

server.listen(PORT, function() {
  console.info('Express server listening on port ' + PORT);
});
