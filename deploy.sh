#!/bin/bash -e

# When run under interactive mode, bashrc wont run
export NVM_DIR="/home/ubuntu/.nvm"
[ -s "$NVM_DIR/nvm.sh" ] && . "$NVM_DIR/nvm.sh"  # This loads nvm

pwd=${PWD##/}
root="/home/ubuntu/sqat"

# current working directory must be $root
if [ "$pwd" != "home/ubuntu/sqat" ] 
then
  echo "Changing your working directory to home/ubuntu/sqat"
  cd "$root"
fi

git pull

# Install style checker micro service
cd "${root}/stylechecker"
./gradlew installDist

# Install frontend server
cd "$root/website"
npm install
npm run deploy

# Stop all forever process
forever stopall

# Start frontend server
cd "$root/website"
NODE_ENV=production PORT=4000 forever start ./backend/babel_index.js

# Start stylechecker microservice
cd "${root}/stylechecker"
cd build/install/sqat-stylechecker/bin
forever start -c bash sqat-stylechecker

forever list
