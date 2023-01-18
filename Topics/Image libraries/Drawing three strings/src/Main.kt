import java.awt.Color
import java.awt.image.BufferedImage

fun drawStrings(): BufferedImage {
    val message = "Hello, images!"
    val image = BufferedImage(200,200,BufferedImage.TYPE_INT_RGB)

    drawColoredString(message, Color.RED, 50, 50, image)
    drawColoredString(message, Color.GREEN, 51, 51, image)
    drawColoredString(message, Color.BLUE, 52, 52, image)
    return image
}

fun drawColoredString(message: String, color: Color, x: Int, y: Int, image: BufferedImage) {
    val graphics = image.graphics
    graphics.color = color
    graphics.drawString(message,x,y)
}