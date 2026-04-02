package kotlinTour.exercises.`02_standard`

/**
 * You have a list of words.  Keep the words that start with L
 */
fun getWordsThatStartWithL(words: List<String>) : List<String> {

    // Don't want to change the contents of input words so I am creating my own value
    val wordsStartingWithL = mutableListOf<String>()

    for (word in words ) {
        if ( word.startsWith("L", ignoreCase = true)) {
            wordsStartingWithL.add(word)
        }
    }

    return wordsStartingWithL


}

fun main() {
    val words = listOf("dinosaur", "limousine", "magazine", "language")
    check(getWordsThatStartWithL(words) == mutableListOf("limousine", "language"))
    println("All test pass")
}