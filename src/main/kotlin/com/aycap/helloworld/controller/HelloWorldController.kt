package com.aycap.helloworld.controller

import com.aycap.helloworld.entity.Hello
import com.aycap.helloworld.services.HelloService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController(
        private val helloService: HelloService
) {

    private val log = LoggerFactory.getLogger(HelloWorldController::class.java)

    @GetMapping(value = ["/hiAll"])
    fun getHelloAll(): ResponseEntity<MutableIterable<Hello>> {
        log.info("============= Start to say hi all ============= ")
        val result = helloService.findAll()
        log.info("Say hi with result : {}", result)
        log.info("============= End to say hi all ============= ")

        return ResponseEntity(result, HttpStatus.OK)
    }

    @GetMapping(value = ["/hi"], params = ["id"])
    fun getHelloById(id: Int): ResponseEntity<Hello> {
        log.info("============= Start to say hi by id ============= ")
        val result = helloService.findById(id)
        log.info("============= End to say hi by id ============= ")
        return ResponseEntity(result, HttpStatus.OK)
    }

    @GetMapping(value = ["/hi"], params = ["name"])
    fun getHelloByName(name: String): ResponseEntity<Hello> {
        log.info("============= Start to say hi by name ============= ")
        val result = helloService.findByName(name)
        log.info("============= End to say hi by name ============= ")
        return ResponseEntity(result, HttpStatus.OK)
    }
}
