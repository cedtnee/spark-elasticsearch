package co.enydata.tutorial

import co.enydata.tutorial.model.Album
import org.apache.spark.sql.SparkSession
import org.elasticsearch.spark.sql._

/**
  * Write to ElasticSearch
  *
  */
object UpsertIndex extends App with Spark {


  import spark.implicits._

  //init
  Seq(
    Album("Led Zeppelin", 1969, "Led Zeppelin"),
    Album("Boston", 1976, "Boston"),
    Album("Fleetwood", 2009, "Tusk")
  ).toDF.write
    .format("org.elasticsearch.spark.sql")
    .option("es.mapping.id", "artist")
    .option("es.write.operation", "upsert")
    .mode("append")
    .save("demoindex2/albumindex2")

  //upsert
  Seq(
    Album("Led Zeppelin", 1969, "Led Zeppelin"),
    Album("Boston", 1976, "Boston"),
    Album("Fleetwood", 1979, "Tusk"),
    Album("Eminen", 2002, "8 Miles SoundTrack")
  ).toDF.write
    .format("org.elasticsearch.spark.sql")
    .option("es.mapping.id", "artist")
    .option("es.write.operation", "upsert")
    .mode("append")
    .save("demoindex2/albumindex2")
}
