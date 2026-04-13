package kotlinTour.exercises.`04_functions`

fun Int.isPositive(): Boolean = this > 0

fun main() {
    check(1.isPositive() == true)
    check((-2).isPositive() == false)

    println("All test Passed")
}