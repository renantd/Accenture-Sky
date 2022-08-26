package br.com.renancsdev.sky.ui.activity

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import br.com.renancsdev.sky.R
import br.com.renancsdev.sky.databinding.ActivityDetalheFilmesBinding
import br.com.renancsdev.sky.extension.esconder
import br.com.renancsdev.sky.extension.mostar
import br.com.renancsdev.sky.util.imagem.GlideImagem
import br.com.renancsdev.sky.util.imagem.PicassoLoad
import br.com.renancsdev.sky.util.intent.Intente
import br.com.renancsdev.sky.util.textview.ViewTela
import br.com.renancsdev.sky.viewmodel.detalhe.DetalheViewModel

class DetalheFilmes : AppCompatActivity() {

    private lateinit var  detalheFilmesBinding: ActivityDetalheFilmesBinding
    private lateinit var  detalheViewModel : DetalheViewModel

    private lateinit var  intentCustom : Intente
    private lateinit var  glideCustom  : GlideImagem
    private lateinit var  viewTela     : ViewTela
    private lateinit var  imagemLoad   : PicassoLoad
    private var context:  Context       = this@DetalheFilmes
    private var activity: Activity      = context as Activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        inicializarLayout()
        inicializarViewModel()

        iniciarInstancias()
        //exibirNomeEDescricaoDoFilme()
        passarOsDadosParaViewModel()
        exibirFotoDoFilme()

    }
    //  Layout
    fun inicializarLayout(){
        inicializarMainLayout()
        inicializarDataBindingMainActivityLayout()
    }
    fun inicializarMainLayout(){
        setContentView(R.layout.activity_detalhe_filmes)
    }
    fun inicializarDataBindingMainActivityLayout(){
        detalheFilmesBinding = DataBindingUtil.setContentView(this@DetalheFilmes , R.layout.activity_detalhe_filmes)
    }

    // ViewModel
    fun configurarViewModel(){
        detalheViewModel = DetalheViewModel()
        detalheFilmesBinding.detalheViewModel = detalheViewModel
        detalheFilmesBinding.lifecycleOwner = activity as AppCompatActivity

    }
    fun inicializarViewModel(){
        configurarViewModel()
        observadorNomeFilmes(detalheViewModel.nomeDoFilme)
        observadorDescricaoFilme(detalheViewModel.descricaoFilme)
    }
    fun observadorNomeFilmes(variavelDoViewModel: MutableLiveData<String>){
        val nameObserver = Observer<String> { newName ->
            detalheFilmesBinding.detalheVideoNome.text = "$newName\n"
        }
        variavelDoViewModel.observe(this, nameObserver)
    }
    fun observadorDescricaoFilme(variavelDoViewModel: MutableLiveData<String>){
        val nameObserver = Observer<String> { newName ->
            detalheFilmesBinding.detalheVideoDescricao.text = "$newName\n"
        }
        variavelDoViewModel.observe(this, nameObserver)
    }

    //Setar dados dos campos
    fun passarOsDadosParaViewModel(){
        detalheViewModel.nomeDoFilme.value     = intentCustom.pegarStringDoIntent(activity , "filmeNome")
        detalheViewModel.descricaoFilme.value  = intentCustom.pegarStringDoIntent(activity , "filmeDescricao")
    }



    // Classes
    fun iniciarInstancias(){

        intentCustom = Intente()
        glideCustom  = GlideImagem()
        viewTela     = ViewTela()
        imagemLoad   = PicassoLoad(context)

    }

    //TextView
    fun exibirNomeEDescricaoDoFilme(){
        detalheFilmesBinding.detalheVideoNome.text       = intentCustom.pegarStringDoIntent(activity , "filmeNome")
        detalheFilmesBinding.detalheVideoDescricao.text  = intentCustom.pegarStringDoIntent(activity , "filmeDescricao")
    }

    //ImagemView
    fun exibirFotoDoFilme(){
        imagemLoad.exibirImagemComPicasso( detalheFilmesBinding.detalheVideoWallpapper , "filmeFoto")
        imagemLoad.exibirImagemComPicasso( detalheFilmesBinding.detalheVideoThumb , "filmeFoto")
    }


}