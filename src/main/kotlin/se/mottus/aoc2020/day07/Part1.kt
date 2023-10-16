package se.mottus.aoc7.part1

data class Bag(val type: String, val bagContent: List<String>)

fun part1(searchedBag: String, rules: String): MutableSet<Bag> {
    val bags = rules.split(".").map{r -> Bag(parseBagType(r), parseBagContent(r))}.toList()

    val bagsContainingSearchedBag: MutableSet<Bag> = mutableSetOf()
    val bagsTested: MutableSet<Bag> = mutableSetOf()

    for(testedBag in bags) {
        if(search(searchedBag, testedBag, bagsTested, bagsContainingSearchedBag, bags)) {
            bagsContainingSearchedBag.add(testedBag)
        }
    }
    return bagsContainingSearchedBag
}

fun search(
    searchedBag: String,
    currentlyTestedBag: Bag,
    bagsTested: MutableSet<Bag>,
    bagsContainingSearchedBag: MutableSet<Bag>,
    allBags: List<Bag>
): Boolean {
    if(bagsTested.contains(currentlyTestedBag)) {
        return bagsContainingSearchedBag.contains(currentlyTestedBag)
    }

    bagsTested.add(currentlyTestedBag)

    if(currentlyTestedBag.bagContent.contains(searchedBag)) {
        bagsContainingSearchedBag.add(currentlyTestedBag)
        return true
    }

    for(bagId in currentlyTestedBag.bagContent) {
        if(search(searchedBag, allBags.find { b -> b.type.equals(bagId) }!!, bagsTested, bagsContainingSearchedBag, allBags)) {
            bagsContainingSearchedBag.add(currentlyTestedBag)
            return true
        }
    }

    return false
}


fun parseBagType(rule: String): String {
    return rule.substringBefore("bag").trim()
}

fun parseBagContent(rule: String): List<String> {
    if(rule.contains("contain no other bags"))
        return emptyList()
    else
        return rule.substringAfter("contain ")
            .split(", ").map{ s -> stringToType(s)}
}

fun stringToType(str: String): String {
    // " 1 bright white bag " -> "bright white"
    // " 2 muted yellow bags." -> "muted yellow"
    return str.trim().substringAfter(" ").substringBefore("bag").trim()
}
