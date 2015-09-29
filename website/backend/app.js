import express from 'express';
import http from 'http';
import path from 'path';
import bodyParser from 'body-parser';
import jadeAutoRouting from './jadeAutoRouting';
import submitSourceCode from './submitSourceCode';

let app = express();

// setting port and views
const PORT = process.env.PORT || 8080;
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

// Create and start the server
let server = http.createServer(app);

server.listen(PORT, () =>
  console.info('Express server listening on port ' + PORT));
