package com.myretail.product

import com.mongodb.MongoClient
import com.myretail.product.entity.Product
import com.myretail.product.repository.ProductReactorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import reactor.core.publisher.Flux

@SpringBootApplication
class ProductServiceReactorApplication implements CommandLineRunner {

    static void main(String[] args) {
        SpringApplication.run(ProductServiceReactorApplication, args)
    }

    @Autowired
    MongoClient mongoClient

    @Autowired
    ProductReactorRepository productReactorRepository

    @Override
    void run(String... args) {
        Product p1 = new Product(id: 123, name: 'test1', price: [currentPrice: 12.99, currencyCode: 'USD'])
        Product p2 = new Product(id: 456, name: 'test2', price: [currentPrice: 99.99, currencyCode: 'USD'])
        productReactorRepository.deleteAll()
        productReactorRepository.saveAll(Flux.just(p1, p2)).subscribe()
    }
}
