package notes.`DSL Pattern`

/**
 * Helps to create Domain-Specific Language
 *
 * Lambda functions can have a receiver.  The lambda express can access any member functions are properties
 * of the receiver without having to explicitly specify the receiver each time
 *
 * Makes code easier to read and maintain
 *
 * Function Literal -- Lambda Expression with receiver
 *
 * Create a function literal
 *      MutableList<Int>.() -> Unit
 *
 *      MutableList<Int> as the receiver.
 *      No function parameters within the parentheses ().
 *      No return value: Unit.
 *
 * Lambda expressions with receiver are helpful when you want to create a domain-specific language (DSL).
 * Since you have access to the receiver's member functions and properties without explicitly
 * referencing the receiver, your code becomes leaner.
 *
 * Lambda expression can also have other functions in to initialize the class even further (such as Canvas).  setId
 * is being called to initialize the function at that point.
 *
 * Lambda expressions are not only useful for setup and creation but also for configuration.
 *
 * The documentation states that the code is a design pattern (Ex. buildList, buildString)
 */

class Canvas(){
    var id2:String = ""
    fun drawCircle() = println("Drawing a circle")
    fun drawSquare() = println("Drawing a line")
    fun setId(id:String) {
        this.id2 = id
    }
    fun getId() {
        println("The id of the shape is $id2")
    }
}

// Lambda Expression with receiver definition
// lambda that has Canvas as its receiver type (Canvas.() -> Unit),
// which allows you to call Canvas methods directly inside the lambda block
// without needing to reference the canvas object explicitly.
fun render(block: Canvas.()-> Unit ): Canvas {
    val canvas = Canvas()

    // Use lambda expression with receiver
    canvas.block()
    canvas.setId("Ids will be added later")
    return canvas
}


fun main() {
    render {
        getId()
        drawCircle()
        drawSquare()
    }
}