package com.example.demo.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class JSPController {

    @GetMapping("/web")
    fun blog(model: Model): String {
        model["hello"] = "Hello!"
        return "page"
    }
}