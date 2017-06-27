import org.apache.log4j.Logger
import org.apache.log4j.Level
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object Params {

	Logger.getLogger("org").setLevel(Level.FATAL)
	Logger.getLogger("akka").setLevel(Level.FATAL)
	
	def main(args:Array[String]):Unit = {
		println("------------- Params -------------")
		val sConf = new SparkConf().setAppName("Params")
		val sc    = new SparkContext(sConf)
		//----------------------------------------------
		val paramsRDD = sc.parallelize(args)
		println("Parametros desde el array de argumentos: " + args.mkString(" - "))
		println("Parametros paralelizados: ")
		paramsRDD.foreach(println)
		//----------------------------------------------
		sc.stop()
	}
}