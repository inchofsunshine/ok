package com.alu.test.okletusgo.kotlin.test


/**
 * Created by Alu on 2017/5/24.
 * 版本：V1.0
 */


object Service {
    val gitHubService: com.alu.test.okletusgo.kotlin.inter.GitHubService by lazy {
        retrofit2.Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
                .build()
                .create(com.alu.test.okletusgo.kotlin.inter.GitHubService::class.java)
    }
}

fun main(args: Array<String>) {
    print(
            com.alu.test.okletusgo.kotlin.test.Service.gitHubService
                    .getStarGazers()
                    .execute()
                    .body()
                    ?.map {
                        println(it)
                    }
                    ?.size.toString().plus("人star"))
}












/**
 * 打印 1 2 3 4 5
 */
//fun print1_5() {
//    for (x in 1..5) {
//        println(x)
//    }
//}
