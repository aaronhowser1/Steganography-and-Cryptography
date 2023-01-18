// TODO: provide three functions here

fun identity(argument: Int): Int = argument
fun half(argument: Int): Int = argument / 2
fun zero(argument: Int): Int = 0

fun generate(functionName: String): (Int) -> Int {
    return when (functionName) {
        "identity" -> ::identity
        "half" -> ::half
        else -> ::zero
    }
}