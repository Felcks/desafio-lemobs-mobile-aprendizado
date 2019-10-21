package com.example.desafio_lemobs_mobile_gabarito.api

import com.example.desafio_lemobs_mobile_aprendizado.api_model.LivroDataResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface IRestApi {

    @GET("products.json")
    suspend fun getListagemLivro(): Response<List<LivroDataResponse>>
}