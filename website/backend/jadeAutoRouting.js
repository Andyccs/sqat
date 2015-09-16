var dir = require('node-dir');
var path = require('path');

function jadeAutoRouting(app, excludePattern) {
  dir.readFilesStream(path.join(__dirname, '../views'), {
    match: /.jade$/,
  }, function(err, stream, filename, next) {
    if(err) {
      console.log(err);
      return;
    }

    var fileNameWithExtension = path.basename(filename);
    var fileNameWithoutExtension = path.basename(filename, '.jade');

    if(excludePattern != null && fileNameWithExtension.match(excludePattern)) {
      return;
    }
    console.log('Auto route to: ./' + fileNameWithoutExtension);

    app.get('/' + fileNameWithoutExtension, function(req, resp) {
      resp.render(fileNameWithoutExtension);
    });

    if(fileNameWithoutExtension == 'index') {
      app.get('/', function(req, resp) {
        resp.render(fileNameWithoutExtension);
      });
    }

    next();
  }, function(err, files) {
    if(err) {
      console.log(err);
      return;
    }
    console.log('✔ Jade auto routing done');
  });
}

module.exports = jadeAutoRouting;