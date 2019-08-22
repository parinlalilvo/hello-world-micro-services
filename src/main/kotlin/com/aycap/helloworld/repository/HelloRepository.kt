package com.aycap.helloworld.repository

import com.aycap.helloworld.entity.Hello
import org.springframework.data.repository.CrudRepository

interface HelloRepository : CrudRepository<Hello, Long> {
    fun findByName(name: String): Hello
}