package Shapeless.ex2

import Shapeless.ex1.HListIsStrings.HListIsStrings
import shapeless._

object Example2 {
  import HListsIsA._

  def isInt[CORE <: HList](a: CORE)(implicit isA: HListIsA[CORE, Int]): Unit = ()
  def isString[CORE <: HList](a: CORE)(implicit isA: HListIsA[CORE, String]): Unit = ()

  isInt(1 :: HNil)
  isString("adsf" :: "sdfsf" :: HNil)
  // Won't compile:
  // isString(1 :: HNil)
  // isString("" :: 4 :: HNil)
}
