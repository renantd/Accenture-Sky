package br.com.renancsdev.sky.ui.holder

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import br.com.renancsdev.sky.databinding.ItemListBinding
import br.com.renancsdev.sky.extension.mostar
import br.com.renancsdev.sky.model.Filmes
import br.com.renancsdev.sky.util.imagem.GlideImagem
import br.com.renancsdev.sky.util.intent.Intente
import br.com.renancsdev.sky.util.textview.ViewTela


class RecyclerFilmeViewHolder(private var binding: ItemListBinding): RecyclerView.ViewHolder(binding.root) {

    private lateinit var intentCustom : Intente
    private lateinit var glideCustom  : GlideImagem
    private lateinit var viewTela     : ViewTela
    var context: Context = binding.root.context

    fun bind(filmes: Filmes) {
        iniciarInstancias()
        iniciarServicos(context , filmes)
    }

    fun iniciarInstancias(){

        intentCustom = Intente()
        glideCustom  = GlideImagem()
        viewTela     = ViewTela()

    }
    fun iniciarServicos(context: Context , filmes: Filmes){
        //binding.flSkyFilmesLoading.mostar()
        intentCustom.abrirDetalhesDoFilme(context , binding.cvCardItemFilme , filmes)
        glideCustom.glideParaImagemView(context , filmes.poster_path , binding.skyFilmeFoto)
        viewTela.mostrarNomeFilme(binding.skyFilmeNome , "${filmes.title}")
    }

}