package br.com.renancsdev.sky.util.textview

import android.widget.TextView

class ViewTela {

    //TextView
    fun mostrarNomeFilme(nomeFilmeView: TextView, texto: String){
        nomeFilmeView.text = "$texto"
    }

}