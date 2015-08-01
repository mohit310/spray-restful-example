package com.example

import slick.driver.H2Driver.api._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._


/**
 * Created by mohit on 7/31/15.
 */
object PersonDB {

  val persons = TableQuery[Persons]
  val db = Database.forConfig("h2mem1")

  val setup = DBIO.seq(
    // Create the tables, including primary and foreign keys
    (persons.schema).create
  )

  val setupFuture = db.run(setup)


  def retrieveAll(): List[Person] = {
    val q1 = persons.to[List].result
    val f: Future[List[Person]] = db.run(q1)
    Await.result(f, 5.seconds)
  }

  def insert(p: Person): Unit = db.run(DBIO.seq(persons += p))

}
