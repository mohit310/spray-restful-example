package com.example

import spray.httpx.SprayJsonSupport
import spray.json.DefaultJsonProtocol

/**
 * Created by mohit on 7/22/15.
 */
case class Person(name: String, age: Int)

object PersonJsonProtocol extends DefaultJsonProtocol with SprayJsonSupport{
  implicit val PersonFormats = jsonFormat2(Person)
}
