package br.com.renancsdev.sky.api

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import br.com.renancsdev.sky.R
import br.com.renancsdev.sky.databinding.ActivityMainBinding
import br.com.renancsdev.sky.extension.esconder
import br.com.renancsdev.sky.extension.mostar
import br.com.renancsdev.sky.model.Filmes
import br.com.renancsdev.sky.model.Result
import br.com.renancsdev.sky.ui.adapter.RecyclerFilmeAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Chamada(var context: Context , var binding: ActivityMainBinding) {

    private val request = ServiceBuilder.buildService(Api::class.java)

    //Api
    fun chamadaDaApi(): Call<Result> = request.pegarFilmesMaisPopulares(context.resources.getString(R.string.api_key))

    fun verificarRetornoDaApi(){
        chamadaDaApi().enqueue(object : Callback<Result> {
            override fun onResponse(call: Call<Result>, response: Response<Result>) {
                if(respostaDaApi(response)){
                    mostrarConteudoDaRespostaDaApi(response , binding)
                }
            }
            override fun onFailure(call: Call<Result>, t: Throwable) {
                Log.e("Repository", "${t.message}")
                Toast.makeText(context , "Failed to get response" , Toast.LENGTH_SHORT).show()
            }
        })
    }
    fun respostaDaApi(resposta: Response<Result>): Boolean{

        var check = false
        if(resposta.isSuccessful) {
            check = true
        }else{
            Log.e("App", "${resposta.errorBody().toString()}")
            Toast.makeText(context , "${resposta.errorBody().toString()}" , Toast.LENGTH_SHORT).show()
        }

        return check
    }
    fun mostrarConteudoDaRespostaDaApi(resposta: Response<Result> , mainBinding: ActivityMainBinding ){

        binding.flSkyFilmesLoading.mostar()
        if (resposta.body() != null) {
            initFilmesAdapter(resposta.body()!!.results , mainBinding )
        } else {
            Log.e("Repository", "Failed to get response")
            Toast.makeText(context , "Failed to get response" , Toast.LENGTH_SHORT).show()
        }
        binding.flSkyFilmesLoading.esconder()
    }

    //Adapter
    fun initFilmesAdapter(filmes: List<Filmes>, binding: ActivityMainBinding): RecyclerFilmeAdapter{
        val adapter = RecyclerFilmeAdapter(filmes)
        val layoutManager = GridLayoutManager(context , 2)
        binding.rvSkyFilmes.layoutManager = layoutManager
        binding.rvSkyFilmes.adapter = adapter
        return adapter
    }


}