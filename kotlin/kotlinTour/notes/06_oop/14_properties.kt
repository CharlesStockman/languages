/**
 *  In kotlin properties have set(), get() (property accessors) functions by default
 *  The accessors using a backing field to store the actual value
 *
 *  Backing fields exist if either of the following is true:
 *      You use the default get() or set() functions for the property.
 *      You try to access the property value in code by using the field keyword.
 *
 *  Backing is useful for:
 *      Logging
 *      Send Notifications
 *      When a property value changes
 *      Additional logic that compares old/new values
 *
 *   Extension Properties
 *      Add new properties without modifying the source code
 *      Do not have backing fields -- Write the get and set functions yourself
 *          ExtensionProperties can't hold state
 *      Most useful for computed properties without using inheritance
 *
 *   Delegated Properties
 *      Delegate their accessors to another object
 *      Good for storing properties with complex storage needs
 *          Examples Database Table, Browser Session, Geographic Map
 *      Aim: To reduce boilerplate code by keeping the logic for get/set values in the delegated objects
 *      Every delegated object must have a getValue and SetValue (only if mutable)
 *
 *
 *      operator fun getValue(thisRef: Any?, property: KProperty<*>): String {}
 *      operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {}
 *
 *      Notes on the previous function signatures
 *          operator -- mark these functions as operator functions, so they overload the set/get functions
 *          thisRef -- The object containing the delegated property. A specific type many need to be declared
 *          property -- refers to the property whose value was accessed or changed
 *
 *      getValue default return is String, but that can be changed
 *      setValue has an additional parameter value which is used to hold the new value assigned to the property
 *
 * Lazy Properties
 *     Initialize property at first access
 *     To create an instance of the Lazy interface,
 *         use the lazy() function
 *         by providing it with a lambda expression to execute
 *            when the get() function is called for the first time.
 *      Any further calls of the get() function return the same result that was provided on the first call.
 *      Lazy properties use the trailing lambda syntax to pass the lambda expression.
 *      Lazy properties are useful not only when initialization is resource-intensive
 *      When a property might not be used in your code.
 *      Thread-safe by default, which is particularly beneficial if you are working in a concurrent environment.
 *
 * Observable
 *      Detect a change in a property value and use this knowledge to trigger an action
 *      import kotlin.properties.Delegates.observable.
 *      Use the observable() function and provide it with a lambda expression
 *          executes whenever the property changes.
 *      Use them for logging and debugging purposes.
 *      Use them for use cases like updating a UI or to perform additional checks, like verifying the validity of data.
 *
 *
 *
 */

import kotlin.properties.Delegates.observable


// This code will recurse out of control.  The reason is name.  When you access the name, the setter is being
// called again which will create a recursive function.
//class Person {
//    var name: String = ""
//        set(value) {
//            // This causes a runtime error
//            name = value.replaceFirstChar { firstChar -> firstChar.uppercase() }
//        }
//}
//
//fun main() {
//    val person = Person()
//    person.name = "kodee"
//    println(person.name)
//    // Exception in thread "main" java.lang.StackOverflowError
//}

// Fix the recursion problem with the field keyword
class Person {
    var name: String = ""
        set(value) {
            field = value.replaceFirstChar { firstChar -> firstChar.uppercase() }
        }
}

// Extension Properties
data class Person2(val firstName: String, val lastName: String )
val Person2.fullName: String
    get() =  "$firstName $lastName"

class CacheStringDelegate {
    var cachedValue: String? = null

    operator fun getValue(thisRef: User, property: Any? ) : String {
        if ( cachedValue == null ) {
            cachedValue = "${thisRef.firstName} ${thisRef.lastName}"
            println("Computed and Cached: $cachedValue")
        } else {
            println("Accessed from Cache: $cachedValue")
        }

        return cachedValue ?: "Unknown"
    }
}

// Delegated Properties
class User(val firstName: String, val lastName: String) {
    val displayName: String by CacheStringDelegate()
}

// Lazy

class Database {
    fun connect() {
        println("Connecting to the database...")
    }

    fun query(sql: String) : List<String> {
        return listOf("Data1", "Data2", "Data3")
    }
}

// Observable
class Thermostat() {
    var temperature: Double by observable(20.0) { _ , old, new ->
        if ( new > 25 ) {
            println("Warning: Temperature is too high! ($old°C -> $new°C)")
        } else {
            println("Temperature updated: $old°C -> $new°C")
        }

    }
}

val databaseConnection: Database by lazy {
    val db = Database()
    db.connect()
    db
}

fun fetchData(){
    // The first time this run the data is initialized,
    // The second time this runs the data is retrieved
    val data = databaseConnection.query("select * from data")
    println("Data is " + data)
}

fun main() {
    // Show how to use a backend variable in a set
    val person = Person();
    person.name = "chuck"
    println(person.name)

    // Extension Properties
    val person2 = Person2("Charles", "Stockman")
    println("The full name is " + person2.fullName)

    // Delegated Properties
    val user = User("Charles", "Stockman")
    user.displayName
    user.displayName

    // Lazy
    fetchData()
    fetchData()

    // Observable
    val thermostat = Thermostat()
    thermostat.temperature = 22.5

    thermostat.temperature = 27.0
}