package Shapeless.ex2

import shapeless.{::, HList, HNil}

object HListsIsA {
  sealed trait HListIsA[CORE <: HList, A]

  implicit def hnilIsStrings[A]: HListIsA[HNil.type, A] =
    new HListIsA[HNil.type, A] {}

  implicit def singleStringIsA[A]: HListIsA[A :: HNil, A] =
    new HListIsA[A :: HNil, A] {}

  implicit def listIsStrings[Tail <: HList, A](implicit hListIsA: HListIsA[Tail, A]): HListIsA[A :: Tail, A] =
    new HListIsA[A :: Tail, A] {}
}
