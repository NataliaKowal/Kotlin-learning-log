# Kotlin Learning Log

A collection of exercises I wrote while learning **Kotlin**, focused on object-oriented programming, operator overloading and unit testing. Some of the exercises are inspired by bioinformatics (DNA, RNA and protein sequences).

## Contents

All source files are in `app/src/main/java/com/example/github_kotlin/`.

### `KLASY/`: classes, interfaces and basic algorithms

| File | Topic |
|---|---|
| `VehicleInterface.kt`, `Vehicle.kt`, `Car.kt`, `Truck.kt` | Class hierarchy with an interface, an abstract class and inheritance: vehicle details, change of owner, accident history and insurance (OC) price calculation |
| `Typ_Silnika.kt`, `Kategoria_Wagowa.kt` | Enum classes for engine type and weight category |
| `Dzialanie_metod.kt` | `main()` demonstrating the vehicle classes |
| `Pracownik.kt`, `TypPracownika.kt` | Generic employee classes (permanent and contract employees), data classes and a simple employee management system |
| `Simple_Tests.kt` | Basic algorithms with tests: Heron's formula, common elements of two lists, Fibonacci sequence (iterative and recursive), Collatz sequence, complementary DNA strand and transcription |

### `KLASY_TESTY/`: operator overloading, sequences and unit tests

| File | Topic |
|---|---|
| `Wielomian.kt` | Polynomial class with overloaded operators: evaluation, addition, subtraction, scalar and polynomial multiplication, degree and text representation |
| `Sequence.kt` | Abstract base class for biological sequences: validation, mutation and motif search |
| `DNASequence.kt` | DNA sequence: complementary strand and transcription to RNA |
| `RNASequence.kt` | RNA sequence: start and stop codons and translation to a protein |
| `ProteinSequence.kt` | Protein sequence |
| `main.kt` | `main()` demonstrating the sequence classes |
| `myTests.kt` | Unit tests for the polynomial, DNA and RNA classes (`kotlin.test`) |

## How to run

1. Open the folder in IntelliJ IDEA or Android Studio with the Kotlin plugin.
2. Run any `main()` function (for example in `Dzialanie_metod.kt` or `KLASY_TESTY/main.kt`) with the green run icon next to it.
3. Run the tests from `myTests.kt` or `Simple_Tests.kt` the same way. The tests need the `kotlin-test` library in the project.

## What I practised

- classes, constructors, inheritance, abstract classes and interfaces
- data classes, enum classes and generics
- operator overloading (`plus`, `minus`, `times`, `invoke`)
- collections and string processing
- recursion
- unit tests with `kotlin.test`

## Author

Natalia Kowal
