/**
 * Default: Classes cannot be inherited to allow the designer to decide if the class should be inherited
 *
 * Support single inheritance
 *
 * Top Most class is the Any Class, and all classes inherit from that class (contains the toString() function)
 *
 * Abstract Classes
 *
 *      Have a constructor, but cannot create instances of the class
 *
 *      Define the behavior of the parent's properties and functions with the override
 *          Can contain properties/functions with implementations and without implementations
 *
 * Interfaces
 *
 *      <b>Differences between classes and interfaces</b>
 *      <ol>
 *          <li>Can't create an instance of an interface (no constructor or header)</li>
 *          <li>Functions and properties are inheritable by default<li>
 *          <li>Don't need to mark functions as abstract if they don't have an implementation</li>
 *      </ol>
 *
 *      Provide a set of properties and functions (can have functions with both an implementation and no implementation)
 *
 *  Delegation
 *
 *      If the interface contains many functions, then the child classes can end up with a lot of boilerplate code.
 *      If you want to override a small part of the classes behavior there will be a lot of boiler plate
 */

abstract class Product(val name: String, var price: Double) {
    // Abstract property for the product category
    abstract val category: String

    // A function that can be shared by all products
    fun productInfo(): String {
        return "Product: $name, Category: $category, Price: $price"
    }
}
interface PaymentMethod {
    fun initiatePayment(amount: Double ) : String
}

interface PaymentType {
    val paymentType: String
}

class CreditCardPayment(val cardNumber: String, val cardHolderName: String, val expiryDate: String ) : PaymentMethod, PaymentType {
    override fun initiatePayment(amount: Double): String {
       return "Payment of $$amount initiated using credit card ending in ${cardNumber.takeLast(4)}. "
    }

    override val paymentType:String = "Credit Card"

}

class Electronic( name: String, price: Double, val warrenty: Int ) : Product(name, price) {
    override val category = "Electronic"
}

fun main() {
    val laptop = Electronic(name = "Laptop", price = 1000.0, warrenty = 2)
    print(laptop.productInfo() + "\n")

    val paymentMethod = CreditCardPayment("1234 2345 3456 4567", "John Doe", "12/25")
    println(paymentMethod.initiatePayment(100.0))

    println("Payment is by ${paymentMethod.paymentType} ")
}