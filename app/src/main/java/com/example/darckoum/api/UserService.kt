package com.example.darckoum.api

import com.example.darckoum.data.model.UserResponse
import com.example.darckoum.data.model.request.PatchUserDetailsRequest
import com.example.darckoum.data.model.response.PatchUserDetailsResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.Query

interface UserService {
    @GET("user")
    suspend fun getUserDetails(
        @Header("Authorization") authorizationToken: String,
        @Query("token") token: String
    ): Response<UserResponse>

    @PATCH("user")
    suspend fun patchUserDetails(
        @Header("Authorization") authorizationToken: String,
        @Body patchUserDetailsRequest: PatchUserDetailsRequest
    ): Response<PatchUserDetailsResponse>
}