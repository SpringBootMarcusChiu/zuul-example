article: http://confluence.marcuschiu.com/x/6wRDAQ

## Run Zuul & Api Servers

run zuul gateway proxy
- mvn spring-boot:run -Dspring-boot.run.profiles=zuul -Dstart-class=com.marcuschiu.zuulexample.zuul.ZuulExampleApplication

run api server
- mvn spring-boot:run -Dspring-boot.run.profiles=api -Dstart-class=com.marcuschiu.zuulexample.api.ApiApplication

## Test Zuul Gateway Proxy

### Test 1
open browser at:
- http://localhost8080/default/test

this hits the API server directly

### Test 2
open browser at:
- http://localhost:8888/teehee/default/test

this hits the zuul server, which then intercepts it and makes a call to
- http://localhost:8080/default/test

this is because of the `application-zuul.yml` file:
```
zuul:
  routes:
    ...
    teehee:
      path: /teehee/**
      url: http://localhost:8080
```

### Test 3
open browser at:
- http://localhost:8888/default/test

this hits the zuul server, which then intercepts it and makes a call to
- http://localhost:8080/default/test

this is because of the `application-zuul.yml` file:
```
zuul:
  routes:
    foos:
      path: /default/test
      url: http://localhost:8080
```