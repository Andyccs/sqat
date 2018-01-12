#!/bin/sh

GREEN='\033[0;32m'
NC='\033[0m'

printf "${GREEN}transpiling submit-code-service${NC}\n"
cd submit-code-service
npm run clean
npm run build
cd ../

printf "${GREEN}Installing website dependencies${NC}\n"
cd website
if test -d node_modules; 
then
  printf "${GREEN}website node_modules exists, skipping npm install${NC}\n"
else 
  npm install
fi && 

printf "${GREEN}transpiling website${NC}\n"
npm run clean-webpack
npm run clean-server
npm run build-server
# Dont build webpack
cd ../

echo " _________________"
echo "< Welcome to SQAT >"
echo " -----------------"
echo "        \   ^__^"
echo "         \  (oo)\_______"
echo "            (__)\       )\/\\"
echo "                ||----w |"
echo "                ||     ||"

docker-compose up
