package br.com.renancsdev.sky.viewmodel.detalhe

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetalheViewModel: ViewModel()  {

    var nomeDoFilme     = MutableLiveData<String>()
    var descricaoFilme  = MutableLiveData<String>()

}