package br.com.renancsdev.sky.util.imagem

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class GlideImagem {

    fun glideParaImagemView(context: Context, url: String, imagem: ImageView){
        Glide.with(context)
            .load("https://image.tmdb.org/t/p/w500${url}")
            .apply(RequestOptions.bitmapTransform(RoundedCorners(10) ))
            .into(imagem)
    }

}