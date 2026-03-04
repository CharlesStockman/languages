package notes.`04_functions`

/**                                                                                                                                                                                                                                                                                             F
 *
 *  Function doesn't return a useful value then its return type is Unit.
 *  Unit is a type with only one value – Unit.
 */

fun main() {

    // Show the basic function with parameters and return value
    println("Example of a function that has parameters and a return value -- The sum of two numbers is ${sum2Numbers(5,5)}")

    // Show named parameters
    println("Example of a function that that named parameters ${sum2Numbers(x = 5,y = 5)}")

    // Show default values... We are not including the second number
    println("Example of a function with a default value for an unnamed parameter ${sum2Numbers(x = 5)}")

    // Shorten the function
    println("Example of a function where the return statement is inferred  ${sum3Numbers(5,5)}")

}

fun sum2Numbers(x: Int, y: Int = 0  ): Int {
    return x + y;
}

// To short the function, remove the curly braces and the return value can be inferred.
fun sum3Numbers(x: Int, y: Int, z: Int = 0 ) : Int = x + y + z;
