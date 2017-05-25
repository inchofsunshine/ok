package com.alu.test.okletusgo.kotlin.inter

import com.alu.test.okletusgo.kotlin.data.User
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Alu on 2017/5/24.
 * 版本：V1.0
 */
interface GitHubService {
    @GET("/repos/enbandari/Kotlin-Tutorials/stargazers")
    fun getStarGazers(): Call<List<User>>
}