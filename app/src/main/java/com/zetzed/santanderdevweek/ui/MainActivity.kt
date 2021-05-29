package com.zetzed.santanderdevweek.ui

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.zetzed.santanderdevweek.R
import com.zetzed.santanderdevweek.data.Conta

class MainActivity : AppCompatActivity() {

    //Pagar pegar a classe "MainViewModel"(que está em "MainViewModel.kt")  passando para a variável "mainViewModel"
    private lateinit var mainViewModel: MainViewModel

    //onCreate...
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Quando a tela for criada, define que ele mostre a Toolbar
        setSupportActionBar(findViewById(R.id.toolbar)) //Pega a toolbar pela id"toolbar" que está na "activity_main"

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        buscarContaCliente()
    }

    private fun buscarContaCliente(){
        mainViewModel.buscarContaCliente().observe(this, { result ->
            bindOnView(result)
        })
    }

    private fun bindOnView(conta: Conta){
        findViewById<TextView>(R.id.tv_agencia).text = conta.agencia  //Pega a TextView com id "tv_agencia" da activity_main e coloca o dado "agencia"  que está na classe "FakeData"
        findViewById<TextView>(R.id.tv_conta).text = conta.conta  //Pega a TextView com id "tv_conta" da activity_main e coloca o dado "conta"  que está na classe "FakeData"
        findViewById<TextView>(R.id.tv_saldo).text = conta.saldo  //Pega a TextView com id "tv_saldo" da activity_main e coloca o dado "saldo"  que está na classe "FakeData"
        findViewById<TextView>(R.id.tv_limite).text = conta.limite  //Pega a TextView com id "tv_limite" da activity_main e coloca o dado "limite"  que está na classe "FakeData"
        findViewById<TextView>(R.id.tv_usuario).text = conta.cliente.nome  //Pega a TextView com id "tv_usuario" da activity_main e coloca o dado "nome"  que está na classe "FakeData"
        findViewById<TextView>(R.id.tv_cartao_final_value).text = conta.cartao.numeroCartao  //Pega a TextView com id "tv_cartao_final_value" da activity_main e coloca o dado "numeroCartao"  que está na classe "FakeData"
    }

    //Função para pegar "main_menu" que fica no Diretório "menu" em "res"
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.main_menu, menu)
        return true
    }

    //Função para "verificar ao toque" de qual item do Menu Notification (que fica no canto superior direito da Toolbar)  e fazer uma "ação"
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){ //Quando for clicado no item com id....
            R.id.notification ->{ //Se for clicado no item com o id "notification"
                Log.d("CLICK","Click no item notification") //Dispara um log no console..
                true
            }
            else ->  super.onOptionsItemSelected(item) //Caso não selecione nenhum Item, volta para o inicio da função "onOptionsItemSelected"
        }
    }
}