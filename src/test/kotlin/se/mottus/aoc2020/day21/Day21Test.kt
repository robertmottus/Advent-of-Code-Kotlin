package se.mottus.aoc2020.day21

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import se.mottus.aoc2020.readResource
import kotlin.test.assertEquals

internal class Day21Test {
    val testInput = toFood(readResource("se/mottus/aoc2020/day21/test-puzzleinput.txt"))

    @Test
    internal fun inputToFoodTest() {
        val exptectedFoods = listOf(
            Food(ingredients = setOf("mxmxvkd", "kfcds", "sqjhc", "nhms"), allergens = setOf("dairy", "fish")),
            Food(ingredients = setOf("trh", "fvjkl", "sbzzf", "mxmxvkd"), allergens = setOf ("dairy"))
        )
        val foodsFromInput = toFood(listOf(
            "mxmxvkd kfcds sqjhc nhms (contains dairy, fish)",
            "trh fvjkl sbzzf mxmxvkd (contains dairy)"))
        assertEquals(exptectedFoods, foodsFromInput)
    }

    @Test
    fun ingredientFrequencyTest() {
        Assertions.assertEquals(1, ingredientFrequency(testInput).get("kfcds"))
        Assertions.assertEquals(1, ingredientFrequency(testInput).get("kfcds"))
        Assertions.assertEquals(1, ingredientFrequency(testInput).get("nhms"))
        Assertions.assertEquals(1, ingredientFrequency(testInput).get("trh"))
        Assertions.assertEquals(2, ingredientFrequency(testInput).get("sbzzf"))
        Assertions.assertEquals(3, ingredientFrequency(testInput).get("mxmxvkd"))
    }

    @Test
    internal fun potentialAllergenIngredientsTest() {
//        val potentialIngredientsContainingFish = setOf("mxmxvkd", "kfcds", "sqjhc", "nhms", "sqjhc", "mxmxvkd", "sbzzf")
        val potentialIngredientsContainingFish = setOf("mxmxvkd", "sqjhc")
        Assertions.assertEquals(potentialIngredientsContainingFish, potentialAllergenIngredients(testInput).get("fish"))
        Assertions.assertTrue(potentialAllergenIngredients(testInput).get("fish")!!.containsAll(potentialIngredientsContainingFish))
    }

    @Test
    internal fun noAllergenIngredientsTest() {
        val noAllergenIngredients = setOf("kfcds", "nhms", "sbzzf", "trh")
        Assertions.assertEquals(noAllergenIngredients, noAllergenIngredients(testInput))
    }

    @Test
    internal fun part1DevTest() {
        assertEquals(5, frequencyOfNonAllergenIngredients(noAllergenIngredients(testInput), ingredientFrequency(testInput)))
    }

    @Test
    internal fun part1AccTest() {
        val foods = toFood(readResource("se/mottus/aoc2020/day21/puzzleinput.txt"))
        assertEquals(2517, frequencyOfNonAllergenIngredients(noAllergenIngredients(foods), ingredientFrequency(foods)))
    }
}

