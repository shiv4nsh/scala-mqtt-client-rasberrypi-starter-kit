package com.knoldus

import com.typesafe.config.ConfigFactory
import org.eclipse.paho.client.mqttv3._
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence

/**
  *
  * MQTT subcriber
  *
  * @author Shivansh
  * @mail shiv4nsh@gmail.com
  *
  */

object MQTTSubscriber extends App {

  val config = ConfigFactory.load()
  val url = config.getString("mosquitto-server.url")
  val port = config.getInt("mosquitto-server.port")

  def subscribeToCommands() {

    val brokerUrl = s"tcp://$url:$port"
    val topic = "TemperatureEvent"
    val persistence = new MemoryPersistence
    val client = new MqttClient(brokerUrl, MqttClient.generateClientId, persistence)
    client.connect()
    client.subscribe(topic)
    val callback = new MqttCallBackImpl
    client.setCallback(callback)

  }

  subscribeToCommands()
}

class MqttCallBackImpl extends MqttCallback {
  override def messageArrived(topic: String, message: MqttMessage): Unit = {
    println(s"Receiving Data | Topic : $topic | Message : $message")
  }

  override def connectionLost(cause: Throwable): Unit = {
    println(cause.toString)
  }

  override def deliveryComplete(token: IMqttDeliveryToken): Unit = {
    println(s"Delivered Message :${token.getMessage}")
  }
}
