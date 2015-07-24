package com.example

import spray.httpx.SprayJsonSupport
import spray.json._

/**
 * Created by mohit on 7/22/15.
 */
case class Person(name: String, age: Int)

object PersonJsonProtocol extends DefaultJsonProtocol with SprayJsonSupport{

  implicit object PersonJsonFormat extends RootJsonFormat[Person] {
    def write(p: Person) = JsObject(
      "name" -> JsString(p.name),
      "age" -> JsNumber(p.age)
    )

    def read(value: JsValue) = {
      value.asJsObject.getFields("name", "age") match {
        case Seq(JsString(name), JsNumber(age)) =>
          new Person(name, age.toInt)
        case _ => throw new DeserializationException("Person expected")
      }
    }
  }
}
