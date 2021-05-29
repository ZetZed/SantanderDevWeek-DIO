package com.zetzed.santanderdevweek.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zetzed.santanderdevweek.data.Conta
import com.zetzed.santanderdevweek.data.local.FakeData

//Para pegar os dados da pasta "data"
class MainViewModel : ViewModel() {

    //LiveData = Passa dados..... MutableLiveData = passa os dados, porém os dados passados podem ser mutáveis..
    private val mutableLiveData: MutableLiveData<Conta> = MutableLiveData() //Pega as variáveis da classe "Conta", na variável "mutableLiveData" e define como MutableLiveData()... para em breve colocar os dados que estão na classe "FakeData"

    //Cria Função do tipo "LiveData" com as variáveis da classe"Conta"
    fun buscarContaCliente() : LiveData<Conta> {
        mutableLiveData.value = FakeData().getLocalData() //Coloca os dados que estão na classe "FakeData" , função "getLocalData" e passa para o "mutableLiveData"...

        return mutableLiveData
    }
}
