package cryptography

import java.io.File
import javax.imageio.ImageIO

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
    println("Input image file:")
//    val inputImage = readln()
    val inputImage = "C:/Users/aaron/Documents/Programming Practice/Kotlin/Steganography and Cryptography/Steganography and Cryptography/task/src/cryptography/test.png"
    println("Output image file:")
//    val outputImage = readln()

    try {
        val bufferedImage= ImageIO.read(File(inputImage))

        for (i in 0 until bufferedImage.width) {
            for (j in 0 until bufferedImage.height) {
                val pixelColor = bufferedImage.getRGB(i,j)
                println(pixelColor)
            }
        }

    } catch (e: Exception) {
        println("Can't read input file!")
        return
    }


}

fun show() {
    println("Obtaining message from image.")
}