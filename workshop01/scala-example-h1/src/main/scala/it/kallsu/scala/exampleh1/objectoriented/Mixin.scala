package it.kallsu.scala.exampleh1.objectoriented

abstract class A {
  val message: String
}

class B extends A {
  val message = "I'm an instance of class B"
}

trait C extends A {
  def loudMessage: String = message.toUpperCase()
}

class D extends B with C

object Main1 {

  def main(args: Array[String]): Unit = {
    val d = new D

    // I'm an instance of class B
    println(d.message)

    // I'M AN INSTANCE OF CLASS B
    println(d.loudMessage)
  }
}



