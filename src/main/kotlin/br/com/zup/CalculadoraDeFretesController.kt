package br.com.zup

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue
import org.slf4j.LoggerFactory
import javax.inject.Inject

@Controller
class CalculadoraDeFretesController(@Inject val gRpcClient: FretesServiceGrpc.FretesServiceBlockingStub) {

    private val logger = LoggerFactory.getLogger(CalculadoraDeFretesController::class.java)
    // endpoint

    @Get("/api/fretes")
    fun calcula(@QueryValue cep: String): FreteResponse {

        logger.info("consumindo o serviço de frete rest")

        // consumir o serviço rest
        val request = CalculaFreteRequest.newBuilder()
            .setCep(cep)
            .build()

        /* responder com os valores calculados, é bem semelhante ao OpenFeign,
         depois que fazemos a configuração,temos que chamá-lo para que haja a requisição
         e o recebimento da resposta*/
        logger.info("Realizando a chamada para o microserviço frete")
        val response = gRpcClient.calculaFrete(request)

        logger.info("Resposta obtida com sucesso da api frete, retornando ao cliente")
        return FreteResponse(cep = response.cep, valor = response.valor)
    }
}

data class FreteResponse(val cep: String, val valor: Double)