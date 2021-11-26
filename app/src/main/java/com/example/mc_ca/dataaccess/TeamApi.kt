package com.example.mc_ca.dataaccess

import com.example.mc_ca.data.TeamEntity
import retrofit2.Response
import retrofit2.http.GET

interface TeamApi {

    // I simply get the json file, however you will probably have an API endpoint in here from a proper Rest API
    @GET("random/type/general/20")
    suspend fun getJokes() : List<TeamEntity>
}
