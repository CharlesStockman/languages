package kotlinTour.exercises.`05_oop`


// Given Person.  Create the rest of the class and add the properties needed to make this code run

data class Person(val name: Name, val address: Address, val ownsAPet: Boolean = true)
data class Name(val firstName: String, val lastName: String )
data class Address(val street: String, val city: City )
data class City(val town:String, val country:String)

fun getPerson() : Person {
    val person = Person(
        Name("John", "Smith"),
        Address("123 Fake Street", City("Springfield", "US")),
        ownsAPet = false
    )

    return person
}

fun main() {
    val person = getPerson()
    check(person.name.firstName.compareTo("John") == 0 )
    check(person.name.lastName.compareTo("Smith") == 0 )
    check(person.address.street.compareTo("123 Fake Street") == 0 )
    check(person.address.city.town.compareTo("Springfield") == 0 )
    check(person.address.city.country.compareTo("US") == 0 )
    check(person.ownsAPet == false)
    println("All test passed")
}