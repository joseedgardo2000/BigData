import org.apache.log4j.Logger
import org.apache.log4j.Level
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object ContNoAnomFunc{
	Logger.getLogger("org").setLevel(Level.FATAL)
	Logger.getLogger("akka").setLevel(Level.FATAL)
	def main(args:Array[String]):Unit = {
		println("------------ ContNoAnomFunc ------------")
		val sConf = new SparkConf().setAppName("ContNoAnomFunc")
		val sc    = new SparkContext(sConf)
		//-------------------------------------------------
		val arr    = Array("uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", "diez")
		val arrRDD = sc.parallelize(arr)
		val acumulador = sc.longAccumulator("acumulador")
		val acumulador2 = sc.longAccumulator("acumulador2")
		val arrMap = arrRDD.map(linea=> {Funciones02.mapeador(linea, acumulador)})
		arrRDD.foreach(linea=>acumulador2.add(1))
		arrRDD.take(arrRDD.count.toInt).foreach(println)
		arrMap.take(arrMap.count.toInt).foreach(println)
		println("Acumulador: " + acumulador.value)
		println("Acumulador2: " + acumulador2.value)
		//-------------------------------------------------
		sc.stop()
	}
}