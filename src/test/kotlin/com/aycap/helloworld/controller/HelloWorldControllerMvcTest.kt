package com.aycap.helloworld.controller

import com.aycap.helloworld.entity.Hello
import com.aycap.helloworld.repository.HelloRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.util.*

@RunWith(SpringRunner::class)
@WebMvcTest(controllers = [HelloWorldController::class])
class HelloWorldControllerMvcTest {
    @Autowired
    lateinit var mvc: MockMvc

    @MockBean
    lateinit var helloRepository: HelloRepository


    @Test
    internal fun name() {
        given(helloRepository.findById(1L)).willReturn(Optional.of(Hello(1L, "mock")))
        mvc.perform(get("/hi"))
                .andExpect(status().isOk)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(content().json("{\"id\":1,\"name\":\"mock\"}"))
    }
}