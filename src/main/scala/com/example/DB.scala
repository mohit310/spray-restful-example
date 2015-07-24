package com.example

import sorm._

/**
 * Created by mkeswani on 7/24/2015.
 */
object DB extends Instance(
  entities = Set(Entity[Person](unique = Set() + Seq("name"))),
  url = "jdbc:h2:mem:test",
  user = "",
  password = "",
  initMode = InitMode.Create,
  poolSize = 12
)
