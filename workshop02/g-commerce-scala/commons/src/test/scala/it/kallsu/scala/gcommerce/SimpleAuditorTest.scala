package it.kallsu.scala.gcommerce

import it.kallsu.scala.gcommerce.audit.SimpleAuditor
import org.scalatest.{FlatSpec, Matchers}

class SimpleAuditorTest extends FlatSpec with Matchers {

  val testCase: AuditorTestCaseScenario = new AuditorTestCaseScenario
  val auditor: SimpleAuditor = new SimpleAuditor("it.kallsu.scala.template.test.AuditorTest")

  "Auditor" should "log empty function" in {
    val opt: Option[Any] = auditor.audit0(initialMsg = "Initial Messsage",
      callerFn = testCase.giveMeFive)

    opt.isEmpty shouldBe false
    opt.getOrElse(0) shouldEqual 5
  }

  "Auditor" should "log 1 parameter function" in {
    val a: Int = 1
    val opt: Option[Int] = auditor.audit1[Int, Int]("", testCase.addOne, a)

    opt.isEmpty shouldBe false
    opt.getOrElse(0) shouldEqual 2
  }

  "Auditor" should "log 2 parameters function" in {
    val a: Int = 1
    val b: Int = 2
    val opt: Option[Int] = auditor.audit2[Int, Int, Int]("", testCase.sum, a, b)

    opt.isEmpty shouldBe false
    opt.getOrElse(0) shouldEqual 3
  }

  "Auditor" should "log 3 parameters function" in {
    val a: Int = 2
    val b: Int = 3
    val c: Int = 5

    val opt: Option[Int] = auditor.audit3[Int, Int, Int, Int]("", testCase.prodAssociative, a, b, c)

    opt.isEmpty shouldBe false
    opt.getOrElse(0) shouldEqual 16
  }
}
