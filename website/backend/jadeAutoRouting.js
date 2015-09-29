import dir from 'node-dir';
import path from 'path';

const VIEWS_PATH = path.join(__dirname, '../views');

export default function jadeAutoRouting(app, excludePattern) {
  dir.readFilesStream(VIEWS_PATH, {match: /.jade$/},
    (err, stream, filename, next) => {
      if(err) {
        console.log(err);
        return;
      }

      let fileNameWithExtension = path.basename(filename);
      let fileNameWithoutExtension = path.basename(filename, '.jade');

      if(excludePattern != null &&
        fileNameWithExtension.match(excludePattern)) {
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
    }, (err, files) => {
      if(err) {
        console.log(err);
        return;
      }
      console.log('✔ Jade auto routing done');
    }
  );
}
