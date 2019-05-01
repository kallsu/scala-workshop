package it.kallsu.scala.template.test

class AuditorTestCaseScenario {

  def giveMeFive(): Option[Int] = {
    return Some(5)
  }

  def addOne(a: Int): Option[Int] = {
    return Some(a + 1)
  }

  def sum(a: Int, b: Int): Option[Int] = {
    Some(a + b)
  }

  def prodAssociative(a: Int, b: Int, c: Int): Option[Int] = {
    Some(a * (b+c))
  }
}