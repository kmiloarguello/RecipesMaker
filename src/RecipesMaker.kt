import java.util.Scanner
import kotlin.system.exitProcess

val ingredients = listOf("Agua", "Leche", "Carne", "Verduras", "Frutas", "Cereal","Huevos", "Aceite")
val recipe1 = mutableListOf<String>()
val recipe2 = mutableListOf<String>()
val recipe3 = mutableListOf<String>()
val recipes = mutableListOf<MutableList<String>>()
val names = mutableListOf<String>()

fun main(args: Array<String>){
    println("::Bienvenido a Recipe Maker::\n\n")

    launchMenu()
}

fun launchMenu(){

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
        1 -> createNewRecipe(recipe1)
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

fun createNewRecipe (recipe: MutableList<String>){

    println("Vas a crear una nueva receta, por favor indica los ingredientes que necesitas, usa los números de tu teclado.")
    for((index,ingredient) in ingredients.withIndex()){
        println("Necesitarás $ingredient ? \n 0. No | 1. Si")
        addIngredientToNewRecipe(getIngredientValue(index), recipe)

        if(index == ingredients.size.minus(1)){
            println("Le quieres poner un nombre ?");
            val recipeName = readLine()!!

            getCurrentRecipe(recipeName, recipe)
            askToCreateAnotherRecipe()


            // Total recipes
            recipes.add(recipe)
            names.add(recipeName)
        }

    }
}


fun addIngredientToNewRecipe (ingredient: String, recipe: MutableList<String>) {
    if(ingredient != "no-recipe"){
        recipe.add(ingredient)
    }
}

fun getCurrentRecipe(name:String, recipe: List<String>){
    println("La receta actual es $name con los ingredientes:")
    for(ingredient in recipe){
        println(ingredient)
    }
}

fun askToCreateAnotherRecipe(){
    println("¿Deseas crear otra receta? 0. No | 1. SI")
    val reader = Scanner(System.`in`)
    if(reader.nextInt().equals(1)){
        createNewRecipe(recipe2) //TODO: Hacer más de 2 recetas
    } else {
        launchMenu()
    }
}

fun getAllTheRecipes () {
    for(recipe in recipes){
        for(ingredient in recipe){
            println("Ingrediente $ingredient de la receta $recipe") // Print the recipes

            if(ingredient.equals(recipe.minus(1))){
                askToCreateAnotherRecipe()
            }
        }
    }
}
