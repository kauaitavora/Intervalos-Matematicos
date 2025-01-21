import scala.io.StdIn

object App {
  def main(args: Array[String]): Unit = {  
    
    val intervalo1 = new Intervalo("(6, 12]")
    (intervalo1.valores).foreach{(e:Int) => print(e + " ")}
    println("")

    val intervalo2 = new Intervalo("[14,20)")
    (intervalo2.valores).foreach{(e:Int) => print(e + " ")}
    println("")

    println(intervalo1.contem(11))
    println(intervalo1.contem(9))
    
    println(intervalo1.intercepta(intervalo2))
    println(intervalo2.interseccao(intervalo1))

    println(intervalo1.media())

    val produto = intervalo1.produto(intervalo2)
    (produto.valores).foreach{(e:Int) => print(e + " ")}

    println(intervalo1.uniao(intervalo2))
    println(intervalo2.uniao(intervalo1))
    
    val diferenca_ab = intervalo1.diferenca(intervalo2)
    val diferenca_ba = intervalo2.diferenca(intervalo1)
    val interseccao = intervalo1.interseccao(intervalo2)
    
    println(intervalo1.diferenca(intervalo2))
    println(intervalo2.diferenca(intervalo1))
    
    println(intervalo1.produtoCartesiano(intervalo2))

    val diagrama = new DiagramaVenn(490, 360, 300, 790, 360, 300)
    diagrama.desenhaDiagrama(diferenca_ab, diferenca_ba, interseccao)
  }
}

/*
   val intervalo = StdIn.readLine()
    
    
    val intervalo1 = new Intervalo("[1, 10]")
    (intervalo1.valores).foreach{(e:Int) => print(e + " ")}
    println("")


    val intervalo2 = new Intervalo("[12, 15]")
    (intervalo2.valores).foreach{(e:Int) => print(e + " ")}
    println("")

    val diferenca_ab = intervalo1.diferenca(intervalo2)
    val diferenca_ba = intervalo2.diferenca(intervalo1)
    val interseccao = intervalo1.interseccao(intervalo2)

    println(intervalo2.interseccao(intervalo1))

    val diagrama = new DiagramaVenn(490, 360, 300, 790, 360, 300)
    diagrama.desenhaDiagrama(diferenca_ab, diferenca_ba, interseccao)
*/  
