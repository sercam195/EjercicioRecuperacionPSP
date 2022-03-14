package com.example.demo

import okhttp3.OkHttpClient
import okhttp3.Request
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

@Configuration
class Database {
    @Bean
    fun initDatabase(peopleRepository: PeopleRepository): CommandLineRunner {
        return CommandLineRunner {
            println("Llenando base de datos")
            llenarBaseDeDatos(peopleRepository, "https://swapi.dev/api/people/")
            println("Base de datos llena")
        }
    }

    fun llenarBaseDeDatos(peopleRepository: PeopleRepository, link: String) {
        val client = OkHttpClient()
        val request = Request.Builder()
        request.url(link)

        val call = client.newCall(request.build())
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println(e.toString())
            }

            override fun onResponse(call: Call, response: Response) {
                println(response.toString())
                response.body?.let { responseBody ->
                    val body = responseBody.string()
                    val gson = Gson()
                    println(body)
                    val res = gson.fromJson(body, Resultado::class.java)
                    res.results.forEach {
                        peopleRepository.save(it)
                    }
                }
            }
        })
    }
}