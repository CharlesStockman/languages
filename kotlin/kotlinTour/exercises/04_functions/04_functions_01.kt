package kotlinTour.exercises.`04_functions`

import kotlin.math.PI

// Write a function called circleArea that takes the radius of a circle in integer format as a
// parameter and outputs the area of that circle.

fun calculateCircleArea( radius: Int = 1) : Double = PI * radius * radius

fun main() {
    check(78.53981633974483 == calculateCircleArea(5))
    println("All Test Passed")
}

