package com.example.github_kotlin.KLASY
abstract class Vehicle: VehicleInterface {
    val Marka: String?
    val Model:String?
    val Rok_Produkcji:Int?
    val typ_silnika:Typ_Silnika?
    val Pojemnosc:Int?
    val Moc:Int?

    constructor(marka:String, model: String, rok_produkcji:Int, _typ_silnika:Typ_Silnika, pojemnosc:Int, moc:Int){
        Marka = marka
        Model = model
        Rok_Produkcji = rok_produkcji
        typ_silnika = _typ_silnika
        Pojemnosc = pojemnosc
        Moc = moc
    }

    constructor(){
        Marka = null
        Model = null
        Rok_Produkcji = null
        typ_silnika = null
        Pojemnosc = null
        Moc = null
    }

    override fun show_info(){
        println("Marka = $Marka")
        println("Model = $Model")
        println("Rok_Produkcji = $Rok_Produkcji")
        println("Typ_silnika = $typ_silnika")
        println("Pojemnosc = $Pojemnosc")
        println("Moc = $Moc")
    }

    override fun calculate_age():Int{
        return 2024 - Rok_Produkcji as Int
    }
}