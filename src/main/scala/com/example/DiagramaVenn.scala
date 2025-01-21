import java.awt.Color

class DiagramaVenn(centroX1: Int, centroY1: Int, raio1: Int, centroX2: Int, centroY2: Int, raio2: Int) {

  private def calcularCoordenadas(centroX: Int, centroY: Int, raio: Int): Set[(Int,Int)] = {
    val xi = (centroX-raio) to (centroX+raio)
    val yi = (centroY-raio) to (centroY+raio)
    val pontos = for {
      x <- xi;
      y <- yi;
      if (Math.pow(x - centroX, 2) + Math.pow(y - centroY, 2) < Math.pow(raio-50, 2))
    } yield { (x,y) }
    pontos.toSet
  }

  private def mapeiaAreas(pcoordenada: Set[(Int,Int)], intervalo: Seq[Int]): Seq[(Int,(Int,Int))] = {
    
    var coordenada = pcoordenada
    val rand = new scala.util.Random

    val mapa = for {i <- intervalo} yield {
      val index = rand.nextInt(coordenada.size-1)
      val random_coord = coordenada.iterator.drop(index).next()
      
      val number_border = calcularCoordenadas(random_coord._1, random_coord._2, 80)
      coordenada = coordenada.filter(x => !number_border.contains(x))

      (i, random_coord)
    }
    mapa
  }

  def desenhaDiagrama(i_diferenca_ab: Seq[Int], i_diferenca_ba: Seq[Int], i_interseccao: Seq[Int]) {
  
    val imagem_hd = new DesenhaImagem(1280, 720) 

    val circulo1 = calcularCoordenadas(centroX1, centroY1, raio1)
    val circulo2 = calcularCoordenadas(centroX2, centroY2, raio2)
    val circulo_borda1 = calcularCoordenadas(centroX1, centroY1, raio1+100)
    val circulo_borda2 = calcularCoordenadas(centroX2, centroY2, raio2+100)

    val coord_diferenca_ab = circulo1.filter(x => !circulo_borda2.contains(x))
    val coord_diferenca_ba = circulo2.filter(x => !circulo_borda1.contains(x))
    val coord_interseccao = circulo1.filter(x => circulo2.contains(x))

    val mapa_diferenca_ab = mapeiaAreas(coord_diferenca_ab, i_diferenca_ab)
    val mapa_diferenca_ba = mapeiaAreas(coord_diferenca_ba, i_diferenca_ba)
    val mapa_interseccao = mapeiaAreas(coord_interseccao, i_interseccao)

    imagem_hd.desenhaCircunferencia(centroX1, centroY1, raio1, Color.ORANGE, "A", "left")
    imagem_hd.desenhaCircunferencia(centroX2, centroY2, raio2, Color.RED, "B", "right")
    imagem_hd.desenhaIntervalo(mapa_diferenca_ab)
    imagem_hd.desenhaIntervalo(mapa_diferenca_ba)
    imagem_hd.desenhaIntervalo(mapa_interseccao)
    imagem_hd.salvarImagem()
      
  }

}
