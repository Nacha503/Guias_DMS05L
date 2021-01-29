package ejerciciosComplementarios

import java.lang.Exception
import java.lang.NumberFormatException


/*Ejercicio 2. Escribir un programa que solicite ingresar 10 notas de alumnos y nos informe cuántos tienen
notas mayores o iguales a 7 y cuántos menores*/

fun main(args: Array<String>) {
    var array: DoubleArray = DoubleArray(10) { 0.0 }

    var nota: Double = 0.0;

    for (i: Int in 0 until 10) {

        do {
            print("Por favor ingresa la nota No ${i + 1}: ")

            try {

                nota = readLine()!!.toDouble()
                if (nota < 0 || nota > 10)
                    throw IllegalArgumentException("No se aceptan numeros negativos o mayores a 10")
            } catch (e: Exception) {
                println("\nPor favor ingresa un numero valido para nota ( 0 - 10 )")
                nota = -1.0
            }
        } while (0 > nota)

        array[i] = nota

    }

    println("Hay ${array.filter { x -> x >= 7 }.size} notas mayores o iguales a 7 ")
    println("Hay ${array.filter { x -> x < 7 }.size} notas menores a 7 ")
}