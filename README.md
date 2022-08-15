# Spring Boot + RabbitMQ example

### Starting RabbitMQ
You can use provided docker compose file to start RabbitMQ service:  
`docker-compose up`  
or add `-d` flag to run service in detached mode  
`docker-compose up -d`

### Running examples
#### Exchange types
Use following spring profiles to select exchange type:  
 - `default` - default exchange type
 - `direct` - direct exchange type
 - `fanout` - fanout exchange type
 - `topic` - topic exchange type

#### Application goals
Use following spring profiles in combination with profile for exchange types to make appliation either send messages or receive them:  
 - `direct, sender` - to send messages for `direct` exchange type
 - `direct, consumer` - to receive messages for `direct` exchange type
 
