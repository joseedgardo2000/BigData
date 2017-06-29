import org.apache.spark.util.LongAccumulator

object Funciones02{
	def mapeador(linea:String, acumulador:LongAccumulator):Tuple2[Int, String] = {
		acumulador.add(1)
		Tuple2(linea.length, linea)
	}
}