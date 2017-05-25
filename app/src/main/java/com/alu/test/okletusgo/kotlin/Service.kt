package com.alu.test.okletusgo.kotlin


import com.alu.test.okletusgo.kotlin.inter.GitHubService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Alu on 2017/5/24.
 * 版本：V1.0
 */


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
    print(Service.gitHubService
            .getStarGazers()
            .execute()
            .body()
            ?.map {
                println(it)
            }
            ?.size.toString().plus("人star"))
//    /**
//     * 打印 1 2 3 4 5
//     */
//    for (x in 1..5){
//        println(x)
//    }

}