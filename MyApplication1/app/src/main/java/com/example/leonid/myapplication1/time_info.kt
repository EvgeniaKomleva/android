package com.example.leonid.myapplication1.util

fun toText(number: Int): String {
    val (hundreds, units) = Pair(number%1000, number%100)
    return with(StringBuilder()){
        append(when(hundreds){
            900 -> "девятьсот"
            800 -> "восемсот "
            700 -> "семьсот "
            600 -> "шестьсот "
            500 -> "пятьсот "
            400 -> "четыреста "
            300 -> "триста "
            200 -> "двести "
            100 -> "сто "
            else -> ""
        })
        append(when(units) {
            0 -> ""
            1 -> "один"
            2 -> "два"
            3 -> "три"
            4 -> "четыре"
            5 -> "пять"
            6 -> "шесть"
            7 -> "семь"
            8 -> "восемь"
            9 -> "девять"
            10 -> "десять"
            11 -> "одиннадцать"
            12 -> "двенадцать"
            13 -> "тринадцать"
            14 -> "четырнадцать"
            15-> "пятнадцать"
            16 -> "шестнадцать"
            17 -> "семнадцать"
            18-> "восемнадцать"
            19 -> "девятнадцать"
            else -> {
                append(when (units - units % 10) {
                    20 -> "двадцать "
                    30 -> "тридцать "
                    40 -> "сорок "
                    50 -> "пятьдесят "
                    60 -> "шестьдесят "
                    70 -> "семьдесят "
                    80 -> "восемдесят "
                    90 -> "девяносто "
                    else -> throw UnknownError("Very strange number $number")
                })
                toText(units % 10)
            }
        })
    }.toString()
}