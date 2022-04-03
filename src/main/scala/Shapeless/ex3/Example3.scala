package Shapeless.ex3

import Shapeless.ex2.HListsIsA
import Shapeless.ex2.HListsIsA.HListIsA
import cats.kernel.Monoid
import shapeless.{HList, HNil}

object Example3 extends App {
  import HListRuled._
  case class WithoutMonoid()

  def isMonoids[CORE <: HList](a: CORE)(implicit isA: HListRuled[CORE, Monoid]): Unit = ()

  isMonoids(1 :: "" :: HNil)

  // Won't compile:
//   isMonoids(1 :: "" :: WithoutMonoid() :: HNil)

}
