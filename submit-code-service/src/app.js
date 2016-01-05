import express from 'express';
import http from 'http';
import path from 'path';
import bodyParser from 'body-parser';
import submitSourceCode from './submitSourceCode';

let app = express();

let isProduction = process.env.NODE_ENV === 'production';

// setting port and views
const PORT = isProduction ? process.env.PORT : 50052;

app.set('port', PORT);

// to support JSON-encoded bodies and URL-encoded bodies
app.use(bodyParser.json({
  limit: '5mb'
}));
app.use(bodyParser.urlencoded({
  extended: true,
  limit: '5mb'
}));

// Routing
app.post('/submitSourceCode', submitSourceCode);

// Create and start the server
let server = http.createServer(app);

server.listen(PORT, () =>
  console.info('submit-code-service server listening on port ' + PORT));
