package com.example
import slick.driver.H2Driver.api._

/**
 * Created by mohit on 7/31/15.
 */
class Persons(tag: Tag) extends Table[Person](tag, "PERSONS") {

  // This is the primary key column:
  def name = column[String]("NAME", O.PrimaryKey)

  def age = column[Int]("AGE")

  def * = (name, age) <> (Person.tupled, Person.unapply)
}
