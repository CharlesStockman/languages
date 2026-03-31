package exercises.`05_functional`

// You have a list of actions supported by a web service, a common prefix for all requests, and an ID
// of a particular resource. To request an action title over the resource with ID: 5, you need to create
// the following URL: https://example.com/book-info/5/title.  Use a lambda expression to create a list of
// URLs from the list of actions.
fun createUrls() : List<String> {
    val actions = listOf("title", "year", "author")
    val prefix = "https://example.com/book-info"
    val id = 5
    val urls = { actions2 : List<String> -> actions2.map{ "$prefix/$id/$it" }}
    return urls(actions)
}

fun main() {
    val actualOutputs = createUrls()
    check(actualOutputs.get(0).compareTo("https://example.com/book-info/5/title") == 0 )
    check(actualOutputs.get(1).compareTo("https://example.com/book-info/5/year") == 0 )
    check(actualOutputs.get(2).compareTo("https://example.com/book-info/5/author") == 0 )
    println("All test passed...")
}