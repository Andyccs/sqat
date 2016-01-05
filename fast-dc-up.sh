cd submit-code-service
npm run clean
npm run build
cd ../

cd website
npm run clean-webpack
npm run clean-server
npm run build-server
# Dont build webpack
cd ../

docker-compose up