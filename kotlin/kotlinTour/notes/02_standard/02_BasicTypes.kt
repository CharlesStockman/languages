package notes.`02_standard`

/**
 * Variables Types
 *    var -- Mutable variables
 *    val -- Immutable variables
 *
 *    When refining a val (immutable) get a compiler error
 *
 *    String Templates -- Access Data stored in variables and convert them to a string
 *
 *    Kotlin has inferred types (type Inference (ex. Kotlin knows that pi is a float or double))
 *
 *        <table>
 *         <tr>
 *             <th>Category</th>
 *             <th>Basic types</th>
 *             <th>Example code</th>
 *         </tr>
 *         <tr>
 *             <td>Integers</td>
 *             <td>Byte, Short, Int, Long</td>
 *             <td>val year: Int = 2020</td>
 *         </tr>
 *         <tr>
 *             <td>Unsigned integers</td>
 *             <td>UByte, UShort, UInt, ULong</td>
 *             <td>val score: UInt = 100u</td>
 *         </tr>
 *         <tr>
 *             <td>Floating-point numbers</td>
 *             <td>Float, Double</td>
 *             <td>val currentTemp: Float = 24.5f, val price: Double = 19.99</td>
 *         </tr>
 *         <tr>
 *             <td>Booleans</td>
 *             <td>Boolean</td>
 *             <td>val isEnabled: Boolean = true</td>
 *         </tr>
 *         <tr>
 *             <td>Characters</td>
 *             <td>Char</td>
 *             <td>val separator: Char = ','</td>
 *         </tr>
 *         <tr>
 *             <td>Strings</td>
 *             <td>String</td>
 *             <td>val message: String = "Hello, world!"</td>
 *         </tr>
 *     </table>
 *
 *     Mathematical Operators: +,-,*,/,+=,-=,*=,/=
 */

// Example of a top level variable

// const keyword -- true constants
//      val means you can't reassign the reference, but you can still modify the object it points to.
//      const means the assignment can't be modified
//      Rules for const val:
//          Must be at top level or in an object
//          Must be a primitive type or String
//          Value must be known at compile time
//          Cannot be computed or assigned at runtime
const val global = 3
var global2 = 4

fun main() {

    // Examples of Type Inference
    // var is mutable and val is immutable
    var yearlyPay=3500.00
    val pi=3.14

    // Examples of Explict Type
    var hoursPerWeek: Int = 40

    // Example of Explicit variable that is not set will produce a compiler error if not initialized
    var dayOff: Int
    // println("Uninitialized Variable $dayOff")

    // Example of simple string interpolation
    println("Top Level Variable global (val)  -- $global")
    println("Top Level Variable global2 (var) -- $global2")
    println("Example of String Template -- Pi is $pi")


}