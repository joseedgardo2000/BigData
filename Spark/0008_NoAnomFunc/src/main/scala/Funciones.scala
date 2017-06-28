object Funciones {
	def elementoContenido(linea:String): String = {
		"elemento: " + linea
	}
	
	def mapaContenido(linea:String): Tuple2[Int, String] = {
		(linea.length, linea)
	}
	
	def reductorNumeros(acumulador:Int, elemento:Int):Integer = {
		acumulador + elemento
	}
	
	def reductorTuplas(acumulador:Tuple2[Int, String], elemento:Tuple2[Int, String]): Tuple2[Int,String] = {
		Tuple2(acumulador._1 + elemento._1, "Resultado")
	}
	
}