import express from 'express';
import http from 'http';
import path from 'path';
import bodyParser from 'body-parser';
import jadeAutoRouting from './jadeAutoRouting';
import submitSourceCode from './submitSourceCode';
import httpProxy from 'http-proxy';

let app = express();

let isProduction = process.env.NODE_ENV === 'production';

// setting port and views
const PORT = isProduction ? process.env.PORT : 8080;
const VIEWS_PATH = path.join(__dirname, '../views');

app.set('port', PORT);
app.set('views', VIEWS_PATH);
app.set('view engine', 'jade');

// to support JSON-encoded bodies and URL-encoded bodies
app.use(bodyParser.json({
  limit: '5mb'
}));
app.use(bodyParser.urlencoded({
  extended: true,
  limit: '5mb'
}));

// public folder
const PUBLIC_DIR = path.join(__dirname, '../public');
const staticDir = express.static(PUBLIC_DIR);

app.use(staticDir);

// You can add exlude paths for jade auto routing using regex
jadeAutoRouting(app);

// Routing
app.post('/submitSourceCode', submitSourceCode);

let proxy = httpProxy.createProxyServer();

// We only want to run the workflow when not in production
if (!isProduction) {
  // We require the bundler inside the if block because
  // it is only needed in a development environment. Later
  // you will see why this is a good idea
  bundle = require('./bundle.js');
  bundle();

  // Any requests to localhost:3000/build is proxied
  // to webpack-dev-server
  app.all('/build/*', (req, res) => {
    proxy.web(req, res, {
      target: 'http://localhost:8090'
    });
  });

}

// It is important to catch any errors from the proxy or the
// server will crash. An example of this is connecting to the
// server when webpack is bundling
proxy.on('error', (error) => {
  console.log('Could not connect to proxy, please try again...');
});

// Create and start the server
let server = http.createServer(app);

server.listen(PORT, () =>
  console.info('Express server listening on port ' + PORT));
