package it.kallsu.scala.workshop.h2.hierarchy

/**
  * Simple extension
  *
  * @tparam C
  */
trait MessageExtension[C] {
  val extension: C
}

/**
  *
  * @param header
  * @param content
  * @param extension
  */
case class ComplexMessage(override val header: Option[String],
                          override val content: Option[String],
                          override val extension: String)
  extends SimpleMessage(header, content)
    with MessageExtension[String] {
}

/**
  *
  */
object ComplexMessage {
  def apply(header: Option[String], content: Option[String], extension: String): ComplexMessage = {
    new ComplexMessage(header, content, extension)
  }
}

/**
  * IDEAS ?????
  */