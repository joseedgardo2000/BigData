import org.apache.log4j.Logger
import org.apache.log4j.Level
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object NoAnomFunc{
	Logger.getLogger("org").setLevel(Level.FATAL)
	Logger.getLogger("akka").setLevel(Level.FATAL)
	
	def main(args:Array[String]):Unit = {
		println("-------------- NoAnomFunc --------------")
		val sConf     = new SparkConf().setAppName("NoAnomFunc")
		val sc        = new SparkContext(sConf)
		val arreglo   = Array("uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", "diez")
		val arrNum    = Array(1,2,3,4,5)
		val arrRDD    = sc.parallelize(arreglo)
		val arrNumRDD = sc.parallelize(arrNum)
		val mapRDD01  = arrRDD.map(Funciones.elementoContenido)
		val mapRDD02  = arrRDD.map(Funciones.mapaContenido)
		//------------------------------------------------------
		mapRDD01.take(10).foreach(println)
		println("-----------------------------------------------")
		mapRDD02.take(10).foreach(println)
		println("\narrNum Reducido: " + arrNumRDD.reduce(Funciones.reductorNumeros))
		println("mapRDD02 reducido: " + mapRDD02.reduce(Funciones.reductorTuplas))
		//------------------------------------------------------
		sc.stop()
	}
}