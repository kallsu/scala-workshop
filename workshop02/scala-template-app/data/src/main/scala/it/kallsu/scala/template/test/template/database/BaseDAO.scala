package it.kallsu.scala.template.test.template.database

import it.kallsu.scala.template.test.template.entity.BaseEntity

import scala.concurrent.Future

trait BaseDAO[T <: BaseEntity] {

  // Synchronous methods
  def findById(id : Long) : Option[T] = ???
  def getAll() : List[T] = ??? // no option here because collection package has .Empty construction
  def insert(entity : T) : Option[T] = ???
  def update(entity : T) : Option[T] = ???

  // Asynchronous methods
  def findByIdAsync(id : Long) : Future[T] = ???
  def getAllAsync() : Future[List[T]] = ???
  def insertAsync(entity : T) : Future[T] = ???
  def updateAsync(entity : T) : Future[T] = ???
}
