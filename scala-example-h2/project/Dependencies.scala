import sbt._

object Dependencies {

    // -======================================================-
    // -= LIBRARY VERSIONS =-
    // -======================================================-
    lazy val versions: Map[String, String] = Map[String, String](
      "scalatest" -> "3.2.0-SNAP10",
      "logback" -> "1.2.3"
    );

    // test
    lazy val testLibraries = Seq(
      "org.scalatest" %% "scalatest" % versions("scalatest") % Test
    );

    // logging + common + utils
    val commonLibraries = Seq(
      "ch.qos.logback" % "logback-classic" % versions("logback")
    );

    // -======================================================-
    // -= PROJECT LIBRARIES =-
    // -======================================================-

    // basic project libraries
    lazy val basicLibraries = testLibraries ++ commonLibraries
}
