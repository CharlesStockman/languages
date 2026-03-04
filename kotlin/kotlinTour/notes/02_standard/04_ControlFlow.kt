package notes.`02_standard`

/**
 *
 */

fun main() {

    val x = 2;
    val y = 3;

    // If then as a statement
    if ( x > y ) {
        println("example of if/else statement -- x is greater than y ")
    } else {
        println("example of if/else statement -- y is greater than x")
    }

    // if then as expression
    val largerValue = if ( x > y ) x else y;
    println("example of if/else expression The larger value is ${largerValue}")

    val greeting:String = "hello";

    // Example of the switch statement
    when (greeting) {
        "hello" -> println("example of when statement -- hello")
        "goodbye" -> println("example of when statement -- goodbye")
        else -> println("example of when statement -- No value")
    }

    // Example of switch expression
    val printedGreeting = when (greeting) {
        "hello" -> "hello"
        "goodbye" -> "goodbye"
        else -> println()
    }
    println("example of when expression -- The greeting is ${printedGreeting}")

    // Example of the switch expression without a subject
    val printedGreeting2 = when  {
        greeting == "hello" -> "hello"
        greeting == "goodbye" -> "goodbye"
        else -> println("No value")
    }

    println("example of when expression  without subject -- The greeting is ${printedGreeting2}")

    // Loops

    println("For Loop -- Using a range print out the numbers 1 to 5")
    for ( number in 1..5 ) {
        println("The number is $number")
    }

    println("For Loop -- Using a range to print out the number from 1 to 5 that are less then 5")
    for ( number in 1..<5 ) {
        println("The Number is $number")
    }

    println("For Loop -- Using the number of 1 to 5 starting with highest number and print out every other number ")
    for ( number in 5 downTo 1 step 2) {
        println("The number is $number")
    }

    println("For Loop -- Have a range with characters ")
    for ( letter in 'a' .. 'd') {
        println("The letter is $letter")
    }

    println("For Loop -- Use a collection to print out the elements in the list ")
    val sweets = listOf("cake", "milk shake", "brownies")
    for (sweet in sweets ) {
        println("The sweet is $sweet")
    }

    var counter = 3

    while (counter != 0 ) {
        println("Example of a while loop statement -- The counter is $counter")
        counter--
    }

    do {
        println("Example of a Do-Loop statement -- The counter is $counter")
        counter++
    } while ( counter != 3)


}