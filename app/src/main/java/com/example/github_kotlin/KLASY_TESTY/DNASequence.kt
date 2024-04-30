package com.example.github_kotlin.KLASY_TESTY

import kotlin.test.assertEquals

class DNASequence:Sequence {
    constructor(new_identifier:String, new_data:String):super(new_identifier, new_data, listOf('A', 'T', 'C', 'G')){
    }
    fun complement():String{
        val complementMap = mapOf('A' to 'T', 'T' to 'A', 'C' to 'G', 'G' to 'C')
        var complementData:String = ""
        for(zasada_azotowa in data){
            complementData += complementMap[zasada_azotowa]
        }
        return complementData
    }
    fun transcribe():RNASequence{
        val complementMap = mapOf('A' to 'U', 'T' to 'A', 'C' to 'G', 'G' to 'C')
        var complementData:String = ""
        for(zasada_azotowa in data){
            complementData += complementMap[zasada_azotowa]
        }
        return RNASequence(identifier + " transkrybowane", complementData)
    }
}