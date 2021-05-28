package com.zetzed.santanderdevweek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Quando a tela for criada, define que ele mostre a Toolbar
        setSupportActionBar(findViewById(R.id.toolbar)) //Pega a toolbar pela id"toolbar" que está na "activity_main"
    }


    //Função para pegar "main_menu" que fica no Diretório "menu" em "res"
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.main_menu, menu)
        return true
    }

    //Função para "verificar ao toque" de qual item do Menu (que fica no canto superior direito da Toolbar)  e fazer uma "ação"
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){ //Quando for clicado no item com id....
            R.id.item_1 ->{ //Se for clicado no item com o id "Item_1"
                Log.d("CLICK","Click no item 1") //Dispara um log no console..
                true
            }
            R.id.item_2 ->{ //Se for clicado no item com o id "Item_2"
                Log.d("CLICK","Click no item 2") //Dispara um log no console..
                true
            }
            else ->  super.onOptionsItemSelected(item) //Caso não selecione nenhum Item, volta para o inicio da função "onOptionsItemSelected"
        }
    }
}