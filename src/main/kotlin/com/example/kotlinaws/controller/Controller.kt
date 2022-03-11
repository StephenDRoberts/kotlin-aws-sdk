package com.example.kotlinaws.controller

import com.example.kotlinaws.client.Client
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller(
    private val client: Client
) {

    @GetMapping("/")
    fun getResponse(@RequestParam() bucketName: String): String {

//        val objects = client.getListOfObjects(bucketName)

        return bucketName
    }


    @PostMapping("/create")
    suspend fun createBucket(@RequestParam() bucketName: String) {
        client.createNewBucket(bucketName)
    }

}