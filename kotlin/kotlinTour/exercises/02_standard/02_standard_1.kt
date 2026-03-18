package exercises.`02_standard`

/**
 * Create a simple game where you win if throwing two dice results in the same number.
 * Use if to print You win :) if the dice match, or You lose :( otherwise.
 *
 * This exercise will be changed by removing random so that it will be deterministic and easier to test
 * the code
 *
 * @param diceRollValue         The value of the first dice roll
 * @param diceRollValueNext     The value of the second dice roll
 * return (t) "You win :)" and (f) "You lose :("
 */

fun winOrLose(diceRollValue: Int, diceRollValueNext: Int) : String {
    return if ( diceRollValue == diceRollValueNext ) "You win :)" else "You lose :("
}

fun main() {
    check( winOrLose(3, 2).compareTo("You lose :(") == 0)
    check( winOrLose(3,3).compareTo("You win :)") == 0 )
    println("All test passed")
}