package com.alu.test.okletusgo.kotlin


import com.alu.test.okletusgo.kotlin.data.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Created by Alu on 2017/5/24.
 * 版本：V1.0
 */
interface GitHubService {
    @GET("/repos/enbandari/Kotlin-Tutorials/stargazers")
    fun getStarGazers(): Call<List<User>>
}

object Service {
    val gitHubService: GitHubService by lazy {
        Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GitHubService::class.java)
    }
}

fun main(args: Array<String>) {
    var i: Int = 0
    Service.gitHubService
            .getStarGazers()
            .execute()
            .body()
            ?.map { println(it)
        i++
        println() }
            ?.size
}