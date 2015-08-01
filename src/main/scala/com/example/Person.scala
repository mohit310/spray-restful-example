package com.example

import spray.httpx.SprayJsonSupport
import spray.json._

/**
 * Created by mohit on 7/22/15.
 */

case class Person(name: String, age: Int)

object PersonJsonProtocol extends DefaultJsonProtocol with SprayJsonSupport{
  implicit val PersonFormat = jsonFormat2(Person)
}
