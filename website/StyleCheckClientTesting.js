var PROTO_PATH = '../stylechecker/src/main/proto/style_check.proto'

var grpc = require('grpc');
var style_check_proto = grpc.load(PROTO_PATH).stylechecker;

function main() {
    var client = new style_check_proto.StyleCheck(
        'localhost:50051',
        grpc.Credentials.createFake());

    var filePath = "src/test/resources/MethodNameFormatCamelCase.java";
    var configFilePath = "src/test/resources/MethodNameFormatListenerConfig.json";
    var request = {
        filePath: filePath,
        configurationFilePath: configFilePath
    };

    client.check(request, function(err, response) {
        if (err) {
            console.log(err);
            return;
        }
        console.log(response);
    });
}

main();