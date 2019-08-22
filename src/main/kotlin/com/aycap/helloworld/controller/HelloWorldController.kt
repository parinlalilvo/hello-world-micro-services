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
    @GetMapping(value = ["/hiAll"])
    fun getHelloAll(): ResponseEntity<MutableIterable<Hello>> {
        val result = helloService.findAll()
        return ResponseEntity(result, HttpStatus.OK)
    }

    @GetMapping(value = ["/hi"], params = ["id"])
    fun getHelloById(id: Int): ResponseEntity<Hello> {
        val result = helloService.findById(id)
        return ResponseEntity(result, HttpStatus.OK)
    }

    @GetMapping(value = ["/hi"], params = ["name"])
    fun getHelloByName(name: String): ResponseEntity<Hello> {
        val result = helloService.findByName(name)
        return ResponseEntity(result, HttpStatus.OK)
    }
}
