package cryptography

import java.awt.Color
import java.io.File
import java.time.LocalDateTime
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
    //Example: C:/Users/aaron/Documents/Programming Practice/Kotlin/Steganography and Cryptography/Steganography and Cryptography/task/src/cryptography/test.png
    val inputImageName = readln()
    //Example: C:/Users/aaron/Documents/Programming Practice/Kotlin/Steganography and Cryptography/Steganography and Cryptography/task/src/cryptography/test2.png
    println("Output image file:")
    val outputImageName = readln()

    try {
        val bufferedImage = ImageIO.read(File(inputImageName))

        for (i in 0 until bufferedImage.width) {
            for (j in 0 until bufferedImage.height) {
                val color = Color(bufferedImage.getRGB(i,j))

                val rgb = Color(
                    setLeastSignificantBitToOne(color.red),
                    setLeastSignificantBitToOne(color.green),
                    setLeastSignificantBitToOne(color.blue)
                ).rgb

                bufferedImage.setRGB(i, j, rgb)
            }
        }

        println("""
            Input Image: $inputImageName
            Output Image: $outputImageName
        """.trimIndent())
        ImageIO.write(bufferedImage, "png", File(outputImageName))
        println("Image $outputImageName is saved.")
    } catch (e: Exception) {
        println("Can't read input file!")
    }
}

fun show() {
    println("Obtaining message from image.")
}

fun setLeastSignificantBitToOne(byte: Int): Int {
    return if (byte % 2 == 0) {
        byte + 1
    } else byte
}