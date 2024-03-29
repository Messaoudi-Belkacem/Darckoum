package com.example.darckoum.api

import com.example.darckoum.util.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val announcementService: AnnouncementService by lazy {
        retrofit.create(AnnouncementService::class.java)
    }

    val authenticationService: AuthenticationService by lazy {
        retrofit.create(AuthenticationService::class.java)
    }
}