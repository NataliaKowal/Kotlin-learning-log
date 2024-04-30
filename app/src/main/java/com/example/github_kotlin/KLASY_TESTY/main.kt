package com.example.github_kotlin.KLASY_TESTY

fun main (){
    println("Utworzenie sekwencji DNA1 o sekwencji: TACCCGTTGATT")
    var DNA1 = DNASequence("DNA1", "TACCCGTTGATT")
    println(DNA1.toString())
    println("Nic komplementarna do DNA1 to: ${DNA1.complement()}")
    println("Mutacja DNA1 na pozycji 3: 'C' -> 'G'")
    DNA1.mutate(3, 'G')
    println(DNA1.toString())

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

    println("Utworzenie sekwencji P1 o sekwencji: GNGN")
    var P1 = ProteinSequence("P1", "GNGN")
    println(P1.toString())
    println("Mutacja P1 na pozycji 3: 'N' -> 'G'")
    P1.mutate(4, 'G')
    println(P1.toString())
}

