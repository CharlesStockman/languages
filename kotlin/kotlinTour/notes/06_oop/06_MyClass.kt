package notes.`05_OOP`

/**
 * Can define properties after the class name MyClass
 *
 * Properties
 *  defined on the same line as the class name
 *  defined a variable inside the class
 *  declare properties without val or var within parentheses,
 *      these properties are not accessible after an instance has been created.
 *      Can have default values
 *
 * Data Class
 *    start with data
 *    Predefined functions: toString(), equals() or ==, copy
 */

class MyClass(var id: Int, var email: String = "charlesstockman3@gmail.com") {
    val category: String = ""

    fun sendEmail() {
        println("Sending email to $email")
    }
}

data class Name(val name: String, val id: Int)

fun main() {

    // Create an instance of the class using the default for email
    val myClass = MyClass(1)

    // Use and Set the property
    println("The old id is ${myClass.id}")
    myClass.id = 5
    println("The new id is ${myClass.id}")

    // execute a method
    myClass.sendEmail()

    // Instantiate a data class
    val name1 = Name("Charles Stockman", 1)
    val name2 = Name("Charles Stockman", 1)
    val name3 = Name("Charles Stockman", 1)
    println("Example Printing a DataClass using ToString ${name1.toString()}")

    // Use some common functions of the data class
    println("toString -- $name1")
    println("Does both objects contain the same data: ${name1 == name2} ")
    println("Does both objects contain the same data: ${name1 == name3} ")
    println("Copy to create a new user " + name1.copy().toString())

    


    
}