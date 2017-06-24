import org.apache.log4j.Logger
import org.apache.log4j.Level
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

object ExternalDataset {

	Logger.getLogger("org").setLevel(Level.FATAL)
	Logger.getLogger("akka").setLevel(Level.FATAL)
	
	def main(args:Array[String]):Unit = {
		println("------------ 0004_ExternalDataset ------------")
		val sConf = new SparkConf().setAppName("ExternalDataset")
		val sc    = new SparkContext(sConf)
		//-------------------------------------------------------
		val archivoRDD = sc.textFile("../../datos/bigdata.txt")
		archivoRDD.foreach(println)
		val archivoGzRDD = sc.textFile("../../datos/gato.txt.gz")
		archivoGzRDD.foreach(println)
		//-------------------------------------------------------
		sc.stop()
	}
}