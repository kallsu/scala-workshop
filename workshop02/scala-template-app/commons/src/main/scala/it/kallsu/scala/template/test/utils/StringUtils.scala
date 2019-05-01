package it.kallsu.scala.template.test.utils

object StringUtils {

  def isEmpty(value: String): Boolean = {
    if (value == null)
      return true

    else if (value.isBlank)
      return true

    else if (value.matches("[^\\S]*"))
      return true

    else
      return false
  }

  def isEmpty(value: Option[String]): Boolean = {
    if (value.isEmpty)
      return true

    return isEmpty(value.getOrElse(""))
  }
}
