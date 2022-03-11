package com.example.kotlinaws.client

import aws.sdk.kotlin.runtime.auth.credentials.ProfileCredentialsProvider
import aws.sdk.kotlin.services.s3.S3Client
import aws.sdk.kotlin.services.s3.model.CreateBucketRequest
import aws.sdk.kotlin.services.s3.model.ListObjectsV2Request
import aws.sdk.kotlin.services.s3.model.ListObjectsV2Response
import org.springframework.stereotype.Component

@Component
class Client {

    suspend fun getListOfObjects(bucketName: String): ListObjectsV2Response {
        val request = generateListObjectsRequest(bucketName)
        return s3Client.listObjectsV2(request)
    }

    suspend fun createNewBucket(bucketName: String) {
        val request = CreateBucketRequest {
            bucket = bucketName
        }

        S3Client { region = "eu-west-1" }.use { s3 ->
            s3.createBucket(request)
            println("$bucketName is ready")
        }
    }

    fun generateListObjectsRequest(bucketName: String): ListObjectsV2Request {
        return ListObjectsV2Request { bucket = bucketName }
    }


    private val s3Client = S3Client {
        region = "eu-west-1"
        credentialsProvider = ProfileCredentialsProvider(profileName = "test_sdk")
    }
}