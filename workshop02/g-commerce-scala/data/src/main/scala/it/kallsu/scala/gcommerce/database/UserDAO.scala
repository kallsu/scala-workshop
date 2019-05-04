package it.kallsu.scala.gcommerce.database

import it.kallsu.scala.gcommerce.entity.{Session, User}

class UserDAO extends BaseDAO[User] {

  def findUser(email: String): Option[User] = {

    // execute the query here

    // mock to execute the test
    val even = System.currentTimeMillis() % 2

    if (even == 0)
      return Some(new User(Session.apply, id = 1, email = email, pwd = "fakePwd"))
    else
      None
  }

  def findUser(email: String, password: String): Option[User] = {

    // execute the query here

    // mock to execute the test
    val even = System.currentTimeMillis() % 2

    if (even == 0)
      return Some(new User(Session.apply, id = 1, email = email, pwd = password))
    else
      None
  }
}
