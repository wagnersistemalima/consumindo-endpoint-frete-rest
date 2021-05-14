# GRPC -> Chamada de Procedimento Remoto
* Framework da google

# Caracteristicas:
* Simple & idiomatic
* Performant & scalable
* Interoperable & extensible
* Funciona em cima do http2 -> https
* Util para microsserviços
* Utiliza protobuf, formato binario para trafegar na rede

### Protobuf
* Uma alternativa para a serialização em JSON e XML
* Ele faz de forma binaria
* Desta forma, os dados ficam bem menores e compactos, e podem ser trafegados muito mais rapidamente, e com menor
custo na rede, persistidos em discos

# consumindo-endpoint-frete-rest
Criação do serviço Grpc rest-frete: porta 50051 para chamadas para o serviço de fretes Grpc porta: 8080.

## Ferramentas

* Application Type: gRPC Application
* Micronaut Version: 2.5.3
* Java Version: 11
* Language: Kotlin
* Build: Gradlle Kotlin
* Test Framework: Junit
