import Dependencies._

ThisBuild / scalaVersion := "2.12.8"
ThisBuild / organization := "it.kallsu.scala-workshop"
ThisBuild / name := "scala-workshop"
ThisBuild / version := "0.0.1-SNAPSHOT"
ThisBuild / resolvers ++= Seq(
    "Typesafe" at "http://repo.typesafe.com/typesafe/releases/",
    "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
    "Maven2 Repository" at "https://repo.maven.apache.org/maven2/"
  )

lazy val commons = (project in file("commons"))
    	.settings(
		libraryDependencies ++= basicLibraries
	)

lazy val data = (project in file("data"))
	.settings(
		libraryDependencies ++= basicLibraries
	).dependsOn(commons)


lazy val business = (project in file("business"))
	.settings(
		libraryDependencies ++= basicLibraries
	).dependsOn(commons, data)

lazy val application = (project in file("application"))
    .settings(
      libraryDependencies ++= basicLibraries
    ).dependsOn(commons, data, business)
