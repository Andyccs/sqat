#!/bin/sh

# script for deployment, not tested
cd sqat
git pull

cp sqat-nginx.conf /etc/nginx/sites-enabled/sqat
sudo service nginx restart

cd stylechecker
./gradlew run
cd ../

cd website
nvm use
npm install
npm run deploy
forever npm run start &