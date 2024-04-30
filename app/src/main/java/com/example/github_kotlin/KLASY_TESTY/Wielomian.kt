package com.example.github_kotlin.KLASY_TESTY

// Zadanie 1
class Wielomian {
    // Lista przechowująca współczynniki wielomianu
    var wspolczynniki:MutableList<Double> = mutableListOf()

    // Konstruktor przyjmujący listę współczynników. Rzuca wyjątek, jeśli lista jest pusta. Usuwa też zerowe współczynniki na końcu wielomianu.
    constructor(nowe_wspolczynniki: MutableList<Double>){
        if (nowe_wspolczynniki.isEmpty()) {
            throw IllegalArgumentException("Lista współczynników nie może być pusta.")
        }
        for (i in nowe_wspolczynniki.size -1 downTo 0){
            if (nowe_wspolczynniki[i] != 0.0){
                wspolczynniki = nowe_wspolczynniki.subList(0,i+1)
                break
            }
        }
    }
    // Funkcja zwracająca stopień wielomianu
    fun stopien_wielomianu():Int{
        return wspolczynniki.size - 1
    }
    // Funkcja zwracająca tekstową reprezentację wielomianu
    fun tekstowa_reprezentacja():String{
        var stopien:Int = wspolczynniki.size - 1
        var reprezentacja:String = "W(x) = "
        for(wspolczynnik in wspolczynniki.reversed()){
           if(stopien == 1){
               reprezentacja += wspolczynnik.toString() + "x + "
           }
            else if(stopien == 0 ) {
               reprezentacja += wspolczynnik.toString()
           }
            else {
               reprezentacja += wspolczynnik.toString() + "x^" + stopien.toString() + " + "
           }
            stopien --
        }
        return reprezentacja
    }
    // Operator pozwalający obliczyć wartość wielomianu dla danej wartości x
    operator fun invoke(x: Double): Double {
        var stopien:Int = wspolczynniki.size - 1
        var suma:Double = 0.0
        for(wspolczynnik in wspolczynniki.reversed()){
            suma += Math.pow(x, stopien.toDouble()) * wspolczynnik
            stopien --
        }
        return suma
    }
    // Operator pozwalający dodać dwa wielomiany
    operator fun plus(inny: Wielomian): Wielomian {
        val noweWspolczynniki = mutableListOf<Double>()
        val maxLength = maxOf(wspolczynniki.size, inny.wspolczynniki.size)
        for (i in 0 until maxLength) {
            val thisVal = wspolczynniki.getOrElse(i) { 0.0 }
            val otherVal = inny.wspolczynniki.getOrElse(i) { 0.0 }
            noweWspolczynniki.add(thisVal + otherVal)
        }
        return Wielomian(noweWspolczynniki)
    }
    // Operator pozwalający odjąć jeden wielomian od drugiego
    operator fun minus (inny: Wielomian): Wielomian {
        val noweWspolczynniki = mutableListOf<Double>()
        val maxLength = maxOf(wspolczynniki.size, inny.wspolczynniki.size)
        for (i in 0 until maxLength) {
            val thisVal = wspolczynniki.getOrElse(i) { 0.0 }
            val otherVal = inny.wspolczynniki.getOrElse(i) { 0.0 }
            noweWspolczynniki.add(thisVal - otherVal)
        }
        return Wielomian(noweWspolczynniki)
    }
    // Operator pozwalający pomnożyć wielomian przez skalar
    operator fun times(mnoznik: Double): Wielomian{
        val nowe_wspolczynniki:MutableList<Double> = mutableListOf()
        for(wspolczynnik in wspolczynniki){
            nowe_wspolczynniki.add(wspolczynnik*mnoznik)
        }
        return Wielomian(nowe_wspolczynniki)
    }
    // Operator pozwalający pomnożyć dwa wielomiany
    operator fun times(inny: Wielomian): Wielomian {
        val noweWspolczynniki = MutableList(stopien_wielomianu() + inny.stopien_wielomianu() + 1) { 0.0 }
        for (i in wspolczynniki.indices) {
            for (j in inny.wspolczynniki.indices) {
                noweWspolczynniki[i + j] += wspolczynniki[i] * inny.wspolczynniki[j]
            }
        }
        return Wielomian(noweWspolczynniki)
    }
}
// Funkcja main prezentująca funkcjonalność klasy Wielomian
fun main (){ // kod prezentujący funkcjonalność klasy Wielomian
    var W1: Wielomian = Wielomian(mutableListOf(1.0, 2.0, 3.0, 4.0))
    println(W1.tekstowa_reprezentacja())

    var W2: Wielomian = Wielomian(mutableListOf(6.0, 5.0, 7.0))
    println(W2.tekstowa_reprezentacja())

    var W3: Wielomian = W1 - W2
    println(W3.tekstowa_reprezentacja())

    var W4: Wielomian = W1 + W2
    println(W4.tekstowa_reprezentacja())

    var W5: Wielomian = W1 * 6.0
    println(W5.tekstowa_reprezentacja())

    var W6: Wielomian = W1 * W2
    println(W6.tekstowa_reprezentacja())
}
