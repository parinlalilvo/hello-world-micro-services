package com.aycap.helloworld.services

import com.aycap.helloworld.entity.Hello
import com.aycap.helloworld.repository.HelloRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class HelloService {
    @Autowired
    lateinit var helloRepository: HelloRepository

    fun findAll(): MutableIterable<Hello> {
        return helloRepository.findAll()
    }

    fun findById(id: Int): Hello {
        return helloRepository.findById(id.toLong()).get()
    }

    fun findByName(name: String): Hello {
        return helloRepository.findByName(name)
    }
}