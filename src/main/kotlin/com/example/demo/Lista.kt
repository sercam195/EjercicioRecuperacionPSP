package com.example.demo

import com.google.gson.Gson

class Lista {
    companion object{
        var lista= mutableListOf<Any>()
    }
    override fun toString(): String {
        val gson= Gson()
        return gson.toJson(this)
    }
}