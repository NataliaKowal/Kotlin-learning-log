package com.example.github_kotlin.KLASY_TESTY

import kotlin.test.assertEquals

// Klasa DNASequence reprezentuje sekwencję DNA
class DNASequence:Sequence {
    // Konstruktor klasy przyjmujący identyfikator sekwencji i jej dane.
    // Lista ('A', 'T', 'C', 'G') określa dozwolone znaki w sekwencji DNA.
    constructor(new_identifier:String, new_data:String):super(new_identifier, new_data, listOf('A', 'T', 'C', 'G')){
    }

    // Metoda generująca nici komplementarną do danej sekwencji DNA.
    fun complement():String{
        // Mapowanie zasad azotowych DNA na ich komplementarne pary
        val complementMap = mapOf('A' to 'T', 'T' to 'A', 'C' to 'G', 'G' to 'C')

        // Inicjalizacja pustego ciągu na dane nici komplementarnej
        var complementData:String = ""

        // Iteracja przez każdą zasadę azotową w danych sekwencji DNA
        for(zasada_azotowa in data){

            // Dodawanie do ciągu komplementData komplementarnej zasady azotowej zgodnie z mapowaniem
            complementData += complementMap[zasada_azotowa]
        }
        // Zwracanie kompletnej nici komplementarnej
        return complementData
    }

    // Metoda transkrypcji DNA na RNA.
    fun transcribe():RNASequence{
        // Mapowanie zasad azotowych DNA na odpowiadające im zasady azotowe RNA
        val complementMap = mapOf('A' to 'U', 'T' to 'A', 'C' to 'G', 'G' to 'C')

        // Inicjalizacja pustego ciągu na dane RNA
        var complementData:String = ""

        // Iteracja przez każdą zasadę azotową w danych sekwencji DNA
        for(zasada_azotowa in data){ // Dodawanie do ciągu complementData zasady azotowej RNA zgodnie z mapowaniem
            complementData += complementMap[zasada_azotowa]
        }
        // Tworzenie i zwracanie nowego obiektu RNASequence z transkrybowanymi danymi
        return RNASequence(identifier + " transkrybowane", complementData)
    }
}