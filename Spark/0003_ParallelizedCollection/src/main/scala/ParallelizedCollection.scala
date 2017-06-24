import org.apache.log4j.Logger
import org.apache.log4j.Level
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

object ParallelizedCollection {
	
	Logger.getLogger("org").setLevel(Level.FATAL)
	Logger.getLogger("akka").setLevel(Level.FATAL)
	
	def main(args:Array[String]):Unit = {
		println("----- ParallelizedCollection -----")
		val sconf = new SparkConf().setAppName("ParallelizedCollection")
		val sc    = new SparkContext(sconf)
		//----------------------------------------------------------
		val informacion             = Array(1,2,3,4,5)
		val informacionRDD:RDD[Int] = sc.parallelize(informacion)
		informacionRDD.foreach(println)
		//----------------------------------------------------------
		sc.stop()
	}
}
