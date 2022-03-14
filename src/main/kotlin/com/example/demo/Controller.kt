package com.example.demo

import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
class Controller(
    val peopleRepository: PeopleRepository
) {

    @GetMapping("people")
    fun descargarPeople(): MutableList<People> {
        return peopleRepository.findAll()
    }

    @GetMapping("people/{id}")
    fun peopleId(@PathVariable id: Int): Any {
        if (peopleRepository.findById(id).isEmpty)
            return " PERSONAJE NO ENCONTRDO "
        return peopleRepository.getById(id)
    }

    @PostMapping("insertPeople")
    fun insertPeople(@RequestBody people: People): People {
        peopleRepository.save(people)
        return people
    }
}
