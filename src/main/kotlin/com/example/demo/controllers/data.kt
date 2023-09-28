package com.example.demo.controllers

import com.example.demo.User
import jakarta.annotation.PostConstruct
import org.apache.ibatis.io.Resources
import org.apache.ibatis.session.SqlSession
import org.apache.ibatis.session.SqlSessionFactoryBuilder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.io.IOException

@RestController

class DataController {

    var sqls: SqlSession? = null

    @PostConstruct
    @Throws(IOException::class)
    fun init() {
        val config = Resources.getResourceAsStream("mybatis-config.xml")
        sqls = SqlSessionFactoryBuilder().build(config).openSession()
    }

    @GetMapping("/data")
    fun hello(): StringBuilder {
        val list: MutableList<User>? = sqls?.selectList<User>("com.example.demo.UserMapper.selectAll")
        val sb = StringBuilder()
        if (list != null) {
            for (one in list) {
                sb.append(one.toString()).append("\n")
            }
        }
        return sb
    }

}