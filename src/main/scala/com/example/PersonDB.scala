package com.example

/**
 * Created by mkeswani on 7/24/2015.
 */
object PersonDB {

  def insert(person: Person): Unit = DB.save(person)

  def retrieveAll(): List[Person] = DB.query[Person].fetch().toList


}
