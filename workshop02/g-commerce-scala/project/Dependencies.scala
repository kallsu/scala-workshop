import sbt._

object Dependencies {

  // -======================================================-
  // -= LIBRARY VERSIONS =-
  // -======================================================-
  lazy val versions: Map[String, String] = Map[String, String](
    "scalatest" -> "3.0.7",
    "logback" -> "1.2.3",
    "akka" -> "2.5.22",
    "akka-http" -> "10.1.8",
    "akka-spray-json" -> "10.1.8",
    "spray-json" -> "1.3.5",
  )

  // test
  lazy val testLibraries = Seq(
    "org.scalatest" %% "scalatest" % versions("scalatest") % Test
  )

  // logging + common + utils
  val commonLibraries = Seq(
    "ch.qos.logback" % "logback-classic" % versions("logback"),
    "io.spray" %% "spray-json" % versions("spray-json")
  )

  // akka
  val akkaLibraries = Seq(
    "com.typesafe.akka" %% "akka-actor" % versions("akka"),
    "com.typesafe.akka" %% "akka-stream" % versions("akka"),
    "com.typesafe.akka" %% "akka-http-core" % versions("akka-http"),
    "com.typesafe.akka" %% "akka-http" % versions("akka-http"),
    "com.typesafe.akka" %% "akka-slf4j" % versions("akka"),
    "com.typesafe.akka" %% "akka-http-spray-json" % versions("akka-spray-json"),
    
    "com.typesafe.akka" %% "akka-testkit" % versions("akka") % Test,
    "com.typesafe.akka" %% "akka-stream-testkit" % versions("akka") % Test,
    "com.typesafe.akka" %% "akka-http-testkit" % versions("akka-http") % Test
  )

  // database
  val databaseLibraries = Seq(
    "postgresql" % "postgresql" % "9.1-901-1.jdbc4"
  )

  // -======================================================-
  // -= PROJECT LIBRARIES =-
  // -======================================================-

  // basic project libraries
  lazy val basicLibraries = testLibraries ++ commonLibraries ++ akkaLibraries ++ databaseLibraries
}
