package it.kallsu.scala.exampleh1.methodcall

object CallByName extends App {

  def time(): Long = {
    println("In time()")
    System.nanoTime
  }

  def exec(t: => Long): Long = {
    println("Entered exec, calling t ...")
    println(s"t = ${t}")
    println("Calling t again ...")
    t
  }

  println(exec(time()))

}