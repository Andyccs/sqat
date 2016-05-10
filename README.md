[![Build Status](https://travis-ci.org/Andyccs/sqat.svg?branch=develop)](https://travis-ci.org/Andyccs/sqat)

[![Coverage Status](https://coveralls.io/repos/Andyccs/sqat/badge.svg?branch=develop&service=github)](https://coveralls.io/github/Andyccs/sqat?branch=develop)

[![Gitter](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/Andyccs/sqat?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge)

# Software Quality Analysis Tool

Software Quality Analysis Tool (SQAT) allows you to:

1. Check the style of your Java source code

2. Analyze your Java source code and get object-oriented metric reports

This tool is still under active development.

# Project Organisation

This project is organized as:

```
root
|
|-- proxy
|
|-- stylechecker
|
|-- submit-code-service
|
|-- website
```

`proxy` folder contains an Nginx server that serves static contents and redirects requests to appropriate microservices.

`stylechecker` folder contains ANTLR and java codes to check and analyze your source code. 

`submit-code-service` folder contains a microservice that communicate with stylechecker service and provides an API for clients.

`website` folder contains a React.js web application that communicate with Backend Node.js server and render webpage for users. 

# How to run this project locally?

We recommended you to run this project using Docker. Please install [Docker](https://docs.docker.com) on [Ubuntu](https://docs.docker.com/engine/installation/ubuntulinux/), [Mac OS X](https://docs.docker.com/engine/installation/mac/), or [Windows](https://docs.docker.com/engine/installation/windows/). 

## Use Docker Compose to run the project

This is the easiest way to run this project:

```Shell
# Assume that you're in the root directory
# This command will run a bunch of "npm build" commands,
# and finally run "docker compose up" command
sh fast-dc-up.sh
```

## Use `docker` Command

To run proxy:

```Shell
cd proxy
docker build -t my-proxy .
docker run --name proxy -p 80:80 443:443 --link web:web submit-code-service:submit-code-service my-proxy
```

To run stylechecker:

```Shell
cd stylechecker
docker build -t my-sqat-stylechecker .
docker run --name stylechecker -p 50051:50051 my-sqat-stylechecker &
```

To run submit-code-service:

```Shell
# You must be in root directory
cp submit-code-service/Dockerfile . && \
  docker build -t my-submit-code-service . && \
  rm Dockerfile && \
docker run --name submit-code-service --link stylechecker:stylechecker -p 50052:50052 my-submit-code-service &
```

To run website:

```Shell
cd website
docker build -t my-sqat-website . 
docker run --name web -p 8080:8080 my-sqat-website &
```

## Run it locally

We used to run this project locally until we switch our workflow to docker, but we don't stop you to run this project locally. The dockerfiles in this project and [sqat-docker-library](https://github.com/Andyccs/sqat-docker-library) serve as a step-by-step guide to install all dependencies locally in your Linux machines.

## View the application running

Next, check your docker machine ip address by using:

```Shell
docker-machine ip default
```

Finally, open your browser and go to `http://<your-docker-machine-ip-address>`. You should see a nice React application in your browser. 

# Project Report and Presentation

This project is my final year project for Computer Science degree at Nanyang Technological University. The report for this project can be found at [sqat-report](https://github.com/Andyccs/sqat-report) and presentation slides can be found at [sqat-presentation](https://github.com/Andyccs/sqat-presentation)

# License

The MIT License (MIT)

Copyright (c) 2015 Andy Chong Chin Shin

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
