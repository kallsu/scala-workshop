package it.kallsu.scala.gcommerce.business

import it.kallsu.scala.gcommerce.database.UserDAO
import it.kallsu.scala.gcommerce.entity.User

class UserManager {

  def login(email: String, password: String): Option[User] = {
    // use for to explode the possibility
    val user: Either[Throwable, Option[User]] = for {
      check1 <- validateUsername(email)
    } yield validatePassword(check1, password)

    // error case
    if(user.isLeft) {
      // please manage this with a custom error message
      None
    } else {
      user.right.get
    }
  }

  private def validatePassword(maybeUser: Option[User], pwd: String): Option[User] = {
    // I know that the user exist now
    val user = new UserDAO().findById(maybeUser.get.id)

    // simple text matching ... good only as example
    if (user.get.pwd equals pwd) {
      user
    } else {
      None
    }
  }

  private def validateUsername(email: String): Either[Throwable, Option[User]] = {
    val user = new UserDAO().findUser(email)

    if (user.isEmpty)
      Left(new NoSuchElementException("User not found"))
    else
      Right(user)
  }
}
