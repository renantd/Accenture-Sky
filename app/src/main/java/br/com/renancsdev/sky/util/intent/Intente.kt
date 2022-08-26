package br.com.renancsdev.sky.util.intent

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.cardview.widget.CardView
import br.com.renancsdev.sky.model.Filmes
import br.com.renancsdev.sky.ui.activity.DetalheFilmes

open class Intente {

    //Intent
    fun abrirDetalhesDoFilme(context: Context, cardFilme: CardView, filmes: Filmes){
        cardFilme.setOnClickListener {

            var intent = Intent(context , DetalheFilmes::class.java)
            intentRedirecionarparTela(context , adicionarDadosNoIntent(intent , filmes))

        }
    }

    fun adicionarDadosNoIntent(intent: Intent, filmes: Filmes): Intent {

        intent.putExtra("filmeNome"      , filmes.title)
        intent.putExtra("filmeFoto"      , filmes.poster_path)
        intent.putExtra("filmeDescricao" , filmes.overview)

        return intent
    }

    fun intentRedirecionarparTela(context: Context, intent: Intent){
        context.startActivity( intent )
    }

    fun pegarStringDoIntent(activity: Activity , tagDoIntent: String): String {
        return activity.intent.getStringExtra(tagDoIntent).toString()
    }

}