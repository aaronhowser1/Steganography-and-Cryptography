package cryptography

fun main() {
    showMenu()
}

fun showMenu() {
    while (true) {
        println("Task (hide, show, exit):")
        val input = readln()
        when (input) {
            "exit" -> {
                println("Bye!")
                break
            }
            "hide" -> hide()
            "show" -> show()
            else -> println("Wrong task: $input")
        }
    }
}

fun hide() {
    println("Hiding message in image.")
}

fun show() {
    println("Obtaining message from image.")
}