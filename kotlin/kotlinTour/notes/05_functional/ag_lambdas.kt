package notes.`05_functional`

/**
 * Lambda expressions are written within curly braces
 *
 * If you declare a lambda without parameters there no need to use ->
 *
 * Remember the list has a map function
 *
 * Function Types
 *    1. Functions have a type and there may be times when you need to explicitly define it
 *    2. Example: (int, int ) -> int  -- (It looks the same as function signature)
 *    3. Declare parameter and return types either in the lambda expression or as a function type.
 *          Otherwise, the compiler won't be able to know what type your lambda expression is.
 *    4. Example: val upperCaseString = { str -> str.uppercase() } will not compile
 */

fun main() {
    val uppercase = { text: String -> text.uppercase() }
    println("Example of using a lambda " + uppercase("hello"))

    // Example of pass lambda to a function
    val numbers = listOf(1,2,3,4,5,6)
    println("Example of using lambda by passing it into the function ${numbers.filter { n: Int -> n % 2 == 0 }}")

    // Example of passing lambda to a function as a variable
    val isEven = { n: Int -> n % 2 == 0 }
    println("Example of using a lambda as a variable ${numbers.filter(isEven)}")

    // Example of a higher order function
    // The time is used to select the function that has the signature (Int) -> Int
    fun toSeconds(time: String): (Int) -> Int = when (time) {
        "hour" -> { value -> value * 60 * 60 }          // This is a lambda function being returned.
        "minute" -> { value -> value * 60 }             // This is a lambda function being returned.
        "second" -> { value -> value }                  // This is a lambda function being returned.
        else -> { value -> value }                      // This is a lambda function being returned.
    }

    val timesInMinutes = listOf(2, 10, 15, 1)

    // Return a lambda function from a function that calculates the seconds for the minute provided
    val min2sec = toSeconds("minute")

    // A pipeline that maps an entry in timeInMinutes to get the second and the second are all summed.
    val totalTimeInSeconds = timesInMinutes.map(min2sec).sum()
    println("Total time is $totalTimeInSeconds secs")

}