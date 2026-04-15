package kotlinTour.exercises.`05_functional`

data class User(val id: Int, var email: String)

// You have an updateEmail() function that updates the email address of a user.
// Use the apply scope function to update the email address and then the "also"
// scope function to print a log message: Updating email for user with ID: ${it.id}.
fun updateEmail(user: User, newEmail: String): User =  user.apply {
    email = newEmail
}.also {
    println("Updating the email for user with ID $it.id")
}

fun main() {
    val user = User(1, "old_email@example.com")
    check(user.id ==1)
    check(user.email.compareTo("old_email@example.com") == 0 )

    val updatedUser = updateEmail(user, "new_email@example.com")
    check(updatedUser.id == 1)
    check(updatedUser.email.compareTo("new_email@example.com") == 0 )
    println("All test passed ")

}