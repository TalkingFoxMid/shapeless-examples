package Shapeless.ex4

import shapeless.{HList, HNil}

object Example4 {
  import HListsIsA2._

  def toList[A, CORE <: HList](core: CORE)(implicit rule: HListsIsA2[CORE, A]): List[A] =
    rule.toList(core)

  val result1: List[Int] = toList(1 :: HNil)
  val result2: List[Int] = toList(1  :: "asdf":: HNil)
  val result3: List[String] = toList("dsf"  :: "asdf":: HNil)
}
