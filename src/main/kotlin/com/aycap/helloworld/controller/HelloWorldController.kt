package com.aycap.helloworld.controller

import com.aycap.helloworld.entity.Hello
import com.aycap.helloworld.services.HelloService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController(
        private val helloService: HelloService
) {
    @GetMapping(value = ["/hi"])
    fun hello(): ResponseEntity<Hello> {
        val result = helloService.getMessageById(1)
        return ResponseEntity(result, HttpStatus.OK)
    }
}
