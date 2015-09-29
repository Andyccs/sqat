Install [Node Version Manager, nvm](https://github.com/creationix/nvm)

Change to node 0.12.7. Do not use 4.10.0

```
nvm install 0.12.7
nvm use 0.12.7

node --version
# 0.12.7
```

Install GRPC using the following commands:

```shell
brew --prefix
# /usr/local

CXXFLAGS=-I/usr/local/include LDFLAGS=-L/usr/local/lib npm install --global grpc@0.10.2
```