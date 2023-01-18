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
//    val inputImage = readln() //Example: C:/Users/aaron/Documents/Programming Practice/Kotlin/Steganography and Cryptography/Steganography and Cryptography/task/src/cryptography/test.png
    val inputImage = "C:/Users/aaron/Documents/Programming Practice/Kotlin/Steganography and Cryptography/Steganography and Cryptography/task/src/cryptography/test.png"
    println("Output image file:")
//    val outputImage = readln()

    try {
        val bufferedImage= ImageIO.read(File(inputImage))

        for (i in 0 until bufferedImage.width) {
            for (j in 0 until bufferedImage.height) {
                val color = bufferedImage.getRGB(i,j)

                //Creates a string of 0-11111111
                var blue = (color and 0xff).toString(2)
                var green = (color and 0xff00 shr 8).toString(2)
                var red = (color and 0xff0000 shr 16).toString(2)

                println("Old: $red $green $blue")

                blue = changeLastBit(blue)
                green = changeLastBit(green)
                red = changeLastBit(red)

                println("New: $red $green $blue")
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

fun changeLastBit(input: String): String {
    val byte = input.toCharArray()
    byte[byte.lastIndex] = '1'
    return byte.concatToString()
}