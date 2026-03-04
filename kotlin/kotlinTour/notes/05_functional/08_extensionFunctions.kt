package notes.`05_functional`// Modify the function behavior without modifying the source code

//A string template ($) is used to access the value of this.
fun String.bold(): String = "<b>$this</b>"

// Extension Orientated Design
// Separate core functional from useful functionality, but non-essential
// An example would be http get and post.  The core functionality is the network code and extension would be get, post


fun main() {
    // Receiver is what the function is called on.  For the first function readOnlyShapes is the receiver
    val readOnlyShapes = listOf("triangle", "square", "circle")
    println("The first shape is ${readOnlyShapes.first()}")

    // String is the extended class.
    // Bold is the name of the extension function.
    // "Hello", an instance of String, as the receiver.
    // The receiver is accessed inside the body by the keyword: this.
    // The .bold() extension function takes a string and returns it in a <b> HTML element for bold text.
    println("The bold function -- " + "hello".bold())
}