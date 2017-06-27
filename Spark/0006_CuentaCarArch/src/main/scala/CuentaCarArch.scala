import org.apache.log4j.Logger
import org.apache.log4j.Level
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object CuentaCarArch {

	Logger.getLogger("org").setLevel(Level.FATAL)
	Logger.getLogger("akka").setLevel(Level.FATAL)
	
	def main(args:Array[String]):Unit = {
		println("------------- CuentaCarArch -------------")
		val sConf = new SparkConf().setAppName("CuentaCarArch")
		val sc    = new SparkContext(sConf)
		//------------------------------------------------------
		val archText  = sc.textFile("../../datos/bigdata.txt")
		val tamLineas = archText.map(linea => linea.length) 
		val numCarTot = tamLineas.reduce((acc, elem) => acc + elem)
		println("Numero total de caracteres: " + numCarTot)
		//------------------------------------------------------
		sc.stop()
	}
}