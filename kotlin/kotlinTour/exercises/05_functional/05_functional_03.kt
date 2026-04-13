package kotlinTour.exercises.`05_functional`

/*
 *
 * Rewrite the .getPriceInEuros() function as a single-expression function
 * that uses safe call operators ?. and the let scope function.
 *
 * // Rewrite this function
 * fun Product.getPriceInEuros(): Double? {
 *     val info = getProductInfo()
 *     if (info == null) return null
 *     val price = info.priceInDollars
 *     if (price == null) return null
 *     return convertToEuros(price)
 * }
 *
 */

 data class ProductInfo(val priceInDollars: Double?)

 class Product {
     fun getProductInfo(): ProductInfo? {
         return ProductInfo(100.0) }
 }

fun Product.getPriceInEuros() : Double? = getProductInfo()?.priceInDollars?.let { convertToEuros(it) }

fun convertToEuros(dollars: Double): Double {
    return dollars * 0.85
}

fun main() {
    val product = Product()
    val priceInEuros: Double? = product.getPriceInEuros()

    println(priceInEuros)
    check(priceInEuros != null )
    check(priceInEuros == 85.0)
}


