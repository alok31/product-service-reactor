package com.myretail.product.controller

import com.myretail.product.entity.Product
import com.myretail.product.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping('api/v1/products')
class ProductController {

    @Autowired
    ProductService productService

    @GetMapping('{id}')
    Mono<Product> fetchByID(@PathVariable Long id) {
        productService.findById(id)
    }

    @GetMapping
    Flux<Product> fetchByID() {
        productService.findAll()
    }
}
