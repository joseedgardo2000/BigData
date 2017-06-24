import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

object Coneccion{
	def main(args:Array[String]):Unit = {
		// Se crea primero el contexto de Spark
		val sconf = new SparkConf().setAppName("Coneccion")
		val sc    = new SparkContext(sconf)
		println("------ Conectado -----") 
		// Se detiene el contexto de spark
		sc.stop()
		println("--------- STOP -------")
	}
}
