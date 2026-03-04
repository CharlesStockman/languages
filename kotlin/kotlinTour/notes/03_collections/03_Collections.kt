package notes.`03_collections`

/**
 * Three types of collections
 * <ul>
 *     <li>List (ordered)</li>
 *     <li>Set (unordered)</li>
 *     <li>Maps</li>
 * </ul>
 *
 * To create an immutable list, set, map from a mutable collection search for: // casting -- convert a mutable list to an immutable list
 *
 *
 */

fun main() {
    showList()
    println("--------------")
    showSet()
    println("---------------")
    mapShow()
}

fun showList() {
    // Example of an immutable list and implicit typing (Kotlin uses type inference)
    val readOnlyShapes = listOf("Triangle", "Square", "Pentagon")
    println("Immutable List: $readOnlyShapes")

    // Example of an immutable list and explicit typing (Developer add types documentation
    // Can be extended to Sets, Shapes
    val mutableShapes: MutableList<String> = mutableListOf("Triangle", "Square", "Pentagon")
    print("Mutable List: $mutableShapes")

    // casting -- convert a mutable list to an immutable list
    val shapesLocked: List<String> = mutableShapes
    println("Convert Immutable List to a mutable list $shapesLocked")

    println("Common Functions ")
    println("\tElements are 0 based: " + readOnlyShapes[0])
    println("\tFirst Elements is " + readOnlyShapes.first())
    println("\tLast  Element is  " + readOnlyShapes.last())
    println("\tNumber of Item in list is " + readOnlyShapes.count())

    // case-sensitive (if expr was ("triangle" in readOnlyShapes) result would be false)
    println("\tIs Item in List ( Triangle ) " + ("Triangle" in readOnlyShapes))

    mutableShapes.add("hexagon")
    println("\tAdd Hexagon to list $mutableShapes")

    mutableShapes.remove("hexagon")
    println("\tDel Hexagon to list $mutableShapes")

}

fun showSet() {
    val readOnlyFruit = setOf("apple", "banana", "cherry", "cherry")
    println("Show the immutable set print out unique elements $readOnlyFruit")

    val mutableFruit: MutableSet<String> = mutableSetOf("apple", "banana", "cherry", "cherry")
    println("Show the mutable set print out unique elements $mutableFruit")

    println("Common Functions... ")
    println("\tThe number of elements in the set is " + readOnlyFruit.count())
    println("\tIs item in set ( cherry is the item) " + ("cherry" in readOnlyFruit))

    mutableFruit.add("orange")
    println("\tAfter adding orange. The elements in the set are: $mutableFruit")

    mutableFruit.remove("orange")
    println("\tAfter removing orange.  The elements in the set are: $mutableFruit ")

}

fun mapShow() {
    val readOnlyJuiceMenu = mapOf("apple" to 100, "kiwi" to 190, "orange" to 280)
    println("Show the immutable map: $readOnlyJuiceMenu")

    val mutableJuiceMenu: MutableMap<String, Int> = mutableMapOf("apple" to 100, "kiwi" to 190, "orange" to 280)
    println("Show the mutable map $mutableJuiceMenu")

    // Note the use of {}
    println("Common Functions... ")
    println("\tPrint the value for the key apple -- ${mutableJuiceMenu["apple"]} ")
    println("\tPrint the value for an unknown key and the output will be null -- ${mutableJuiceMenu["chuck"]}")

    mutableJuiceMenu["grape"] = 150
    println("\tAdded the key grape -- $mutableJuiceMenu")

    mutableJuiceMenu.remove("grape")
    println("\tRemove the key grape -- $mutableJuiceMenu")

    println("\tThe number of elements in the map is $mutableJuiceMenu")
    println("\tDoes the key \"apple\" in the map -- ${mutableJuiceMenu.containsKey("apple")}")
    println("\tDoes the key \"chuck\" in the map -- ${mutableJuiceMenu.containsKey("chuck")}")
    println("\tShow the keys -- ${mutableJuiceMenu.keys}")
    println("\tShow the values -- ${mutableJuiceMenu.values}")


}