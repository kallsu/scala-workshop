package it.kallsu.scala.gcommerce.entity

import scala.util.Random

case class Session(val token: String,
                   val startTime: Long,
                   val expireTime: Long,
                   val renewalNo: Int) {
}

object Session {

  // 1 hour in milliseconds
  val defaultTokenValidity: Long = 60 * 60 * 1000

  def apply(): Session = {
    val startTime = System.currentTimeMillis()

    return new Session(token = generateToken(startTime),
      startTime,
      expireTime = {
        startTime + defaultTokenValidity
      },
      renewalNo = 0)
  }

  private def generateToken(time : Long): String = {
    // generate a small salt
    val salt = Random.alphanumeric.take(17).mkString

    // concatenate and make a list ( 13 chars of time + 17 chars of salt = 30 chars total )
    val chars = (salt + time.toString ).toList

    return Random.shuffle(chars).mkString
  }
}