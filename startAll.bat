start java -jar service-registry-0.0.1-SNAPSHOT.jar  #eurka - 8761
timeout 10

start java -jar cloud-config-server-0.0.1-SNAPSHOT.jar #spring cloude config server - 9296
timeout 10


start java -jar account-service-0.0.1-SNAPSHOT.jar  # 9001

timeout 10 

start java -jar user-service-0.0.1-SNAPSHOT.jar     # 9002
timeout 10


start java -jar cloud-gateway-0.0.1-SNAPSHOT.jar # spring cloud starter-gateway - 9191
timeout 10


start java -jar hystrix-dashboard-0.0.1-SNAPSHOT.jar  #hstrix - 9295
timeout 10


start java -jar zipkin-server-0.0.1-SNAPSHOT.jar  #9411 
timeout 10