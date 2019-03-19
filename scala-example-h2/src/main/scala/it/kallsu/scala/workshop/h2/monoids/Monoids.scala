package it.kallsu.scala.workshop.h2.monoids

trait Monoid[A] {

  def operation(value1 : A, value2 : A) : A

  def zero : A
}

class StringMonoid extends Monoid[String] {

  def operation(value1 : String, value2 : String) : String = { s"$value1 + $value2"}

  def zero = ""
}

class ListMonoid extends Monoid[List[Any]] {

  def operation(value1 : List[Any], value2 : List[Any]) : List[Any] = { value1 ++ value2}

  def zero = Nil
}

