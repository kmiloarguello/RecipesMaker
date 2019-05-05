import java.util.Scanner
import kotlin.system.exitProcess


val ingredients = listOf("Agua", "Leche", "Carne", "Verduras", "Frutas", "Cereal","Huevos", "Aceite")

fun main(args: Array<String>){
    launchMenu()
}

fun launchMenu(){
    println("::Bienvenido a Recipe Maker::\n\n")

    val menuText = """
        Selecciona la opción deseada
        1. Hacer una receta
        2. Ver mis recetas
        3. Salir.
    """.trimIndent()

    println(menuText)

    val userSelection = getUserValue()
    decideUserSelection(userSelection)

}

fun decideUserSelection (userSelection: Int){
    when(userSelection){
        1 -> createNewRecipe()
        2 -> getAllTheRecipes()
        3 -> exitProcess(0)
    }
}

fun getUserValue ():Int{
    val reader = Scanner(System.`in`)
    return reader.nextInt()
}

fun createNewRecipe (){

}

fun getAllTheRecipes () {

}
