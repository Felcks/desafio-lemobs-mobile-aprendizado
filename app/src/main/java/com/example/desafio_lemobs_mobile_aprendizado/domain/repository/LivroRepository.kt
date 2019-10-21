package com.example.desafio_lemobs_mobile_aprendizado.domain.repository

import com.example.desafio_lemobs_mobile_aprendizado.api_model.LivroDataResponse
import com.example.desafio_lemobs_mobile_aprendizado.domain.model.Livro
import com.example.desafio_lemobs_mobile_gabarito.api.IRestApi
import retrofit2.Response
import java.util.*

class LivroRepository(private val api: IRestApi){

    suspend fun getListagemLivro(): List<Livro> {

        val response = api.getListagemLivro()

        if(!response.isSuccessful)
            throw Throwable(response.errorBody()?.string())

        return api.getListagemLivro().body()?.map {
            Livro(
                it.title ?: "",
                it.price ?: 0.0,
                it.writer ?: "",
                it.thumbnailHd ?: "",
                Date()
            )
        } ?: listOf()

    }
}