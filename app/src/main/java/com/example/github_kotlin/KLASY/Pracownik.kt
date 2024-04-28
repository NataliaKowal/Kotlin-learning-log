package com.example.github_kotlin.KLASY

abstract class Pracownik<T>(
    val typPracownika: TypPracownika,
    val imie: String,
    val nazwisko: String,
    val wiek: Int,
    val szczegoly: T
)
data class SzczegolyPracownikaStalego(
    val stanowisko: String,
    val pensja:Int )


class PracownikStaly(
    imie: String,
    nazwisko: String,
    wiek: Int,
    szczegoly: SzczegolyPracownikaStalego
): Pracownik<SzczegolyPracownikaStalego>(
    TypPracownika.STALY,
    imie, nazwisko, wiek, szczegoly
){ }

data class SzczegolyPracownikaKontraktowego(
    val stanowisko: String,
    val pensja:Int )

class PracownikKontraktowy(
    imie: String,
    nazwisko: String,
    wiek: Int,
    szczegoly: SzczegolyPracownikaKontraktowego
): Pracownik<SzczegolyPracownikaKontraktowego>(
    TypPracownika.KONTRAKTOWY,
    imie, nazwisko, wiek, szczegoly
){ }

interface ZarzadzanieBazaPracownikow <T> {
    fun dodaj(pracownik: Pracownik<T>)
    fun usun (imie: String, nazwisko: String)
    fun wyszukaj (imie: String, nazwisko: String): Pracownik<T>?
    fun wyswietl ()
}

class SystemZarządzania<T>: ZarzadzanieBazaPracownikow<T> {
    override fun dodaj(pracownik: Pracownik<T>) {
        pracownicy.add(pracownik)
    }

    override fun usun(imie: String, nazwisko: String) {
        for (i in 0..pracownicy.size-1){
            if (pracownicy [i].imie == imie && pracownicy [i].nazwisko == nazwisko){
                pracownicy.removeAt(i)
                return
            }
        }
    }

    override fun wyswietl() {
        for (pracownik in pracownicy) {
            when (pracownik) {
                is PracownikStaly -> println("Informacja o pracowniku to ${pracownik.imie}, ${pracownik.nazwisko}, ${pracownik.wiek}, ${pracownik.szczegoly.stanowisko}, ${pracownik.szczegoly.pensja}")
                is PracownikKontraktowy -> println("Informacja o pracowniku to ${pracownik.imie}, ${pracownik.nazwisko}, ${pracownik.wiek}, ${pracownik.szczegoly.stanowisko}, ${pracownik.szczegoly.pensja}")
            }
        }
    }

    override fun wyszukaj (imie: String, nazwisko: String): Pracownik<T>? {
        for (i in 0..pracownicy.size-1){
            if (pracownicy [i].imie == imie && pracownicy [i].nazwisko == nazwisko){
                return pracownicy[i]
            }
        }
        return null
    }

    var pracownicy:MutableList <Pracownik<T>> = mutableListOf()
}

fun main (){
    val systemZarzadzaniaStalych = SystemZarządzania<SzczegolyPracownikaStalego>()
    val systemZarzadzaniaKontraktowych = SystemZarządzania<SzczegolyPracownikaKontraktowego>()

    systemZarzadzaniaStalych.dodaj(PracownikStaly("Natalia", "Kowal", 24, SzczegolyPracownikaStalego("Junior", 3000)))
    systemZarzadzaniaStalych.wyswietl()

    systemZarzadzaniaKontraktowych.dodaj(
        PracownikKontraktowy("Wojtek", "Kowalski", 38,
        SzczegolyPracownikaKontraktowego("Senior", 10000000)
        )
    )
    systemZarzadzaniaKontraktowych.wyswietl()

}