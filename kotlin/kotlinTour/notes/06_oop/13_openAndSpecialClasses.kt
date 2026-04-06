/**
 * If interfaces or abstraction cannot be used then a class can be made inheritable by the open keyword
 * As in the other inheritance the parameters of the parent class must be part of the child class
 *
 * Overriding inherited behavior
 *      Default: Not allows overriding a member function
 *      Actual: Use open keyword on the function or property
 *
 * Open Classes and Interfaces
 *      Create a class that inherits a class and implements multiple interfaces
 *      After then colon then declare the parent class must be declared first then the interfaces
 *
 *  Sealed Classes
 *      Special Type of abstract class
 *      Once a class is declared sealed class can only be created in the same package
 *      when expression is useful for deciding the behavior of all child classes
 *
 *   Enum Classes
 *      Useful to represent a finite set of distinct values in a class
 *      Can have properties and member functions
 *
 *   Inline value classes
 *      Create small objects from classes and use them briefly which can cause performance impact
 *      Special type of class that avoids the performance impact
 *      To create an inline value class @JvmInline
 *      @JvmInLine -- annotation instructs Kotlin to optimize the code when it is compiled.
 *      An inline value class must have a single property initialized in the class header.
 */

open class Vehicle(val make:String, val model:String) {
    // Parent function having permission to be overridden
    open fun displayInfo() {
        println("Vehicle Info: Make - $make, Model - $model")
    }
}

open class Car(make: String, model: String, val numberOfDoors:Int ) : Vehicle(make, model) {
    // The overridden function
    override fun displayInfo() {
        println("Car Info: Make - $make, Model - $model, Number of Doors - $numberOfDoors")
    }
}

interface EcoFriendly {
    val emissionLevel: String
}

interface ElectricVehicle {
    val batteryCapacity: Double
}

class ElectricCar(
    make: String,
    model: String,
    numberOfDoors: Int,
    val capacity: Double,
    val emission:String
) : Car(make, model, numberOfDoors), EcoFriendly, ElectricVehicle {
    override val batteryCapacity: Double = capacity
    override val emissionLevel:String = emission
}

sealed class Mammal ( val name:String)

class Cat(val catName:String) : Mammal(catName)
class Human(val humanName: String, val job: String) : Mammal(humanName)

fun greetMammal(mammal: Mammal) : String {
    when(mammal) {
        is Human -> return "Hello ${mammal.name}.  You are working as a ${mammal.job}"
        is Cat -> return "Hello ${mammal.name}"
        else -> { return "I do not know who I am.  I am having an existential crisis"}
    }
}

enum class State {
    IDLE, RUNNING, FISHED
}

enum class Color(val rgb: Int ){
    RED(0xFF0000 ),
    GREEN( 0x00FF00 ),
    BLUE(0x0000FF),
    YELLOW(0xFFFF00);

    fun containsRed() = (this.rgb and 0xFF0000 != 0 )
}

@JvmInline
value class Email(val address: String)

fun sendEmail(email: Email) {
    println("Sending an email to an email address -- ${email.address}")
}

fun main() {
    val car = Car("Toyota", "Camry", 4)
    car.displayInfo()

    val electricCar = ElectricCar("Toyota", "Camry", numberOfDoors = 4, capacity = 5.0, emission = "low")
    println(electricCar.toString())

    println(greetMammal(Cat("Snowy")))

    val state = State.FISHED
    val message = when(state) {
        State.IDLE -> "It's Idle"
        State.RUNNING -> "It's Running"
        State.FISHED -> "It's Done"
    }
    println("Status: " + message)

    val red = Color.RED
    println("Does the color contain red -- " + red.containsRed())

    val myEmail = Email("example@example.com")
    sendEmail(myEmail)
}