# scala-mqtt-client-rasberrypi-starter-kit
A simple mqtt client application implemented in scala for M2M communications.

##What we'll build 
A solution where the Dev_Raspi can send events to the broker and the Dev_Laptop can subscribe to the event, in which the RaspberryPi will send its temperature events to the Broker and the subscriber will listen to it

##Steps to get started:
  1.This project will use Mosquitto as a broker. So if you have not installed mosquitto please follow the links here  (https://mosquitto.org/download/)
  2. We are considering here two device solution : Dev_Laptop (Subscriber) and Dev_RasberryPi (Publisher)
  3. So start your Mosquitto on Dev_Laptop.
  4.Configure the application.conf with the port and the url of the mosquitto server. 
  5. Make a assembly jar of this project using the following command.

    sbt assembly
  
  6. Copy the jar to RaspberryPi using the scp command.

      scp raspi-mqtt-client.jar pi@<pi-ip-address>:/home/pi/Projects/scala
  
  7. Run the Publisher on Dev_RaspberryPi using the following command
  
      java -cp raspi-mqtt-client.jar com.knoldus.MQTTPublisher

    This will start the publisher to sending the temperature events to broker. 
  
  8. Run the Subscriber on Dev_Laptop using the following command
  
      java -cp raspi-mqtt-client.jar com.knoldus.MQTTSubscriber

##Sumary 

Hurray ! You have successfully developed a sample IOT application :)
