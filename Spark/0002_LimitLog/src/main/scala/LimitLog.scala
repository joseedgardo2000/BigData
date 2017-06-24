import org.apache.log4j.Logger
import org.apache.log4j.Level
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object LimitLog{
	// Limitar los log a nivel de FATAL
    Logger.getLogger("org").setLevel(Level.FATAL)
	Logger.getLogger("akka").setLevel(Level.FATAL)
	def main(args:Array[String]):Unit = {
		println("------- LimitLog --------")
		val sconf = new SparkConf().setAppName("LimitLog")
		val sc    = new SparkContext(sconf)
		println("..... conectado ......")
		sc.stop()
		println("..... detenido .......")
	}
}
