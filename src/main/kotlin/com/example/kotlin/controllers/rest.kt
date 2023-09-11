package com.example.kotlin.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

//@RestController
//@Controller
//class RestController {
//    private val template = "Name:%s,Count:\"%d\""
//    private val counter = AtomicLong()
//
//    @GetMapping("/rest")
//    fun rest(@RequestParam(value = "name", defaultValue = "World") name: String?): String {
//        counter.incrementAndGet()
//        return String.format(template, name, counter.get())
//    }
//}
@RestController
class RESTController {

    val counter = AtomicLong()

    @GetMapping("/rest")
    fun rest(@RequestParam(value = "name", defaultValue = "World") name: String): Encode {
        return Encode(counter.incrementAndGet(), "Hello, $name")
    }
}

data class Encode(val id: Long, val content: String)