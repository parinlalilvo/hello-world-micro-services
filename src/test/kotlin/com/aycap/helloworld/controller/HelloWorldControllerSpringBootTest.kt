package com.aycap.helloworld.controller

import com.aycap.helloworld.entity.Hello
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloWorldControllerSpringBootTest {
    @Autowired
    lateinit var testRestTemplate: TestRestTemplate


    @Test
    internal fun name() {
        val actual = testRestTemplate.getForObject("/hi", Hello::class.java)
        assertEquals("hello world", actual.name)
    }
}