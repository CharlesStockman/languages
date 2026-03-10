package exercises.`03_Collections`

/**
 * Create a map where the key number and the value is the word for it.
 *
 * An example would be key = 3, and value = "three"
 *
 * @param key The key for the hashtable
 * @return The word for the number see example above.
 */
fun numberToWord(key: Int) : String? {
    val numberToWord = mapOf( 1 to "one", 2 to "two", 3 to "three")
    return numberToWord[1]
}

fun main() {
    assert(numberToWord(1)?.compareTo("one") == 0 )
    assert(numberToWord(2)?.compareTo("two") == 0 )
    assert(numberToWord(3)?.compareTo("three") == 0 )
    println("All tests passed")
}