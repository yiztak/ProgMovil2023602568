import java.time.LocalDate
import java.time.Period
import java.time.temporal.ChronoUnit
import java.util.Scanner

val scan = Scanner (System.`in`)

fun main() {
    var suma:Int=0
    var nombre: String=""
    var fecha: String=""
    var opcion: Int=0
    val menu: String="Ingrese el numero para elegir la opcion\n " +
            "Menu: \n" +
            "1) Sumar 3 digitos de un numero\n" +
            "2) Ingresar nombre completo\n" +
            "3) Tiempo vivido\n" +
            "4) Salir\n"

    while(opcion!=4){
        try{

            println(menu)
            opcion=scan.nextInt()
            scan.nextLine()
            when(opcion){
                1 -> suma=suma()
                2 -> nombre=nombre()
                3 -> fecha=fecha()
                4 -> println("Gracias $nombre, tu numero sumado fue $suma, y tu fecha de nacimiento es $fecha.")
                else -> println("Inserte una opcion valida")
            }
        }catch(e:Exception){
            scan.nextLine()
            println("Inserte un valor valido")
        }
    }
}

fun suma():Int{
    println("Inserta un digito de 3 numeros para sumarlos.")
    var num:Int=0
    var res:Int=0
    var completado: Boolean=false
    while(!completado){
        try{
            num=scan.nextInt()

            if(num<100 || num>999){
                throw Exception()
            }else{
                for(i in 0..2){
                    res += num%10
                    num/=10
                }
                scan.nextLine()
                completado=true
                println("La suma de los 3 digitos es: $res")
                println("Presione enter para continuar")
                scan.nextLine()
            }
        }catch(e: Exception){
            scan.nextLine()
            println("Inserte un número valido")
        }
    }
    return res
}

fun nombre():String{
    var nombre:String=""
    var completado: Boolean=false
    println("Inserte su nommbre completo")
    while(!completado){
        try{
            nombre=scan.nextLine()
            if(nombre.split(" ").size<3){
                throw Exception()
            }else{
                completado=true
            }
        }catch(e: Exception){
            println("Nombre completo invalido")
        }
    }
    return nombre
}

fun fecha(): String {
    var correcto = false
    while (!correcto) {
        try {
            println("Ingrese su año de nacimiento: ")
            val anio = scan.nextInt()
            println("Ingrese su mes de nacimiento: ")
            val mes = scan.nextInt()
            println("Ingrese su dia de nacimiento: ")
            val dia = scan.nextInt()

            if(anio>2025||mes>12||dia>31 || mes < 1 || dia <1){
                throw(Exception())
            }

            var fechaNacimiento = LocalDate.of(anio, mes, dia)
            val fechaActual = LocalDate.now()

            if (fechaNacimiento.isAfter(fechaActual)) {
                println("Error: La fecha de nacimiento no puede ser en el futuro.")
            } else {
                val periodo = Period.between(fechaNacimiento, fechaActual)
                val diasTotales = ChronoUnit.DAYS.between(fechaNacimiento, fechaActual)
                val mesesTotales = ChronoUnit.MONTHS.between(fechaNacimiento, fechaActual)
                val semanasTotales = diasTotales / 7
                val horasTotales = diasTotales * 24
                val minutosTotales = horasTotales * 60
                val segundosTotales = minutosTotales * 60

                println("\nHas vivido aproximadamente:")
                println("${periodo.years} años, ${periodo.months} meses y ${periodo.days} días")
                println("$mesesTotales meses en total")
                println("$semanasTotales semanas en total")
                println("$diasTotales días en total")
                println("$horasTotales horas en total")
                println("$minutosTotales minutos en total")
                println("$segundosTotales segundos en total")

                correcto = true


                println("Presione enter para continuar")
                scan.nextLine()
                scan.nextLine()
                return fechaNacimiento.toString()
            }
        } catch (e: Exception) {
            scan.nextLine() // Limpiar el buffer
            println("Error: Ingrese una fecha válida en el formato correcto (YYYY MM DD).")
        }
    }
    return ""
}
