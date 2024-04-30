package com.example.github_kotlin.KLASY_TESTY

// Klasa abstrakcyjna reprezentująca ogólną sekwencję
abstract class Sequence {
    // Identyfikator sekwencji
    var identifier:String
    // Dane sekwencji jako ciąg znaków
    var data:String
    // Lista dozwolonych znaków w sekwencji
    val VALID_CHARS:List<Char>
    // Długość sekwencji
    var length: Int

    // Konstruktor inicjalizujący sekwencję
    constructor(new_identifier:String, new_data:String, new_valid_chars:List<Char>){
        identifier = new_identifier
        data = new_data
        length = data.length
        VALID_CHARS = new_valid_chars
// Sprawdzenie, czy wszystkie znaki w danych są dozwolone
        for (item in data) {
            if (!VALID_CHARS.contains(item)) {
                throw IllegalArgumentException("Sekwencja zawiera niedozwolone znaki: $item")
            }
        }
    }
    // Przesłonięcie metody toString() dla wygodnego wyświetlania sekwencji
    override fun toString():String{
        return ">$identifier\n$data"
    }
    // Funkcja umożliwiająca mutację (zmianę) znaku w określonej pozycji
    fun mutate(position:Int, value:Char){
// Sprawdzenie, czy pozycja jest w granicach sekwencji
        if (position > length || position <= 0) {
            throw IllegalArgumentException("Pozycja $position jest poza granicami [1 : $length]")
        }
        // Sprawdzenie, czy znak jest dozwolony
        if (!VALID_CHARS.contains(value)) {
            throw IllegalArgumentException("Znak: $value nie jest dopusczalny")
        }
        // Zmiana znaku w danej pozycji
        data = data.substring(0, position - 1) + value + data.substring(position)
    }
    // Funkcja szukająca motywu w sekwencji i zwracająca listę pozycji jego wystąpień
    fun findMotif(motif:String): MutableList<Int>{
        var wystapienia:MutableList<Int> = mutableListOf()
        for(i in 0..motif.length - 1){
            var index = data.indexOf(motif, i)
            if (index != -1 ){
                wystapienia.add(i)
            }
        }
        return wystapienia
    }
}