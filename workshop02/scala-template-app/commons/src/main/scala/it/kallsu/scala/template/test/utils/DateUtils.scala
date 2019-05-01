package it.kallsu.scala.template.test.utils

import java.text.SimpleDateFormat
import java.util.Date

object DateUtils {

  /**
    * Format the given java.util.Date
    *
    * @param date the java.util.Date to format
    * @param format format for java.util.Date following java.text.SimpleDateFormat
    *
    * @return
    */
  def formatDate(date: java.util.Date, format: String = "yyyy-MM-dd HH:mm:ssZ"): String =
    return new SimpleDateFormat(format).format(date)

  /**
    * Format the current instant.
    *
    * @param format optional parameter, the default is the ISO-8601
    * @return string as date formatted
    */
  def formatNow(format: String = "yyyy-MM-dd HH:mm:ssZ"): String =
    return formatDate(new Date(), format)

}
