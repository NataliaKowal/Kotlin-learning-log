package com.example.github_kotlin.KLASY

/**
 * @author Natalia Kowal
 */

import kotlin.test.Test
import kotlin.test.assertEquals

//zadanie 1
fun heron (a: Double, b: Double, c: Double) : Double {
    if (a + b > c && a + c > b) {
        var p = (a + b + c) / 2
        var S = Math.sqrt(p * (p - a) * (p - b) * (p - c))
        return S
    }
    else {
        throw Exception("Z tych bokow nie da sie zrobic trojkata")
    }
}

////zadanie 2
fun wspolne (x:MutableList<Int>, y:MutableList<Int>) : MutableList<Int>{
    var wynik: MutableList<Int> = mutableListOf()

    for(i:Int in 0..x.size-1) {
        for(j:Int in 0..y.size-1) {
            if (x[i] == y[j]) {
                wynik.add(x[i])
                break
            }
        }
    }
    return wynik
}


// zadanie 4
fun Fib(n:Int) : MutableList<Int>{
    if (n < 1) {
        throw Exception("Nie jest wieksze lub rowne 1")
    }

    var a = mutableListOf(1)
    if (n == 1) {
        return a
    }
    a.add(1)
    if (n == 2) {
        return a
    }

    for(i:Int in 2..n-1){
        a.add(a[i-1] + a[i-2])
    }
    return a
}

fun Fib_rec(n:Int): Int{
    if (n <= 1) {
        return 1
    }
    else {
        return Fib_rec(n - 1) + Fib_rec(n - 2)
    }
}

fun Fib_Recursive(n:Int) : MutableList<Int> {
    if (n <= 1) {
        throw Exception("Nie jest wieksze lub rowne 1")
    }
    var a= mutableListOf<Int>()

    for (i: Int in 0..n-1) {
        a.add(Fib_rec(i))
    }

    return a
}


fun collatz(C0:Int) : MutableList<Int> {
    if (C0 <= 1) {
        throw Exception("$C0 nie jest liczbą naturalną, musi być >= 0")
    }

    var C: MutableList<Int> = mutableListOf(C0)

    var n:Int = 0
    while(true){
        if (n >= 2 && C[n - 2] == 4 && C[n - 1] == 2 && C[n] == 1) {
            break
        }

        if (C[n] % 2 == 0){ // jest parzysty
            C.add(C[n]/2)
        }
        else {   // jest nieparzysty
            C.add(3 * C[n] + 1)
        }
        n++
    }
    return C
}



fun komplement(nic_kodujaca: MutableList<Char>): MutableList<Char> {
    var nowa_nic = mutableListOf<Char>()

    for(i:Int in 0..nic_kodujaca.size - 1){
        nowa_nic.add(when (nic_kodujaca[i]) {
            'A' -> 'T'
            'T' -> 'A'
            'G' -> 'C'
            'C' -> 'G'
            else ->  throw Exception("Błedne dane wejściowe")

        })
    }
    return nowa_nic
}

fun tranksrypcja (nic_kodujaca: MutableList<Char>): MutableList<Char>{
    var nowa_nic = mutableListOf<Char>()

    for(i:Int in 0..nic_kodujaca.size - 1){
        nowa_nic.add(when (nic_kodujaca[i]) {
            'A' -> 'U'
            'T' -> 'A'
            'G' -> 'C'
            'C' -> 'G'
            else -> throw Exception("Błedne dane wejściowe")
        })
    }
    return nowa_nic
}


class myTests {
    @Test
    fun heron_test_1()
    {
        var resoult = heron(3.0, 4.0, 5.0 )
        assertEquals(6.0, resoult)
        println("Test heron(3.0, 4.0, 5.0 ) = $resoult")
    }

    @Test
    fun heron_test_2()
    {
        var resoult = heron(-3.0, 4.0, 5.0 )
        assertEquals(6.0, resoult)
        println("Test heron(-3.0, 4.0, 5.0 ) = $resoult")
    }

    @Test
    fun wspolne_test_1()
    {
        var resoult = wspolne(mutableListOf(1, 2, 3, 4, 6), mutableListOf(1, 6, 15))
        assertEquals(mutableListOf(1, 6), resoult)
        println("Test wspolne(mutableListOf(1, 2, 3, 4, 6), mutableListOf(1, 6, 15)) = $resoult")
    }

    @Test
    fun wspolne_test_2()
    {
        var resoult = wspolne(mutableListOf(1, 2, 3, 4, 6), mutableListOf(10, 9, 15))
        assertEquals(mutableListOf(1, 6), resoult)
        println("Test wspolne(mutableListOf(1, 2, 3, 4, 6), mutableListOf(10, 9, 15)) = $resoult")
    }

    @Test
    fun Fib_loop_test_1()
    {
        var resoult = Fib(2)
        assertEquals(mutableListOf(1,1), resoult)
        println("Test Fib(2) = $resoult")
    }

    @Test
    fun Fib_loop_test_2()
    {
        var resoult = Fib(-2)
    }

    @Test
    fun Fib_recursive_test_1()
    {
        var resoult = Fib_Recursive(5)
        assertEquals(mutableListOf(1, 1, 2, 3, 5), resoult)
        println("Test Fib_Recursive(1, 1, 2, 3, 5) = $resoult")
    }

    @Test
    fun Fib_recursive_test_2()
    {
        var resoult = Fib_Recursive(-3)
    }

    @Test
    fun collatz_test_1()
    {
        var resoult = collatz(4)
        assertEquals(mutableListOf(4, 2, 1), resoult)
        println("Test collatz(4) = $resoult")
    }

    @Test
    fun collatz_test_2()
    {
        var resoult = collatz(-1)
    }

    @Test
    fun komplement_test_1()
    {
        var resoult = komplement(mutableListOf('A', 'C', 'G', 'T'))
        assertEquals(mutableListOf('T','G','C','A'), resoult)
        println("Test komplement (mutableListOf('A', 'C', 'G', 'T')) = $resoult")
    }

    @Test
    fun komplement_test_2()
    {
        var resoult = komplement(mutableListOf('A', 'C', 'G', 'Z'))

    }

    @Test
    fun tranksrypcja_test_1()
    {
        var resoult = tranksrypcja(mutableListOf('A', 'C', 'G', 'T'))
        assertEquals(mutableListOf('U','G','C','A'), resoult)
        println("Test tranksrypcja (mutableListOf('A', 'C', 'G', 'T')) = $resoult")
    }

    @Test
    fun tranksrypcja_test_2()
    {
        var resoult = tranksrypcja(mutableListOf('A', 'C', 'G', 'X'))
    }
}





