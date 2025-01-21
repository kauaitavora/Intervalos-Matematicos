import java.awt.{Color, Graphics2D, BasicStroke}
import java.awt.geom.Ellipse2D
import com.sksamuel.scrimage.nio.PngWriter
import com.sksamuel.scrimage.ImmutableImage
import java.awt.Font

class DesenhaImagem(largura: Int, altura: Int) {

  val image = ImmutableImage.filled(largura, altura, Color.WHITE)
  val g2 = image.awt().createGraphics()
  val font = new Font("Arial", Font.PLAIN, 40)
  g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON)
  g2.setRenderingHint(java.awt.RenderingHints.KEY_TEXT_ANTIALIASING, java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_ON)

  def desenhaCircunferencia(centroX: Int, centroY: Int, raio: Int, color: Color, tag: String, tag_pos: String) {
    val circle = new Ellipse2D.Double(
      centroX - raio, centroY - raio, 
      2 * raio, 2 * raio
    )
    g2.setColor(color) 
    g2.setStroke(new BasicStroke(6)) 
    g2.draw(circle)

    if(tag_pos == "left"){
      g2.setFont(font)
      g2.setColor(Color.BLACK)
      g2.drawString(f"${tag}", centroX-raio, centroY-raio)
    }else {
      g2.setFont(font)
      g2.setColor(Color.BLACK)
      g2.drawString(f"${tag}", centroX+raio, centroY-raio)
    }

  }
 
  def desenhaIntervalo(mapa: Seq[(Int,(Int,Int))]) {
    g2.setFont(font)
    g2.setColor(Color.BLACK)
    
    for ( i <- 0 to (mapa.length - 1)) {
      g2.drawString(f".${mapa(i)._1}", mapa(i)._2._1, mapa(i)._2._2)
    }
  }

  def salvarImagem() {
    g2.dispose()
    image.output(PngWriter.NoCompression, "drawing.png")
  }

}
