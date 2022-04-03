package Shapeless.ex1

import shapeless.{::, HList, HNil}

object HListIsStrings {
  sealed trait HListIsStrings[CORE <: HList]

  implicit val hnilIsStrings: HListIsStrings[HNil.type] =
    new HListIsStrings[HNil.type] {}

  implicit val singleStringIsStrings: HListIsStrings[String :: HNil] =
    new HListIsStrings[String :: HNil] {}

  implicit def listIsStrings[Tail <: HList : HListIsStrings]: HListIsStrings[String :: Tail] =
    new HListIsStrings[String :: Tail] {}
}
