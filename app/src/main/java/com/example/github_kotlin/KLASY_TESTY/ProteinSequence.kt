package com.example.github_kotlin.KLASY_TESTY

class ProteinSequence: Sequence {
    constructor(new_identifier:String, new_data:String): super(new_identifier, new_data, listOf(
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

    override fun toString():String{
        return ">$identifier\n$data"
    }

}