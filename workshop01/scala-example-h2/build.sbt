import Dependencies._

ThisBuild / scalaVersion := "2.12.8"
ThisBuild / organization := "it.kallsu.scala-example-h2"
ThisBuild / version := "0.0.1-SNAPSHOT"
ThisBuild / resolvers ++= Seq(
    "Typesafe" at "http://repo.typesafe.com/typesafe/releases/",
    "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
    "Maven2 Repository" at "https://repo.maven.apache.org/maven2/"
  )

lazy val exampleh2 = (project in file("."))
    .settings(
      libraryDependencies ++= basicLibraries
    )
