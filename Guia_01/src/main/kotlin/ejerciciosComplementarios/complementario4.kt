package ejerciciosComplementarios

import kotlin.reflect.typeOf


/*Ejercicio 4. Escribir un programa que pida ingresar coordenadas (x,y) que representan puntos en el
plano.
Informar cuántos puntos se han ingresado en el primer, segundo, tercer y cuarto cuadrante.
Al comenzar el programa se pide que se ingrese la cantidad de puntos a procesar.*/

fun main(args: Array<String>) {

    var x: Double = 0.0
    var y: Double = 0.0


    var cuadrante1 = 0
    var cuadrante2 = 0
    var cuadrante3 = 0
    var cuadrante4 = 0
    var ejeX = 0
    var ejeY = 0
    var origien =0


    var cantidad: Int = 0

    do {

        print("Cuantas coordenadas vamos a analizar este dia? ")
        try {
            cantidad = readLine()!!.toInt()
            if (cantidad < 0)
                throw IllegalArgumentException("No acepto numeros negativos o ceros")

        } catch (e: Exception) {
            println("Eso no me parece una cantidad valida")
        }
    } while (cantidad < 0)

    for (i: Int in 0 until cantidad) {
        println("coordena No: ${i+1}")
        do {
            var bandera = false
            print("Ingrese la coordenada en X: ")
            try {

                x = readLine()!!.toDouble()
            } catch (e: IllegalArgumentException) {
                println("eso no es un numero, por favor intenta otra vez")
                bandera = true
            }

        } while (bandera)

        do {
            var bandera = false
            print("Ingrese la coordenada en Y: ")
            try {

                y = readLine()!!.toDouble()
            } catch (e: IllegalArgumentException) {
                println("eso no es un numero, por favor intenta otra vez")
                bandera = true
            }

        } while (bandera)


        when {
            x > 0.0 && y > 0.0 -> cuadrante1++
            x > 0.0 && y < 0.0 -> cuadrante4++
            x < 0.0 && y > 0.0 -> cuadrante2++
            x < 0.0 && y < 0.0 -> cuadrante3++
            (x === 0.0) && y !== 0.0 -> ejeY++
            (y === 0.0) && x !== 0.0 -> ejeX++
            else -> origien++


        }


    }
    println("Resultado".padEnd(18,'*').padStart(28,'*'))
    println("Coordenadas en el cuadrante 1 ->$cuadrante1")
    println("Coordenadas en el cuadrante 2 ->$cuadrante2")
    println("Coordenadas en el cuadrante 3 ->$cuadrante3")
    println("Coordenadas en el cuadrante 4 ->$cuadrante4")

    println("Coordenadas en el eje X ->$ejeX")
    println("Coordenadas en el eje Y ->$ejeY ")

    println("Coordenadas en el origen ->$origien")


}