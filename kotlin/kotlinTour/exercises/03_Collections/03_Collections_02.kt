package exercises.`03_Collections`

import java.util.*

/**
 * Is the protocol supported?
 *
 * Assumption : All Strings are uppercase for protocol, protocols
 *
 * @param protocol   The protocol being search for
 * @param protocols  The protocols that will be searched for
 *
 * @return (T) The protocol has been found in the list of protocols
 */
fun contains(protocol: String, protocols: Set<String>) : Boolean {
    return protocols.contains(protocol)
}

fun main() {
    val supported = setOf("HTTP", "HTTPS", "FTP")

    check(contains("smtp".uppercase(Locale.getDefault()), supported) == false)
    check(contains("http".uppercase(Locale.getDefault()), supported) == true)
    println("All test passed")

}