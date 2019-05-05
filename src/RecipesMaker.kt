import java.util.Scanner
import kotlin.system.exitProcess

val ingredients = listOf("Agua", "Leche", "Carne", "Verduras", "Frutas", "Cereal","Huevos", "Aceite")
val recipes = listOf<String>()
val recipe = mutableListOf<String>()

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

fun getIngredientValue(index: Int): String {
    val reader = Scanner(System.`in`)
    if(reader.nextInt().equals(1)){
        return ingredients[index]
    }else{
        return "no-recipe"
    }
}

fun createNewRecipe (){
    println("Vas a crear una nueva receta, por favor indica los ingredientes que necesitas, usa los números de tu teclado.")
    for((index,ingredient) in ingredients.withIndex()){
        println("Necesitarás $ingredient ? \n 0. No | 1. Si")
        addIngredientToNewRecipe(getIngredientValue(index))
    }



    //getUserValue()
}



fun addIngredientToNewRecipe (ingredient: String) {
    if(ingredient != "no-recipe"){
        recipe.add(ingredient)
        println("Recipe is: $recipe")
    }
}

fun getAllTheRecipes () {
    println("This will bring back all the recipes")
}
