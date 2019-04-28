package it.kallsu.scala.template.app

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json._

trait JsonSupport extends SprayJsonSupport with DefaultJsonProtocol {

  // Using Spray Json
  // Spray Json github : https://github.com/spray/spray-json

  // define here the classes

  //implicit val itemFormat = jsonFormat2(Item)
  //implicit val orderFormat = jsonFormat1(Order)
}
