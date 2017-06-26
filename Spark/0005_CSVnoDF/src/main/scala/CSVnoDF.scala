import org.apache.log4j.Logger
import org.apache.log4j.Level
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

object CSVnoDF {

	Logger.getLogger("org").setLevel(Level.FATAL)
	Logger.getLogger("akka").setLevel(Level.FATAL)
	
	def main(args:Array[String]):Unit = {
		println("----------- CVSnoDF -----------")
		val sConf = new SparkConf().setAppName("CSVnoDF")
		val sc    = new SparkContext(sConf)
		// -------------------------------------------------------
		val archCSV:RDD[String] = sc.textFile("../../datos/refrescos.csv")
		val encabezado          = archCSV.first().split(",")
		val datosRDD            = archCSV.subtract(sc.parallelize(Array(archCSV.first())))
		println("\n" + "Num. elementos: " + archCSV.count())
		println("Encabezado:" + encabezado.mkString(" - "))
		println("Datos: ")
		datosRDD.foreach(cadena => println(cadena.replace(",", " - ")))
		// -------------------------------------------------------
		sc.stop()
	}
}