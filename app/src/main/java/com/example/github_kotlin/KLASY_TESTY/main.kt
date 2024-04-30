package com.example.github_kotlin.KLASY_TESTY

fun main (){
    // Utworzenie i wyświetlenie sekwencji DNA
    println("Utworzenie sekwencji DNA1 o sekwencji: TACCCGTTGATT")
    var DNA1 = DNASequence("DNA1", "TACCCGTTGATT")// Inicjalizacja sekwencji DNA
    println(DNA1.toString())// Wyświetlenie sekwencji DNA

    // Generowanie i wyświetlenie nici komplementarnej do DNA1
    println("Nic komplementarna do DNA1 to: ${DNA1.complement()}")

    // Mutacja sekwencji DNA1 i wyświetlenie zmodyfikowanej sekwencji
    println("Mutacja DNA1 na pozycji 3: 'C' -> 'G'")
    DNA1.mutate(3, 'G')// Mutacja na pozycji 3 z 'C' na 'G'
    println(DNA1.toString())// Wyświetlenie zmodyfikowanej sekwencji DNA

    // Transkrypcja DNA na RNA i wyświetlenie sekwencji RNA
    println("Utworzenie sekwencji RNA, która jest tranksrypcją DNA1")
    var RNA = DNA1.transcribe()// Transkrypcja DNA na RNA
    println(RNA.toString())// Wyświetlenie sekwencji RNA

    // Mutacja sekwencji RNA1 i wyświetlenie zmodyfikowanej sekwencji
    println("Utworzenie sekwencji tranksrybowanej RNA1 o sekwencji: AUGGGCAACUAA")
    var RNA1 = RNASequence("RNA1", "AUGGGCAACUAA")  // Inicjalizacja sekwencji RNA
    println(RNA1.toString()) // Wyświetlenie sekwencji RNA

    // Mutacja sekwencji RNA1 i wyświetlenie zmodyfikowanej sekwencji
    println("Mutacja RNA1 na pozycji 3: 'G' -> 'C'")
    RNA1.mutate(3, 'G')// Mutacja na pozycji 3 z 'G' na 'C'
    println(RNA1.toString()) // Wyświetlenie zmodyfikowanej sekwencji RNA

    // Transkrypcja RNA na sekwencję białka i wyświetlenie sekwencji białka
    println("Utworzenie sekwencji P, która jest tranksrypcją RNA1")
    var P = RNA1.transcribe()// Transkrypcja RNA na białko
    println(P.toString())// Wyświetlenie sekwencji białka

    // Utworzenie i wyświetlenie nowej sekwencji białka
    println("Utworzenie sekwencji P1 o sekwencji: GNGN")
    var P1 = ProteinSequence("P1", "GNGN") // Inicjalizacja sekwencji białka
    println(P1.toString())// Wyświetlenie sekwencji białka

    // Mutacja sekwencji białka P1 i wyświetlenie zmodyfikowanej sekwencji
    println("Mutacja P1 na pozycji 3: 'N' -> 'G'")
    P1.mutate(4, 'G')// Mutacja na pozycji 4 z 'N' na 'G'
    println(P1.toString())// Wyświetlenie zmodyfikowanej sekwencji białka
}

