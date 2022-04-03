package Shapeless.ex3

import shapeless.{::, HList, HNil}

object HListRuled {
  sealed trait HListRuled[CORE <: HList, F[_]]

  implicit def hnilIsStrings[F[_]]: HListRuled[HNil.type, F] =
    new HListRuled[HNil.type, F] {}

  implicit def singleRuledIsRuled[F[_], A](implicit rule: F[A]): HListRuled[A :: HNil, F] =
    new HListRuled[A :: HNil, F] {}

  implicit def listRuled[Tail <: HList, A: F, F[_]](implicit hListIsA: HListRuled[Tail, F]): HListRuled[A :: Tail, F] =
    new HListRuled[A :: Tail, F] {}
}
