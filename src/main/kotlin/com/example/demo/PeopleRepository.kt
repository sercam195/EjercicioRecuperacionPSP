package com.example.demo

import org.springframework.data.jpa.repository.JpaRepository

interface PeopleRepository : JpaRepository<People, Int>