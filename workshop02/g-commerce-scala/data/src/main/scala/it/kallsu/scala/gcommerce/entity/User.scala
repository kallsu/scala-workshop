package it.kallsu.scala.gcommerce.entity

abstract class ParentClass(val session: Session)  {
}

case class Guest(override val session: Session) extends ParentClass(session) {}

case class User(override val session: Session,
                override val id : Long,
                val email: String,
                val pwd: String) extends ParentClass(session) with BaseEntity{
}
