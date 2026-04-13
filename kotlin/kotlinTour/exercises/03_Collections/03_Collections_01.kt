package exercises.`03_Collections`

/**
 * Count the number of items in all the list provided ot a function
 *
 * @param lists   A variable amount of list
 * The total number of items in the list that are passed in.
 */
fun countItemsInAllList(vararg items: List<Int>) : Int {
    return items.sumOf { it.size }
}

fun main() {
    val greenNumbers = listOf(1, 4, 23)
    val redNumbers = listOf(5, 22)
    val blueNumbers = emptyList<Int>()

    // The declaration with a ? can have null
    // asserts(countItemsInAllList(null) == 0 )

    check(countItemsInAllList(blueNumbers) == 0)
    check(countItemsInAllList(greenNumbers) == 3)
    check(countItemsInAllList(greenNumbers, redNumbers) == 5)
    println("All test passed")
}