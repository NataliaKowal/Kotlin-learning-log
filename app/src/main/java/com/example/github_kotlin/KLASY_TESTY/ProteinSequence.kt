package com.example.github_kotlin.KLASY_TESTY

// Klasa ProteinSequence reprezentuje sekwencję białka i rozszerza klasę Sequence
class ProteinSequence: Sequence {
    // Konstruktor klasy ProteinSequence, który przyjmuje identyfikator i dane sekwencji
    constructor(new_identifier:String, new_data:String): super(new_identifier, new_data, listOf(
        // Lista zawiera jednoliterowe oznaczenia aminokwasów, które są dozwolone w sekwencji białka

        'A', // Alanina
        'R', // Arginina
        'N', // Asparagina
        'D', // Kwas asparaginowy (Asparaginian)
        'C', // Cysteina
        'E', // Kwas glutaminowy (Glutaminian)
        'Q', // Glutamina
        'G', // Glicyna
        'H', // Histydyna
        'I', // Izoleucyna
        'L', // Leucyna
        'K', // Lizyna
        'M', // Metionina
        'F', // Fenyloalanina
        'P', // Prolina
        'S', // Seryna
        'T', // Treonina
        'W', // Tryptofan
        'Y', // Tyrozyna
        'V'  // Walina
    )){
    }
    // Format wyjściowy to identyfikator sekwencji białka i dane sekwencji, oddzielone nową linią
    override fun toString():String{
        return ">$identifier\n$data"
    }
}