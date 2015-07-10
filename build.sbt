organization := "com.gvolpe"

name := """akka-pub-sub"""

version := "1.0"

scalaVersion := "2.11.7"

val akkaVersion = "2.3.12"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-contrib" % akkaVersion,
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion,
  "org.scalatest" %% "scalatest" % "2.2.4" % "test"
)

