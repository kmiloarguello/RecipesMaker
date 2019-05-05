import java.util.Scanner

fun main(args: Array<String>){
    launchMenu()
}

fun launchMenu(){
    println("::Bienvenido a Recipe Maker::\n\n")

    val reader = Scanner(System.`in`)
    println("Selecciona la opción deseada")
    println("1. Hacer una receta")
    println("2. Ver mis recetas")
    println("3. Salir")

    var integer:Int = reader.nextInt()
    println("Number: $integer")
}