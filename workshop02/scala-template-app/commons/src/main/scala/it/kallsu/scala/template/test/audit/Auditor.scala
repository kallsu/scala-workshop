package it.kallsu.scala.template.test.audit

import it.kallsu.scala.template.test.logging.ApplicationLogger
import it.kallsu.scala.template.test.utils.DateUtils

trait Auditor {

  /**
    * Use the Self-Type to avoid the rewriting of all common logger
    * methods / functions.
    */
  this: ApplicationLogger =>

  /**
    * Who is Grimhilde ? ( https://en.wikipedia.org/wiki/Evil_Queen_(Disney) )
    *
    * @param start          formatted starting time
    * @param end            formatted ending time
    * @param additionalMsg  additional log message
    * @param callerFnResult result of execution
    * @return result of execution
    */
  protected def writeAudit[R <: Any](start: String,
                                     end: String,
                                     additionalMsg: String,
                                     callerFnResult: Option[R]): Option[R] = ???

  def audit0[R <: Any](initialMsg: String, callerFn: () => Option[R]): Option[R] = {
    // start time
    val start: String = DateUtils.formatNow()

    // execute the operation
    val result: Option[R] = callerFn()

    // end time
    val end: String = DateUtils.formatNow()

    // audit and return
    return writeAudit(start, end, initialMsg, result)
  }

  def audit1[T <: Any, R <: Any](initialMsg: String,
                                 callerFn: (T) => Option[R],
                                 param1: T): Option[R] = {
    // start time
    val start: String = DateUtils.formatNow()

    // execute the operation
    val result: Option[R] = callerFn(param1)

    // end time
    val end: String = DateUtils.formatNow()

    // audit and return
    return writeAudit(start, end, initialMsg, result)
  }

  def audit2[T1 <: Any, T2 <: Any, R <: Any](initialMsg: String,
                                             callerFn: (T1, T2) => Option[R],
                                             param1: T1,
                                             param2: T2): Option[R] = {
    // start time
    val start: String = DateUtils.formatNow()

    // execute the operation
    val result: Option[R] = callerFn(param1, param2)

    // end time
    val end: String = DateUtils.formatNow()

    // audit and return
    return writeAudit(start, end, initialMsg, result)
  }

  def audit3[T1 <: Any, T2 <: Any, T3 <: Any, R <: Any](initialMsg: String,
                                                        callerFn: (T1, T2, T3) => Option[R],
                                                        param1: T1,
                                                        param2: T2,
                                                        param3: T3): Option[R] = {
    // start time
    val start: String = DateUtils.formatNow()

    // execute the operation
    val result: Option[R] = callerFn(param1, param2, param3)

    // end time
    val end: String = DateUtils.formatNow()

    // audit and return
    return writeAudit(start, end, initialMsg, result)
  }

}
