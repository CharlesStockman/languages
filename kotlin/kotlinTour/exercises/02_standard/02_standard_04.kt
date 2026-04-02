package kotlinTour.exercises.`02_standard`

/**
 * Write a program that simulates the Fizz buzz game. Your task is to print numbers from 1 to 100
 * incrementally, replacing any number divisible by three with the word "fizz", and any number
 * divisible by five with the word "buzz". Any number divisible by both 3 and 5 must be
 * replaced with the word "fizzbuzz".
 */

fun fizzbuzz() : String {
    val result = buildString {
        for (i in 1..20) {
            append( when {
                i % 15 == 0 -> "fizzbuzz\n"
                i % 3 == 0 -> "fizz\n"
                i % 5 == 0 -> "buzz\n"
                else -> "$i\n"
            })
        }
    }

    return result
}

fun main() {
    val answer = """
1
2
fizz
4
buzz
fizz
7
8
fizz
buzz
11
fizz
13
14
fizzbuzz
16
17
fizz
19
buzz

""".trimIndent()

    println(fizzbuzz())
    println(answer)

    check(answer.compareTo(fizzbuzz()) == 0)
    println("All tests passed")
}
