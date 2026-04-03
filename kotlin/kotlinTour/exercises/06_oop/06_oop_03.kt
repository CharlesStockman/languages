package kotlinTour.exercises.`05_oop`

import kotlin.random.Random

// To test your code, you need a generator that can create random employees.
// Define a RandomEmployeeGenerator class with a fixed list of potential names (inside the class body).
// Configure the class with a minimum and maximum salary (inside the class header).
// In the class body, define the generateEmployee() function. Once again, the main function
// demonstrates how you can use this class.

// 05_oop_01.kt there is another class Employee that was interfering with this class so I need to change the name
data class Employee2(val name: String, var salary: Int)

class RandomEmployeeGenerator(var minSalary: Int, var maxSalary: Int) {

    val names: List<String> = listOf("Alice", "Charles", "Sharon")
    fun generateEmployee() : Employee2 {
        val employee = Employee2(
            names.random(),
            salary = Random.nextInt(minSalary, maxSalary)
        )
        return employee
    }
}

fun validateEmployee(employee: Employee2, generator: RandomEmployeeGenerator) : Boolean {

    var result = true
    if ( listOf("Alice", "Charles", "Sharon").contains(employee.name) == false) {
        result = false
    }

    if ( employee.salary < generator.minSalary ) {
        result = false
    }

    if ( employee.salary >= generator.maxSalary ) {
        result = false
    }

    return result
}

fun main() {
    val empGen = RandomEmployeeGenerator(10, 30)

    val employee1 = empGen.generateEmployee()
    check(validateEmployee(employee1, empGen) == true )

    empGen.minSalary = 50
    empGen.maxSalary = 100

    val employee2 = empGen.generateEmployee()
    check(validateEmployee(employee2, empGen) == true )

    println("All test passed...")
}