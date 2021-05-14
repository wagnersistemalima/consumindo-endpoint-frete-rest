package br.com.zup

import io.grpc.ManagedChannel
import io.micronaut.context.annotation.Factory
import io.micronaut.grpc.annotation.GrpcChannel
import javax.inject.Singleton

// Essa annotation serve para que o Micronaut entenda que essa é uma classe de fábrica
@Factory
class GrpcClientFactory {

    // esta anotação serve para que o micronaut reconheça o metodo

    @Singleton
    fun fretesClientStub(@GrpcChannel("fretes") channel: ManagedChannel): FretesServiceGrpc.FretesServiceBlockingStub? {

        //O @GrpcChannel é uma annotation do Micronaut para facilitar a criação do Client
        // channel = abstração dos detalhes de conecção
        return FretesServiceGrpc.newBlockingStub(channel)
    }
}