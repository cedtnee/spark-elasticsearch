package co.enydata.tutorial

import org.apache.spark.sql.SparkSession

trait Spark {

  val spark = SparkSession
    .builder()
    .appName("WriteToES")
    .master("local[*]")
    .config("spark.es.nodes","8d14f913142a4ef08cb5880de59a8ef7.europe-west1.gcp.cloud.es.io")
    .config("spark.es.port","9243")
    .config("spark.es.nodes.wan.only","true")
    .config("spark.es.net.ssl","true")
    .config("spark.es.net.http.auth.user","elastic")
    .config("spark.es.net.http.auth.pass","MrwcggSwMrUzd15xLiyw5e7S")
    .getOrCreate()
}
