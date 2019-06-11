package com.myretail.product.repository

import com.myretail.product.entity.Product
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductReactorRepository extends ReactiveMongoRepository<Product, Long> {
}
