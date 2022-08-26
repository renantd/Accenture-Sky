package br.com.renancsdev.sky.ui.activity

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import br.com.renancsdev.sky.R
import br.com.renancsdev.sky.api.Api
import br.com.renancsdev.sky.api.Chamada
import br.com.renancsdev.sky.api.ServiceBuilder
import br.com.renancsdev.sky.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private var context:  Context    = this@MainActivity
    private var activity: Activity  = context as Activity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        inicializarLayout()
        populaListaDeFilmes()

    }

    fun populaListaDeFilmes(){
        Chamada(context , mainBinding).verificarRetornoDaApi()
    }

    //  Layout
    fun inicializarLayout(){
        inicializarMainLayout()
        inicializarDataBindingMainActivityLayout()
    }
    fun inicializarMainLayout(){
        setContentView(R.layout.activity_main)
    }
    fun inicializarDataBindingMainActivityLayout(){
        mainBinding = DataBindingUtil.setContentView(activity , R.layout.activity_main)
    }

}