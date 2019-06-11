package com.myretail.product.service

import com.myretail.product.entity.Product
import com.myretail.product.repository.ProductReactorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class ProductService {

    @Autowired
    ProductReactorRepository productReactorRepository

    final WebClient webclient

    @Value('${excludes.query.param}')
    String excludesQueryParam

    @Value('${host.url}')
    String baseUrl

    @Value('${path.url}')
    String pathUrl

    ProductService() {
        this.webclient = WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build()
    }

    Mono<Product> findById(Long id) {
        return productReactorRepository.findById(id)
    }

    Flux<Product> findAll() {
        return productReactorRepository.findAll()
    }

    Mono<Product> save(Mono<Product> product) {
        return productReactorRepository.save(product)
    }

//    Mono<Map> fetchProductName(Long productId) {
//        String pathAndQueryParam = "$baseUrl${pathUrl}${excludesQueryParam}"
//        //Mono<ClientResponse> clientResponseMono =
//        //return this.webclient.get().uri(pathAndQueryParam, productId)
//        return ((WebClient.RequestHeadersSpec) webclient.get().uri(pathAndQueryParam, productId))
//                .retrieve().bodyToMono(Map).subscribe()
//    }

}
