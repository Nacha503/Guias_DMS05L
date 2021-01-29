package ejerciciosComplementarios

import java.lang.NumberFormatException

/*Ejercicio1. Crear un programa en consola que me permita saber si dos números son divisibles entre sí,
para saber si un número es divisible por otro se tiene que obtener el modulo y si este es
cero entonces este número es divisible por el otro.*/


fun main(args: Array<String>) {
    var num1: Int = 0
    var num2: Int = 0

    do {
        var bandera: Boolean = false
        println("Por favor ingrese el primer numero")
        try {
            num1 = readLine()!!.toInt()

        } catch (e: NumberFormatException) {
            println("ERROR Ese no es un numero")
            bandera = true
        }
    } while (bandera)


    do {
        var bandera: Boolean = false
        println("Por favor ingrese el segundo numero")
        try {
            num2 = readLine()!!.toInt()

            while (num2 == 0) {
                println("el segundo numero no puede ser cero")
                println("Por favor ingrese el segundo numero")
                num2 = readLine()!!.toInt()
            }


        } catch (e: NumberFormatException) {
            println("ERROR Ese no es un numero")
            bandera = true
        }
    } while (bandera)


    if (num1 % num2 == 0)
        println(" $num1 es divisible entre $num2 ")
    else
        println("$num1 NO ES divisible entre $num2")



}

