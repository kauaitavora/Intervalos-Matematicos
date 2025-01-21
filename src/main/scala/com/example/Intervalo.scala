class Intervalo(val strIntervalo: String) {

  val valores: Seq[Int] = calculaValores()
  val lim_inf = this.valores.head
  val lim_sup = this.valores.last 

  private def calculaValores(): Seq[Int] = {
    val absLimites = strIntervalo.substring(1, strIntervalo.length - 1).split(",").map(_.trim.toInt)
    (strIntervalo.head, strIntervalo.last) match {
      case ('[', ']') => (absLimites(0) to absLimites(1)).toSeq
      case ('(', ']') => (absLimites(0) + 1 to absLimites(1)).toSeq
      case ('[', ')') => (absLimites(0) until absLimites(1)).toSeq
      case ('(', ')') => (absLimites(0) + 1 until absLimites(1)).toSeq
      case _ => throw new Exception("Delimitadores de intervalo inválido")
    }
  }
  
  def contem(v: Int): Boolean = {
    //v >= this.lim_inf && v <= lim_sup 
    this.valores.contains(v)
  }

  def intercepta(intervalo2: Intervalo): Boolean = {
    //!(this.lim_sup < intervalo2.lim_inf || this.lim_inf > intervalo2.lim_sup)
    intervalo2.valores.exists(i => this.contem(i))
  }

  def media(): Float = {
    def aux(lst: List[Int]): Int = lst match {
      case Nil => 0 
      case x :: xs => x + aux(xs)
    }
    aux(this.valores.toList).toFloat/this.valores.toList.length.toFloat
  }

  def produto(intervalo2: Intervalo): Intervalo = {
    val lim_arr: Array[Int] = Array(
      this.lim_inf * intervalo2.lim_inf,
      this.lim_inf * intervalo2.lim_sup,
      this.lim_sup * intervalo2.lim_inf,
      this.lim_sup * intervalo2.lim_sup
    )
    new Intervalo(f"[${lim_arr.min},${lim_arr.max}]")
  }

  def uniao(intervalo2: Intervalo): Seq[Int] = {
    if (this.lim_inf < intervalo2.lim_inf) {
      this.valores ++ intervalo2.valores.filter(x => !contem(x));
    }else {
      intervalo2.valores.filter(x => !contem(x)) ++ this.valores
    }
  }

  def diferenca(intervalo2: Intervalo): Seq[Int] = {
    this.valores.filter(x => !intervalo2.valores.contains(x))
  }

  def interseccao(intervalo2: Intervalo): Seq[Int] = {
    this.valores.filter(x => intervalo2.valores.contains(x))
  }

  def produtoCartesiano(intervalo2: Intervalo): Seq[(Int,Int)] = {
    for {i <- this.valores; j <- intervalo2.valores} yield {(i,j)}
  }

}
