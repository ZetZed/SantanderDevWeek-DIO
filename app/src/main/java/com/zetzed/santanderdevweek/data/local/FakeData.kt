package com.zetzed.santanderdevweek.data.local

import com.zetzed.santanderdevweek.data.Cartao
import com.zetzed.santanderdevweek.data.Cliente
import com.zetzed.santanderdevweek.data.Conta

class FakeData {
    fun getLocalData() : Conta {
        val cliente = Cliente("Zet Zed")
        val cartao = Cartao("411573821")
        return Conta(
            "CC 445655-4",
            "Ag 6552-4",
            "R$ 12.450,80",
            "R$ 14.120,00",
            cliente,
            cartao
        )
    }
}