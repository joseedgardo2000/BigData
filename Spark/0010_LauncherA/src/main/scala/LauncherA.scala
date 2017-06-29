import org.apache.spark.launcher.SparkLauncher

object LauncherA {
	def main(args:Array[String]):Unit = {
		println("LauncherA")
		val spark = new SparkLauncher()
							//.setSparkHome(sys.env("SPARK_HOME"))
							.setAppResource("0003_parallelizedcollection_2.11-1.0.jar")
							//.setMainClass("ParallelizedCollection")
							.setMaster("local[*]")
							.startApplication()
	}
}