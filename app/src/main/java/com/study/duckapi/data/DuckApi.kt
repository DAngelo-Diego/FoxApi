package com.study.duckapi.data

import com.study.duckapi.data.remote.response.ResponseDto
import retrofit2.http.GET

interface DuckApi {

    @GET("/floof/")
    suspend fun fetchDuckApiFromData(): ResponseDto

}