package com.example

import org.specs2.mutable.Specification
import spray.http.MediaTypes._
import spray.http.StatusCodes._
import spray.http._
import spray.testkit.Specs2RouteTest

class MyServiceSpec extends Specification with Specs2RouteTest with MyService {
  def actorRefFactory = system

  "MyService" should {

    "return a success for PUT requests to the person" in {
      Put("/", HttpEntity(`application/json`,"""{ "name": "Mohit Keswani", "age": 35}""")) ~>
        setRoute ~> check {
        responseAs[String] === """{"status" : "success"}"""
      }
    }

    "return a Person for GET requests to the root path" in {
      Get("/") ~> getRoute ~> check {
        responseAs[String] contains "Mohit Keswani"
      }
    }

    "leave GET requests to other paths unhandled" in {
      Get("/kermit") ~> getRoute ~> check {
        handled must beFalse
      }
    }

    "return a MethodNotAllowed error for PUT requests to the root path" in {
      Put() ~> sealRoute(getRoute) ~> check {
        status === MethodNotAllowed
        responseAs[String] === "HTTP method not allowed, supported methods: GET"
      }
    }
  }
}
