import sbt._
import sbt.Keys._

name := "scala-mqtt-client-raspberryPi-starter-kit"

version := "1.0"

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  "org.eclipse.paho" % "org.eclipse.paho.client.mqttv3" % "1.0.2",
  "com.typesafe" % "config" % "1.2.1")

resolvers += "MQTT Repository" at "https://repo.eclipse.org/content/repositories/paho-releases/"

assemblyJarName in assembly := "raspi-mqtt-client.jar"