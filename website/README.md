Install [Node Version Manager, nvm](https://github.com/creationix/nvm)

Change to node 0.12.7. Do not use 4.10.0

```
# Since we already define node version in .nvmrc as 0.12.7, 
# you can run the following command to use node 0.12.7
nvm install
nvm use

node --version
# 0.12.7
```

Install GRPC using the following commands:

```shell
brew --prefix
# /usr/local

CXXFLAGS=-I/usr/local/include LDFLAGS=-L/usr/local/lib npm install --global grpc@0.10.2
```
