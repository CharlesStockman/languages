package kotlinTour.exercises.`05_oop`

// Define a data class Employee with two properties: one for a name,
// and another for a salary. Make sure that the property for salary
// is mutable, otherwise you won't get a salary boost at the end of
// the year! The main function demonstrates how you can use this
// data class.

data class Employee(val name:String, var salary: Double)

fun main() {
    val emp = Employee("Mary", 20.0)
    emp.salary += 10
    check(emp.salary == 30.0)

    println("All test passed...")
}