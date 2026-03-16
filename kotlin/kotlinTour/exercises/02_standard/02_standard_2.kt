package exercises.`02_standard`

/**
 * Using a when expression, update the following program so that it prints the corresponding
 * actions when you input the names of game console buttons.
 *
 * <table>
 * <tr>
 *     <th>Button</th>
 *     <th>Action</th>
 * </th>
 * <tr>
 *     <td>A</td>
 *     <td>Yes</td>
 * </tr>
 * <tr>
 *     <td>B</td>
 *     <td>No</td>
 * </tr>
 * <tr>
 *     <td>X</td>
 *     <td>Menu</td>
 * </tr>
 * <tr>
 *     <td>Y</td>
 *     <td>Nothing</td>
 * </tr>
 * <tr>
 *  <td>Other</td>
 *  <td>There is no such button</td>
 * </tr>
 * </table>
 */
fun showWhen(button: String) : String {
    val result = when (button) {
        "A" -> "yes"
        "B" -> "no"
        "X" -> "menu"
        "Y" -> "nothing"
        else -> "There is no such button"
    }

    return result
}

fun main() {
    assert( showWhen("A").compareTo("yes") == 0)
    assert( showWhen("B").compareTo("no") == 0 )
    assert( showWhen("X").compareTo("menu") == 0)
    assert( showWhen("Y").compareTo("nothing") == 0)
    assert( showWhen("E").compareTo("There is no such button") == 0)
    println("All test passed ")
}


