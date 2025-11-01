package com.example.currency_converter

import org.springframework.stereotype.Component

@Component
class CurrencyUtil{

fun calculateConversion(from: String, to: String, amount: Double): Double {
    /*val rate = when {
        from == "USD" && to == "INR" -> 83.0
        from == "INR" && to == "USD" -> 0.012
        else -> 1.0
    }*/

    val rates = mapOf(
        Pair("USD-INR", 83.0),
        Pair("INR-USD", 0.012),
        Pair("USD-EUR", 0.93),
        Pair("EUR-USD", 1.08)
    )
    val key = "${from.uppercase()}-${to.uppercase()}"
    val rate = rates.getOrDefault(key, 1.0)


    return amount * rate
}



}