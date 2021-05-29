package com.zetzed.santanderdevweek.data

data class Conta (
    val conta: String,
    val agencia: String,
    val saldo: String,
    val limite: String,
    val cliente: Cliente,
    val cartao: Cartao
    )