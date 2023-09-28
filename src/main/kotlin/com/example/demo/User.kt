package com.example.demo


class User {
    private var id = 0

    override fun toString(): String {
        return String.format("id: %d", id)
    }
}