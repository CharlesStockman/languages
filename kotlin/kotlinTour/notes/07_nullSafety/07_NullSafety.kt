package notes.`06_nullSafety`

/**
 * Null values happen when something is missing or not set
 * Null safety is a combination of features that allow you to:
 *      Explicitly declare when null values are allowed in your program.
 *      Check for null values.
 *      Use safe calls to properties or functions that may contain null values.
 *      Declare actions to take if null values are detected.
 *
 * Smart Casts and Safe Casts
 *      Smart Casting -- Type automatically cast
 *      is  -- checks if the object has a type and returns a boolean value
 *      !is -- checks if the object does not have a type and returns a boolean value
 *      as  -- implicit cast an object to another type
 *      !as -- explicitly cast an object to a non-nullable type, but return null
 *
 * Null Values and Collections
 *      .filterNotNull              filter null values from a list
 *      .listOfNotNull()            filter values when creating a list
 *      maxOrNull                   Question: How can it not return a value ( empty list )
 *      minOrNull                   Question: How can it not return a value ( empty list )
 *          The maxOrNull(), and minOrNull() functions are designed to be used with collections
 *          that don't contain null values. Otherwise, you can't tell whether the function
 *          couldn't find the desired value or whether it found a null value.
 *      singleOrNull() function with a lambda expression to find a single item that matches a condition.
 *          If one doesn't exist or there are multiple items that match, the function returns a null value
 *      firstNotNullOfOrNull() -- based on an expression returns the first non-null value for a field
 *      reduceOrNull --> Create an accumulated value or return null if a collection is empty
 *
 * Elvis Operator
 *      Used to check preconditions and return if they are incorrect
 *      More coming later
 *
 */

fun printObjecttype(obj: Any) {
    when(obj) {
       is Int -> println("Integer with value $obj")
       !is Double -> println("It's not a double")
       else -> println("Unknown Type")
    }
}

fun calculateTotalStringLength(items: List<Any>): Int {
    return items.sumOf { (it as? String)?.length ?: 0 }
}

data class User(
    val id: Int,
    val name: String,
    // List of friend user IDs
    val friends: List<Int>
)

// Function to get the number of friends for a user
fun getNumberOfFriends(users: Map<Int, User>, userId: Int): Int {
    // Retrieves the user or return -1 if not found (example of early return)
    val user = users[userId] ?: return -1
    // Returns the number of friends
    return user.friends.size
}

fun main() {

    // Creating a variable that cannot have a null as a value
    var neverNull: String = "This can't be null"

    // Throws a compiler error where set to null
    //neverNull = null

    // Creating a variable that can have null as a value
    // nullable has a nullable String type
    var nullable: String? = "You can keep a null here"

    // This is OK
    nullable = null

    // Safe Calls use ?. ( detect a null value )
    println("The value is so length never throws " + nullable?.length)

    // Elvis Operator
    println(("Showing the elvis operator: " + nullable?.length) ?: 0)

    // Showing the is, !is, else
    val myInt = 42
    val myDouble = 3.14
    val myList = listOf(1,2,3)

    printObjecttype(myInt)
    printObjecttype(myDouble)
    printObjecttype(myList)

    // showing the as?
    val a: String? = null
    val b = a as? String
    println("The value of b is " + b)

    val data : List<Int> = listOf(1,2,3)
    println("sum of " + calculateTotalStringLength(data ))

    val data2 : List<String> = listOf("1","2","3")
    println("sum of " + calculateTotalStringLength(data2))

    // Collections

    // filters null after list has been created
    val emails: List<String?> = listOf("a", null, "b")
    val validEmails = emails.filterNotNull()
    println("Eamils          are : $emails")
    println("Filtered Emails are : $validEmails")

    // filters when list is being created
    val serverConfig = mapOf(
        "a" to "1",
        "b" to "2",
        "c" to null
    )

    val configFiles = listOfNotNull(serverConfig["a"])
    println("For \"a\" the config file is $configFiles")

    val configFile2 = listOfNotNull(serverConfig["c"])
    println("For \"c\" the config file is $configFile2")

    // Example of SingleOrNull
    val temperatures = listOf(15, 18, 21, 21, 19, 31)
    val singleNumber = temperatures.singleOrNull{ it == 18 }
    val doesNotExist = temperatures.singleOrNull{ it == 99 }
    val multipleFound = temperatures.singleOrNull{it == 21 }

    println("When finding multiple the values is $multipleFound")
    println("When the value does not exist the value is $doesNotExist")
    println("When it is a single number and it exists the value is $singleNumber")

    // transform
    data class User( val name: String?, val age: Int? )

    val users = listOf(
        User(null, 25),
        User("Alice", 30),
        User("Bob", 35)
    )

    val firstNonNullName = users.firstNotNullOfOrNull{it.name}
    println("First Not Null Name -- $firstNonNullName")

    // Reduce Example
    val itemPrices = listOf(20, 35, 15, 40, 10 )
    val totalPrice = itemPrices.reduceOrNull{runningTotal, price -> runningTotal + price }
    println("The total price is ${totalPrice ?: "No Items"} ")

    val emptyCart = listOf<Int>()
    val emptyTotalPrice = emptyCart.reduceOrNull {runningTotal, price -> runningTotal + price }
    println("The total price is ${emptyTotalPrice ?: "No Items"} ")

    // Creates some sample users
    val user1 = User(1, "Alice", listOf(2, 3))
    val user2 = User(2, "Bob", listOf(1))
    val user3 = User(3, "Charlie", listOf(1))

    // Creates a map of users
    val aliases = mapOf(1 to user1, 2 to user2, 3 to user3)

    println(getNumberOfFriends(aliases, 1)) // returns 2 which equates to user 2
    println(getNumberOfFriends(aliases, 2))   // returns 1 which equates to user 1
    println(getNumberOfFriends(aliases, 4))   // returns -1 since there is no key (4) in the map
}