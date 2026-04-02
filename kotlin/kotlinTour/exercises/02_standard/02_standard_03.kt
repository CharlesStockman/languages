package exercises.`02_standard`

/**
 * Using a while loop, count the number pizza slices to create a pizza pie.
 * There are eight slices per pie
 *
 * @return The number of pizza slices counted
 */
fun whileCountPizzaSlices() : Int {
    var pizzaSlices = 0
    while (pizzaSlices != 8 ) {
        pizzaSlices += 1
    }

    return pizzaSlices
}

/**
 * Using a do-while loop, count the number pizza slices to create a pizza pie.
 * There are eight slices per pie
 *
 * @return The number of pizza slices counted
 */
fun doWhileCountPizzaSlices() : Int {
    var pizzaSlices = 0
    do {
        pizzaSlices += 1
    } while( pizzaSlices != 8 )

    return pizzaSlices
}

fun main() {

    println(whileCountPizzaSlices())
    check(whileCountPizzaSlices() == 8 )
    check(doWhileCountPizzaSlices() == 8 )
    println("All test passed.")
}