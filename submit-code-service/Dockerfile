# You must be in the root directory of this project when building this image
FROM andyccs/sqat-submit-code-service:0.1.0

# Running
WORKDIR /tmp
COPY submit-code-service/package.json /tmp/
RUN npm config set registry http://registry.npmjs.org/ && npm install --production

WORKDIR /usr/src/app
COPY stylechecker/src/main/proto/ /usr/src/app/stylechecker/src/main/proto/
COPY submit-code-service/ /usr/src/app/submit-code-service
RUN cp -a /tmp/node_modules /usr/src/app/submit-code-service

WORKDIR /usr/src/app/submit-code-service

ENV NODE_ENV=production 
ENV PORT=50052

CMD [ "/usr/local/bin/node", "./index.js" ]

EXPOSE 50052