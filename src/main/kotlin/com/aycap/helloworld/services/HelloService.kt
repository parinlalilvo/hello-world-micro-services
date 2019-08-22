package com.aycap.helloworld.services

import com.aycap.helloworld.entity.Hello
import com.aycap.helloworld.repository.HelloRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class HelloService {
    @Autowired
    lateinit var helloRepository: HelloRepository

    fun getMessageById(id: Int): Hello {
        val optionalMessage = helloRepository.findById(1)
        return optionalMessage.get()
    }
}