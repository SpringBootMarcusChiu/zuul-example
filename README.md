## Run Zuul & Api Servers

run zuul gateway proxy
- mvn spring-boot:run -Dspring-boot.run.profiles=zuul -Dstart-class=com.marcuschiu.zuulexample.zuul.ZuulExampleApplication

run api server
- mvn spring-boot:run -Dspring-boot.run.profiles=api -Dstart-class=com.marcuschiu.zuulexample.api.ApiApplication

## Test Zuul Gateway Proxy
open browser at:
- http://localhost:8888/foos/default/

zuul server intercepts it and makes a call to
- http://localhost:8080/default