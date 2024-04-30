package com.example.github_kotlin.KLASY_TESTY

import kotlin.test.Test
import kotlin.test.assertEquals

// Testy zadanie 1
class wielomianTests {
    // Testowanie wywołania wielomianu jako funkcji
    @Test
    fun testWywolania() {

        // Tworzenie wielomianu
        val wielomian = Wielomian(mutableListOf(2.0, 3.0, 1.0)) // x^2 + 3x + 2

        // Obliczenie wartości wielomianu dla x = 2
        val wynik = wielomian(2.0) // Powinno zwrócić 2 + 3*2 + 2^2 = 12
        println("Wielomian: ${wielomian.tekstowa_reprezentacja()} dla wartosci x = 2.0 wynosi: $wynik")

        // Sprawdzenie poprawności wyniku
        assertEquals(12.0, wynik, 0.001)
    }
    @Test
    fun testDodawania() {
        // Tworzenie wielomianów do dodania
        val W1 = Wielomian(mutableListOf(2.0, 3.0, 1.0)) // x^2 + 3x + 2
        val W2 = Wielomian(mutableListOf(10.0, 8.0)) // 8x + 10

        // Dodawanie wielomianów
        val W3 = W1 + W2 // x^2 +11x + 12
        val wynik:Double = W3(2.0) // Powinno zwrócić 38
        println("Wielomian: ${W3.tekstowa_reprezentacja()} dla wartosci x = 2.0 wynosi: $wynik")

        // Sprawdzenie poprawności wyniku
        assertEquals(38.0, wynik, 0.001)
    }
    @Test
    fun testOdejmowania() {
        // Tworzenie wielomianów do odejmowania
        val W1 = Wielomian(mutableListOf(2.0, 3.0, 1.0)) // x^2 + 3x + 2
        val W2 = Wielomian(mutableListOf(10.0, 8.0)) // 8x + 10

        // Odejmowanie wielomianów
        val W3 = W1 - W2 // x^2 - 5x - 8
        val wynik:Double = W3(2.0) // Powinno zwrócić -14
        println("Wielomian: ${W3.tekstowa_reprezentacja()} dla wartosci x = 2.0 wynosi: $wynik")

        // Sprawdzenie poprawności wyniku
        assertEquals(-14.0, wynik, 0.001)
    }

    // Testowanie mnożenia wielomianu przez skalar
    @Test
    fun testMnozeniaSkalarnego() {
        // Tworzenie wielomianu do mnożenia
        val W1 = Wielomian(mutableListOf(2.0, 3.0, 1.0)) // x^2 + 3x + 2

        // Mnożenie wielomianu przez skalar
        val W3 = W1 * 2.0 // 2x^2 + 6x + 4
        val wynik:Double = W3(2.0) // Powinno zwrócić 24
        println("Wielomian: ${W3.tekstowa_reprezentacja()} dla wartosci x = 2.0 wynosi: $wynik")

        // Sprawdzenie poprawności wyniku
        assertEquals(24.0, wynik, 0.001)
    }

    // Testowanie mnożenia dwóch wielomianów
    @Test
    fun testMnozeniaWektorowego() {
        // Tworzenie wielomianów do mnożenia
        val W1 = Wielomian(mutableListOf(2.0, 3.0, 1.0)) // x^2 + 3x + 2
        val W2 = Wielomian(mutableListOf(10.0, 8.0)) // 8x + 10

        // Mnożenie wielomianów
        val W3 = W1 * W2 // 8x^3 + 34x^2 + 46x + 20
        val wynik:Double = W3(2.0) // Powinno zwrócić 312
        println("Wielomian: ${W3.tekstowa_reprezentacja()} dla wartosci x = 2.0 wynosi: $wynik")

        // Sprawdzenie poprawności wyniku
        assertEquals(312.0, wynik, 0.001)
    }

    // Testowanie obliczenia stopnia wielomianu
    @Test
    fun testStopienWielomianu (){
        // Tworzenie wielomianu
        val W1 = Wielomian(mutableListOf(2.0, 3.0, 1.0)) // x^2 + 3x + 2

        // Obliczenie stopnia wielomianu
        val wynik: Int = W1.stopien_wielomianu()
        println("Wielomian: ${W1.tekstowa_reprezentacja()} ")

        // Sprawdzenie poprawności wyniku (stopień 2)
        assertEquals(2, wynik)
    }
}

// Testy zadanie 2

// Klasa testowa dla operacji na sekwencji DNA
class DNAtest {
    // Testowanie generowania nici komplementarnej do DNA
    @Test
    fun testComplement() {
        // Przykładowa sekwencja DNA
        val src = "TACCCGTTGATT"

        // Oczekiwana sekwencja nici komplementarnej
        val expected = "ATGGGCAACTAA"

        // Tworzenie obiektu sekwencji DNA
        var DNA1 = DNASequence("DNA1", src)

        // Generowanie nici komplementarnej
        val wynik = DNA1.complement()
        println("Nić komplementarna do DNA: $src to: $expected")

        // Weryfikacja poprawności wyniku
        assertEquals(expected, wynik)
    }

    // Testowanie transkrypcji DNA na RNA
    @Test
    fun testTranscript(){
        // Przykładowa sekwencja DNA
        val src = "TACCCGTTGATT"

        // Oczekiwana sekwencja RNA po transkrypcji
        val expected = "AUGGGCAACUAA"

        // Tworzenie obiektu sekwencji DNA
        var DNA1 = DNASequence("DNA1", src)

        // Transkrypcja DNA na RNA
        var RNA = DNA1.transcribe()
        println("Nić komplementarna do DNA: $src to: $expected")

        // Weryfikacja poprawności wyniku
        assertEquals(expected, RNA.data)
    }

    // Testowanie mutacji sekwencji DNA
    @Test
    fun testMutate() {
        // Przykładowa sekwencja DNA
        val src = "TACCCGTTGATT"

        // Oczekiwana sekwencja DNA po mutacji
        val expected = "AACCCGTTGATT"

        // Tworzenie obiektu sekwencji DNA
        var DNA1 = DNASequence("DNA1", src)

        // Wprowadzenie mutacji
        DNA1.mutate(1, 'A')
        println("Nić komplementarna do DNA: $src to: $expected")

        // Weryfikacja poprawności wyniku
        assertEquals(expected, DNA1.data)
    }
}

// Klasa testowa dla operacji na sekwencji RNA
class RNAtest {
    // Testowanie transkrypcji RNA na sekwencję białka
    @Test
    fun testTranscript(){
        // Przykładowa sekwencja RNA
        val src = "AUGCCGAAAUAA"

        // Oczekiwany ciąg aminokwasów po transkrypcji
        val expected = "PK"

        // Tworzenie obiektu sekwencji RNA
        var RNA1 = RNASequence("RNA1", src)

        // Transkrypcja RNA na sekwencję białka
        var P = RNA1.transcribe()
        println("Nić komplementarna do RNA: $src to: $expected")

        // Weryfikacja poprawności wyniku
        assertEquals(expected, P.data)
    }

    // Testowanie mutacji sekwencji RNA
    @Test
    fun testMutate() {
        // Przykładowa sekwencja RNA
        val src = "UACCCGUUGAUU"

        // Oczekiwana sekwencja RNA po mutacji
        val expected = "AACCCGUUGAUU"

        // Tworzenie obiektu sekwencji RNA
        var RNA1 = RNASequence("RNA1", src)

        // Wprowadzenie mutacji
        RNA1.mutate(1, 'A')
        println("Nić komplementarna do DNA: $src to: $expected")

        // Weryfikacja poprawności wyniku
        assertEquals(expected, RNA1.data)
    }
}

// Klasa testowa dla operacji na sekwencji białka
class Proteintest {
    // Testowanie mutacji sekwencji białka
    @Test
    fun testMutate() {
        // Przykładowa sekwencja białka
        val src = "GNGN"

        // Oczekiwana sekwencja białka po mutacji
        val expected = "KNGN"

        // Tworzenie obiektu sekwencji białka
        var P = ProteinSequence("P", src)

        // Wprowadzenie mutacji
        P.mutate(1, 'K')
        println("Nić komplementarna do DNA: $src to: $expected")

        // Weryfikacja poprawności wyniku
        assertEquals(expected, P.data)
    }

}