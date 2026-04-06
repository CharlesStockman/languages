/**
 * Object declarations create a class with a single instance
 *
 * Objects are created only when they are accessed (lazy)
 *
 * Objects are created in a thread safe manner
 *
 * Objects can be inherited from classes and interfaces
 *
 * Data Objects similar to Data Classes
 *      Make it easier to print data
 *      have a tostring, equals()
 *
 * Companion Objects
 *      Can only have one companion object per class
 *      Only created when referenced for the first time
 *
 */

interface Auth {
    fun takeParams(username:String, password: String)
}

object DoAuth : Auth {
    override fun takeParams(username: String, password: String) {
        println("Input Auth Parameters = $username:$password")
    }
}

data object appConfig {
    var appName = "My Application"
    var version = "1.0.0"
}

class BigBen {
    companion object Bonger {
        fun getBongs(nTimes:Int) {
            repeat(nTimes) { print("Bong")}
        }
    }
}

fun main() {
    DoAuth.takeParams("cstockman", "12345678")
    println(appConfig)
    println(appConfig.appName)
    BigBen.getBongs(12)
}