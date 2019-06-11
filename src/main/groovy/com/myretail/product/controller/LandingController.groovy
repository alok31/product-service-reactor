package com.myretail.product.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class LandingController {

    @GetMapping('/')
    String landingPage() {
        return 'welcome'
    }
}
