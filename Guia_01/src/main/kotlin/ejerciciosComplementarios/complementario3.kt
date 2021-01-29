package ejerciciosComplementarios

/*Ejercicio 3. Desarrollar un programa que permita cargar n números enteros y luego nos informe
cuántos valores fueron pares y cuántos impares.*/

fun main(args: Array<String>) {

    var numeros: MutableList<Int> = mutableListOf<Int>()
    var cantidad: Int = 0

    while (cantidad <= 0) {

        print("Cuantos datos desea procesar? ")
        try {
            cantidad = readLine()!!.toInt()
            if(cantidad < 0)
                throw IllegalArgumentException("No acepto numeros negetivos")

        } catch (e: IllegalArgumentException) {
            println("has ingresado un valor no permitido para la cantidad de datos")
        }

    }



    for (i: Int in 0 until cantidad) {

        do {
            print("\n Ingrese el valor No: ${i+1} a cargar: ")
            var bandera: Boolean = false
            try {
                var valor =  readLine()!!.toInt()
                numeros.add((valor))

            } catch (e: IllegalArgumentException) {
                println("has ingresado un valor no permitido")
                bandera = true
            }
        }while (bandera)

    }


    println("Se ingresaron ${numeros.filter { x -> x % 2 === 0 }.size} numeros pares")
    println("Se ingresaron ${numeros.filter { x -> x % 2 !== 0 }.size} numeros impares")

}