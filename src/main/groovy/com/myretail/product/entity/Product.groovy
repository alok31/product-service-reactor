package com.myretail.product.entity

import groovy.transform.ToString
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
@ToString
class Product {
    @Id
    Long id
    String name
    Price price

    @Override
    String toString() {
        return "id= $id, name=$name, price=${price.currentPrice}, currency=${price.currentPrice}"
    }
}
