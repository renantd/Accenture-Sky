package br.com.renancsdev.sky.util.imagem

import android.app.Activity
import android.content.Context
import android.widget.ImageView
import br.com.renancsdev.sky.util.intent.Intente
import com.squareup.picasso.Picasso

class PicassoLoad(var context: Context): Intente() {

    fun exibirImagemComPicasso(imagemView: ImageView , tagDoIntent: String){
        var  intent = Intente().pegarStringDoIntent(context as Activity , tagDoIntent)
        Picasso.get().load("https://image.tmdb.org/t/p/original/${ intent }").into(imagemView)
    }

}