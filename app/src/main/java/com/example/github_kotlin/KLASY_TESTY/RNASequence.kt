package com.example.github_kotlin.KLASY_TESTY

class RNASequence:Sequence {
    // kodonyNaAminokwasy zostały wygenerowane za pomocą modelu językowego
    val kodonyNaAminokwasy = mapOf(
        // Alanina
        "GCT" to "A", "GCC" to "A", "GCA" to "A", "GCG" to "A",
        // Arginina
        "CGT" to "R", "CGC" to "R", "CGA" to "R", "CGG" to "R", "AGA" to "R", "AGG" to "R",
        // Asparagina
        "AAT" to "N", "AAC" to "N",
        // Kwas asparaginowy
        "GAT" to "D", "GAC" to "D",
        // Cysteina
        "TGT" to "C", "TGC" to "C",
        // Glutamina
        "CAA" to "Q", "CAG" to "Q",
        // Kwas glutaminowy
        "GAA" to "E", "GAG" to "E",
        // Glicyna
        "GGT" to "G", "GGC" to "G", "GGA" to "G", "GGG" to "G",
        // Histydyna
        "CAT" to "H", "CAC" to "H",
        // Izoleucyna
        "ATT" to "I", "ATC" to "I", "ATA" to "I",
        // Leucyna
        "CTT" to "L", "CTC" to "L", "CTA" to "L", "CTG" to "L", "TTA" to "L", "TTG" to "L",
        // Lizyna
        "AAA" to "K", "AAG" to "K",
        // Metionina (start)
        "ATG" to "M",
        // Fenyloalanina
        "TTT" to "F", "TTC" to "F",
        // Prolina
        "CCT" to "P", "CCC" to "P", "CCA" to "P", "CCG" to "P",
        // Seryna
        "TCT" to "S", "TCC" to "S", "TCA" to "S", "TCG" to "S", "AGT" to "S", "AGC" to "S",
        // Treonina
        "ACT" to "T", "ACC" to "T", "ACA" to "T", "ACG" to "T",
        // Tryptofan
        "TGG" to "W",
        // Tyrozyna
        "TAT" to "Y", "TAC" to "Y",
        // Walina
        "GTT" to "V", "GTC" to "V", "GTA" to "V", "GTG" to "V"
    )

    constructor(new_identifier:String, new_data:String):super(new_identifier,new_data, listOf('A', 'U', 'C', 'G')){
    }

    fun isStartKodon(kodon: String): Boolean {
        return kodon == "AUG"
    }

    fun isStopKodon(kodon: String): Boolean {
        return kodon in listOf("UAA","UAG","UGA" )
    }
    fun transcribe():ProteinSequence{
        var result:String = ""

        var start = data.indexOf("AUG")
        if (start == -1){
            throw IllegalArgumentException("Brak kodonu start")
        }
        var stop = -1
        stop = data.indexOf("UAA")
        if (stop == -1){
            stop = data.indexOf("UAG")
            if (stop == -1){
                stop = data.indexOf("UGA")
                if (stop == -1){
                    throw IllegalArgumentException("Brak kodonu stop")
                }
            }
        }
        if ((stop - start)%3 != 0){
            throw IllegalArgumentException("Pomiedzy startem, a stopem liczba zasad azotowych nie jest podzielna przez 3 ")
        }
        var i:Int = start+3

        while (i < stop - 2){
            var temp:String? = kodonyNaAminokwasy[data.substring(i, i+3)]
            if (temp == null) {
                throw IllegalArgumentException("Brak odpowiadającego aminokwasu sekwencji ${data.substring(i, i+3)}")
            }
            result += temp
            i += 3
        }
        return ProteinSequence(identifier + " transkrybowane", result)
    }
}