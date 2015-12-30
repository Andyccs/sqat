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
|-- stylechecker
|
|-- website
|---- backend
|---- frontend
```

Stylechecker folder contains ANTLR and java codes to check and analyze your source code. 

Backend folder contatins a Node.js server that communicate with Stylechecker service and provides an API for clients.

Frontend folder contains a React.js web application that communicate with Backend Node.js server and render webpage for users. 

# How to run this project locally?

We recommended you to run this project using Docker. Please install [Docker Engine](https://docs.docker.com) or “Docker” on [Ubuntu](https://docs.docker.com/engine/installation/ubuntulinux/), [Mac OS X](https://docs.docker.com/engine/installation/mac/), or [Windows](https://docs.docker.com/engine/installation/windows/). 

To run stylechecker:

```Shell
cd stylechecker
docker build -t my-sqat-stylechecker .
docker run --name -p 50051:50051 stylechecker my-sqat-stylechecker &
```

To run website:

```Shell
# You must be in root directory
cp website/Dockerfile . && \
  docker build -t my-sqat . && \
  rm Dockerfile
docker run --name -p 4000:4000 sqatwebsite my-sqat-website &
```

Next, check your docker machine ip address by using:

```Shell
docker-machine url default
# This should show your docker machine ip address, example:
# tcp://192.168.99.100:2376
# where 192.168.99.100 is <your-docker-machine-ip-address>
```

Finally, open your browser and go to `http://<your-docker-machine-ip-address>:4000`. You should see a nice React application in your browser. 

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
