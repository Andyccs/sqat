GREEN='\033[0;32m'
NC='\033[0m'

printf "${GREEN}transpiling submit-code-service${NC}\n"
cd submit-code-service
npm run clean
npm run build
cd ../

printf "${GREEN}transpiling website${NC}\n"
cd website
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
