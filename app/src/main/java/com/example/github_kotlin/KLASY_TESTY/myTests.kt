package com.example.github_kotlin.KLASY_TESTY


import kotlin.test.Test
import kotlin.test.assertEquals

// Testy zadanie 1
class wielomianTests {
    @Test
    fun testWywolania() {
        val wielomian = Wielomian(mutableListOf(2.0, 3.0, 1.0)) // x^2 + 3x + 2
        val wynik = wielomian(2.0) // Powinno zwrócić 2 + 3*2 + 2^2 = 12
        println("Wielomian: ${wielomian.tekstowa_reprezentacja()} dla wartosci x = 2.0 wynosi: $wynik")
        assertEquals(12.0, wynik, 0.001)
    }

    @Test
    fun testDodawania() {
        val W1 = Wielomian(mutableListOf(2.0, 3.0, 1.0)) // x^2 + 3x + 2
        val W2 = Wielomian(mutableListOf(10.0, 8.0)) // 8x + 10
        val W3 = W1 + W2 // x^2 +11x + 12
        val wynik:Double = W3(2.0) // Powinno zwrócić 38
        println("Wielomian: ${W3.tekstowa_reprezentacja()} dla wartosci x = 2.0 wynosi: $wynik")
        assertEquals(38.0, wynik, 0.001)
    }

    @Test
    fun testOdejmowania() {
        val W1 = Wielomian(mutableListOf(2.0, 3.0, 1.0)) // x^2 + 3x + 2
        val W2 = Wielomian(mutableListOf(10.0, 8.0)) // 8x + 10
        val W3 = W1 - W2 // x^2 - 5x - 8
        val wynik:Double = W3(2.0) // Powinno zwrócić -14
        println("Wielomian: ${W3.tekstowa_reprezentacja()} dla wartosci x = 2.0 wynosi: $wynik")
        assertEquals(-14.0, wynik, 0.001)
    }

    @Test
    fun testMnozeniaSkalarnego() {
        val W1 = Wielomian(mutableListOf(2.0, 3.0, 1.0)) // x^2 + 3x + 2
        val W3 = W1 * 2.0 // 2x^2 + 6x + 4
        val wynik:Double = W3(2.0) // Powinno zwrócić 24
        println("Wielomian: ${W3.tekstowa_reprezentacja()} dla wartosci x = 2.0 wynosi: $wynik")
        assertEquals(24.0, wynik, 0.001)
    }

    @Test
    fun testMnozeniaWektorowego() {
        val W1 = Wielomian(mutableListOf(2.0, 3.0, 1.0)) // x^2 + 3x + 2
        val W2 = Wielomian(mutableListOf(10.0, 8.0)) // 8x + 10
        val W3 = W1 * W2 // 8x^3 + 34x^2 + 46x + 20
        val wynik:Double = W3(2.0) // Powinno zwrócić 312
        println("Wielomian: ${W3.tekstowa_reprezentacja()} dla wartosci x = 2.0 wynosi: $wynik")
        assertEquals(312.0, wynik, 0.001)
    }

    @Test
    fun testStopienWielomianu (){
        val W1 = Wielomian(mutableListOf(2.0, 3.0, 1.0)) // x^2 + 3x + 2
        val wynik: Int = W1.stopien_wielomianu()
        println("Wielomian: ${W1.tekstowa_reprezentacja()} ")
        assertEquals(2, wynik)
    }

}

// Testy zadanie 2
/*


    println("Utworzenie sekwencji RNA, która jest tranksrypcją DNA1")
    var RNA = DNA1.transcribe()
    println(RNA.toString())

    println("Utworzenie sekwencji tranksrybowanej RNA1 o sekwencji: AUGGGCAACUAA")
    var RNA1 = RNASequence("RNA1", "AUGGGCAACUAA")
    println(RNA1.toString())
    println("Mutacja RNA1 na pozycji 3: 'G' -> 'C'")
    RNA1.mutate(3, 'G')
    println(RNA1.toString())

    println("Utworzenie sekwencji P, która jest tranksrypcją RNA1")
    var P = RNA1.transcribe()
    println(P.toString())

    println("Utworzenie sekwencji tranksrybowanej P1 o sekwencji: GNGN")
    var P1 = ProteinSequence("P1", "GNGN")
    println(P1.toString())
    println("Mutacja P1 na pozycji 3: 'N' -> 'G'")
    P1.mutate(4, 'G')
    println(P1.toString())
*/

class DNAtest {
    @Test
    fun testComplement() {
        val src = "TACCCGTTGATT"
        val expected = "ATGGGCAACTAA"
        var DNA1 = DNASequence("DNA1", src)
        val wynik = DNA1.complement()
        println("Nić komplementarna do DNA: $src to: $expected")
        assertEquals(expected, wynik)
    }

    @Test
    fun testTranscript(){
        val src = "TACCCGTTGATT"
        val expected = "AUGGGCAACUAA"
        var DNA1 = DNASequence("DNA1", src)
        var RNA = DNA1.transcribe()
        println("Nić komplementarna do DNA: $src to: $expected")
        assertEquals(expected, RNA.data)
    }

    @Test
    fun testMutate() {
        val src = "TACCCGTTGATT"
        val expected = "AACCCGTTGATT"
        var DNA1 = DNASequence("DNA1", src)
        DNA1.mutate(1, 'A')
        println("Nić komplementarna do DNA: $src to: $expected")
        assertEquals(expected, DNA1.data)
    }
}

class RNAtest {
    @Test
    fun testTranscript(){
        val src = "AUGCCGAAAUAA"
        val expected = "PK"
        var RNA1 = RNASequence("RNA1", src)
        var P = RNA1.transcribe()
        println("Nić komplementarna do RNA: $src to: $expected")
        assertEquals(expected, P.data)
    }

    @Test
    fun testMutate() {
        val src = "UACCCGUUGAUU"
        val expected = "AACCCGUUGAUU"
        var RNA1 = RNASequence("RNA1", src)
        RNA1.mutate(1, 'A')
        println("Nić komplementarna do DNA: $src to: $expected")
        assertEquals(expected, RNA1.data)
    }

}

class Proteintest {
    @Test
    fun testMutate() {
        val src = "GNGN"
        val expected = "KNGN"
        var P = ProteinSequence("P", src)
        P.mutate(1, 'K')
        println("Nić komplementarna do DNA: $src to: $expected")
        assertEquals(expected, P.data)
    }

}