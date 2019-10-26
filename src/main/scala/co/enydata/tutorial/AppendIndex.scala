package co.enydata.tutorial

import co.enydata.tutorial.model.Album
import org.apache.spark.sql.SparkSession
import org.elasticsearch.spark.sql._

/**
 * Write to ElasticSearch
 *
 */
object AppendIndex extends App with Spark  {


  import spark.implicits._

  val indexDocuments = Seq(
    Album("Led Zeppelin",1969,"Led Zeppelin"),
    Album("Boston",1976,"Boston"),
    Album("Fleetwood Mac", 1979,"Tusk")
  ).toDF

  indexDocuments.write
    .format("org.elasticsearch.spark.sql")
    .mode("Append")
    .save("demoindex/albumindex")

}
