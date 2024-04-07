package com.example.github_kotlin.KLASY

class Truck: Car {
    var ladownosc:Double? = null

    constructor(Imie:String,Nazwisko:String, Incydenty:Int, marka:String, model: String, rok_produkcji:Int, _typ_silnika:Typ_Silnika, pojemnosc:Int, moc:Int, Ladownosc:Double ):
            super(Imie,Nazwisko, Incydenty, marka, model, rok_produkcji,_typ_silnika,pojemnosc,moc ){
        ladownosc = Ladownosc
    }

    override fun show_info(){
        super.show_info()
        println("Ladownosc = $ladownosc")
    }

    override fun OC(): Double{
        var wartosc_OC = super.OC()
        wartosc_OC += ladownosc as Double * 150.0

        return wartosc_OC
    }

    fun calculate_price():Double{
        if ((ladownosc as Double) <= Kategoria_Wagowa.maly.value){
            return 20.0
        }
        if ((ladownosc as Double) <= Kategoria_Wagowa.sredni.value){
            return 40.0
        }
        if ((ladownosc as Double) <= Kategoria_Wagowa.duzy.value){
            return 60.0
        }
        if ((ladownosc as Double) <= Kategoria_Wagowa.reszta.value){
            return 120.0
        }
        return 100000000.0
    }

}