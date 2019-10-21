package com.example.desafio_lemobs_mobile_aprendizado.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.desafio_lemobs_mobile_aprendizado.R
import com.example.desafio_lemobs_mobile_aprendizado.domain.repository.LivroRepository
import com.example.desafio_lemobs_mobile_gabarito.api.RestApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val livroRepository = LivroRepository(RestApi.api)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {

            try{
                val listaLivro = livroRepository.getListagemLivro()

                for(item in listaLivro){
                    Log.i("nomeLivro", item.titulo)
                }
            }
            catch (t: Throwable){

                Log.i("error", t.message ?: "")
            }
        }
    }
}
