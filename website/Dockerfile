FROM node:0.12.7

WORKDIR /tmp
COPY package.json /tmp/
RUN npm config set registry http://registry.npmjs.org/ && npm install --production

WORKDIR /usr/src/app
COPY . /usr/src/app/
RUN cp -a /tmp/node_modules /usr/src/app/
RUN npm run deploy

ENV NODE_ENV=production 
ENV PORT=8080

CMD [ "/usr/local/bin/node", "./index.js" ]

EXPOSE 8080
