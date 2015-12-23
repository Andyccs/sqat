#!/bin/bash -e

pwd=${PWD##/}
root="/home/ubuntu/sqat"

if [ "$pwd" != "home/ubuntu/sqat" ] 
then
  echo "Changing your working directory to home/ubuntu/sqat"
  cd "$root"
fi

# Stop all forever process
forever stopall

git pull

# run style checker micro service
cd "${root}/stylechecker"
./gradlew installDist
cd build/install/sqat-stylechecker/bin
forever start -c bash sqat-stylechecker

cd "$root/website"
npm install
npm run deploy
NODE_ENV=production PORT=4000 forever start ./backend/babel_index.js

forever list
