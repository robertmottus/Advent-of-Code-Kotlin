package se.mottus.aoc2020.day21

data class Food(val ingredients:Set<String>, val allergens:Set<String>)

fun toFood(foodStrings: List<String>): List<Food> {
    // Example foodString: mxmxvkd kfcds sqjhc nhms (contains dairy, fish)
    val foodList = mutableListOf<Food>()
    for(food in foodStrings) {
        val ingredients = food.substringBefore(" (contains").split (" ").toSet()
        val allergens = food.substringAfter("(contains").removeSuffix(")").replace(" ", "").split(",").toSet()
        foodList.add(Food(ingredients=ingredients, allergens=allergens))
    }
    return foodList
}

fun noAllergenIngredients(foodList: List<Food>): Set<String> {
    val ingredientFrequency = ingredientFrequency(foodList)
    val potentialAllergenIngredients = potentialAllergenIngredients(foodList)
    val allIng:Set<String> = ingredientFrequency.keys
    val allergenIng:Set<String> = potentialAllergenIngredients.values.flatten().toSet()
    return allIng.minus(allergenIng)
}


fun potentialAllergenIngredients(foodList: List<Food>): Map<String,Set<String>> {
    val potentialAllergenIngredients = mutableMapOf<String, Set<String>>()
    for(food in foodList) {
        for(allergen in food.allergens) {
            if(potentialAllergenIngredients.contains(allergen)) {
                // reducera
                potentialAllergenIngredients.computeIfPresent(allergen) {k,v -> v.intersect(food.ingredients.toSet())}
            } else {
                potentialAllergenIngredients.put(allergen, food.ingredients.toSet())
            }
        }
    }
    return potentialAllergenIngredients
}

fun ingredientFrequency(foodList: List<Food>): Map<String, Int> {
    val ingFreq = mutableMapOf<String, Int>()
    for(food in foodList) {
        for(ingredient in food.ingredients) {
            ingFreq.compute(ingredient, {k,v -> if(v != null) v+1 else 1})
        }
    }
    return ingFreq
}

fun frequencyOfNonAllergenIngredients(nonAllergenIngredients: Set<String>, ingredientFreq: Map<String,Int>): Int {
    return nonAllergenIngredients.map{i -> ingredientFreq.get(i)}.fold(0){a,n -> a+n!!}
}