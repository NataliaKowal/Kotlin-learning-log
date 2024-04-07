package com.example.github_kotlin.KLASY

fun main (){
    var samochod = Car("Natalia", "Kowal", 0, "Audi", "A4", 2005, Typ_Silnika.DIESEL, 1800, 150)
    samochod.show_info()
    println("OC kosztuje: ${samochod.OC()}")
    samochod.new_accident()
    println("OC kosztuje: ${samochod.OC()}")
    samochod.new_owner("Ania", "Kowalska")
    samochod.show_info()

    var ciezarowka = Truck("Ola", "Nowak", 0, "Ford", "Focus", 2020,Typ_Silnika.HYBRID, 2500, 200, 5000.0)
    ciezarowka.show_info()
    println("OC kosztuje: ${ciezarowka.OC()}")
    ciezarowka.new_accident()
    println("OC kosztuje: ${ciezarowka.OC()}")
    ciezarowka.new_owner("Ania", "Kowalska")
    ciezarowka.show_info()
    println("Autostrada kosztuja: ${ciezarowka.calculate_price()}")
}