package notes.`05_functional`

/**
 * There are two scopes
 *      global
 *      local Only access within a block or function
 *
 * Scope Functions -- create temporary scope around an object and Function
 *
 * With is the only one of these functions that is not an extension function
 *
 * Difference between apply and run scope
 *      "apply returns the object itself (the receiver)"
 *      "run returns the result of the lambda (the last expression)"
 *
 * Function    Access to x via     Return value        Use case
 * let         it                  Lambda result       Perform null checks in your code
 *                                                     and later perform further actions
 *                                                     with the returned object.
 * apply      this                x                    Initialize objects at the time of creation.
 * run        this                Lambda result        Initialize objects at the time of creation
 *                                                     AND compute a result
 * also       it                  x                    Complete additional actions before returning
 *                                                     the object.
 * with       this                Lambda result        Call multiple functions on an object.
 */

fun getNextAddress(): String {
    return "charles.stockman@gmail.com"
}

fun getNextAddressReturnNull() : String? {
    return null
}

fun sendEmail(to: String?) {
    println("Sending email to $to")
}

fun sendNotification(to: String?): String {
    println("To $to")
    return "Notification sent!"
}

class Client() {
    var token: String? = null
    fun connect() = println("connected!")
    fun authenticate() = println("authenticated!")
    fun getData() : String {
        token.let {
            println("token is not null")
            return "Mock data"
        }
    }
}

class Canvas {
    fun rect(x: Int, y: Int, w: Int, h: Int): Unit = println("$x, $y, $w, $h")
    fun circ(x: Int, y: Int, rad: Int): Unit = println("$x, $y, $rad")
    fun text(x: Int, y: Int, str: String): Unit = println("$x, $y, $str")
}



fun main() {

    // Example of let command
    println("Scopes show an example of the let command where the address is not null")
    val nonNullAddress: String? = getNextAddress()
    val confirm = nonNullAddress?.let {
        println("Scopes Executing sendNotification --- ")
        sendNotification(nonNullAddress);
    }
    println("Scopes: Input $nonNullAddress the output is $confirm ")

    println("Scopes show an example of the let command where the address is null")
    val nullAddress: String? = getNextAddressReturnNull()
    val confirm2 = nullAddress?.let {
        println("(Never gets printed) Scopes Executing sendNotification --- ")
        sendNotification(nullAddress)
    }
    println("Scopes: Input $nullAddress the output is $confirm2 ")

    // Example of apply scope
    println("Scopes An Example of the apply function")
    val client = Client().apply{
        token = "abcd"
        connect()
        authenticate()
    }
    println("Scopes To show that the client class was initialized \"Mock Data! \" should be displayed -- ${client.getData()}")

    // Example of the Run Scope
    println("Scopes An Example of the run function")
    val client2 = Client().apply{token="abcd"}
    val result: String = client.run {
        connect()
        authenticate()
        getData()
    }
    println("Scopes The result was $result")

    // Example of the Also Scope
    val medals: List<String> = listOf("Gold", "Silver", "Bronze")
    val reversedMedals: List<String> =
        medals
            .map    { it.uppercase()              }
            .also   { println("Before Filter $it")}
            .filter { it.length > 4               }
            .also   { println("After filter $it") }
    println("Scopes Medals = $reversedMedals")

    // Example of the "with" Scope
    val canvas: Canvas = Canvas()
    with(canvas) {
        text(10,10,"Foo")
        circ(5,5, 2)
        rect(3,5,5,6)
    }


}