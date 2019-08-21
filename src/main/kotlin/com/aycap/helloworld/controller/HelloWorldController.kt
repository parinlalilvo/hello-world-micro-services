package com.aycap.helloworld.controller

import com.aycap.helloworld.repository.HelloRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController(
        private val helloRepository: HelloRepository
) {
    @GetMapping(value = ["/hi"])
    fun hello(): ResponseEntity<String> {
        val hello = helloRepository.findById(1L).get()
        return ResponseEntity(hello.name, HttpStatus.OK)
    }
}
