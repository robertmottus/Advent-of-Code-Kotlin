package se.mottus.aoc2020.day21

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import se.mottus.util.readResourceAsLines
import kotlin.test.assertEquals

internal class Day21Test {
    val testInput = toFood(readResourceAsLines("se/mottus/aoc2020/day21/test-puzzleinput.txt"))

    @Test
    fun inputToFoodTest() {
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
        Assertions.assertEquals(setOf("mxmxvkd", "sqjhc"), potentialAllergenIngredients(testInput).get("fish"))
        Assertions.assertEquals(setOf("mxmxvkd"), potentialAllergenIngredients(testInput).get("dairy"))
        Assertions.assertEquals(setOf("sqjhc", "fvjkl"), potentialAllergenIngredients(testInput).get("soy"))
    }

    @Test
    fun noAllergenIngredientsTest() {
        val noAllergenIngredients = setOf("kfcds", "nhms", "sbzzf", "trh")
        Assertions.assertEquals(noAllergenIngredients, noAllergenIngredients(testInput))
    }

    @Test
    fun allergIngredsTest() {
        //mxmxvkd contains dairy.
        //sqjhc contains fish.
        //fvjkl contains soy.
        val ingredients = allergenIngredients(testInput)
        Assertions.assertEquals("mxmxvkd", ingredients.get("dairy"))
        Assertions.assertEquals("sqjhc", ingredients.get("fish"))
        Assertions.assertEquals("fvjkl", ingredients.get("soy"))
    }

    @Test
    fun part1DevTest() {
        assertEquals(5, frequencyOfNonAllergenIngredients(noAllergenIngredients(testInput), ingredientFrequency(testInput)))
    }

    @Test
    fun part1AccTest() {
        val foods = toFood(readResourceAsLines("se/mottus/aoc2020/day21/puzzleinput.txt"))
        assertEquals(2517, frequencyOfNonAllergenIngredients(noAllergenIngredients(foods), ingredientFrequency(foods)))
    }

    @Test
    fun part2DevTest() {
        val ingredients = allergenIngredients(testInput).toSortedMap().values.joinToString(",")
        assertEquals("mxmxvkd,sqjhc,fvjkl", ingredients)
    }

    @Test
    fun part2AccTest() {
        val ingredients = allergenIngredients(toFood(readResourceAsLines("se/mottus/aoc2020/day21/puzzleinput.txt"))).toSortedMap().values.joinToString(",")
        assertEquals("rhvbn,mmcpg,kjf,fvk,lbmt,jgtb,hcbdb,zrb", ingredients)
    }
}

