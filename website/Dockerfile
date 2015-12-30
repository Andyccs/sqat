# You must be in the root directory of this project when building this image

FROM andyccs/sqat-website:0.1.0

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

COPY . /usr/src/app
WORKDIR /usr/src/app/website
RUN npm install
RUN npm install grpc@${GRPC_NODE_VERSION}
RUN npm run deploy

ENV NODE_ENV=production 
ENV PORT=4000

#CMD [ "/bin/bash" ]
CMD [ "/usr/local/bin/node", "./backend/babel_index.js" ]
ENTRYPOINT [ "/usr/local/bin/node", "./backend/babel_index.js" ]

EXPOSE 4000