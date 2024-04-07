package com.example.github_kotlin.KLASY

open class Car: Vehicle {
    var imie:String? = null
    var nazwisko:String? = null
    var incydenty:Int = 0

    constructor(Imie:String,Nazwisko:String, Incydenty:Int, marka:String, model: String, rok_produkcji:Int, _typ_silnika:Typ_Silnika, pojemnosc:Int, moc:Int ): super(marka, model, rok_produkcji, _typ_silnika, pojemnosc, moc){
        imie = Imie
        nazwisko = Nazwisko
        incydenty = Incydenty
    }

    override fun show_info() {
        println(imie)
        println(nazwisko)
        println("Ilość indycentów = $incydenty")
        super.show_info()
    }

    override fun new_owner(nowe_imie:String, nowe_nazwisko:String){
        imie = nowe_imie
        nazwisko = nowe_nazwisko
    }

    override fun new_accident(){
        incydenty ++
    }

    open fun OC(): Double{
        var wartosc_OC = 1000.0
        wartosc_OC += incydenty * 100000.0
        when(typ_silnika){
            Typ_Silnika.LPG -> wartosc_OC += 100.0
            Typ_Silnika.DIESEL -> wartosc_OC += 200.0
            Typ_Silnika.ELECTRIC -> wartosc_OC -= 50.0
            Typ_Silnika.HYBRID -> wartosc_OC += 70.0
            else -> wartosc_OC += 0.0
        }

        return wartosc_OC
    }






}