package Shapeless.ex4

import shapeless.{::, HList, HNil}

object HListsIsA2 {
  def apply[CORE <: HList, A](implicit rule: HListsIsA2[CORE, A]): HListsIsA2[CORE, A] = rule

  sealed trait HListsIsA2[CORE <: HList, A] {
    def toList(a: CORE): List[A]
  }

  implicit def hnilIsStrings[A]: HListsIsA2[HNil.type, A] =
    new HListsIsA2[HNil.type, A] {
      override def toList(a: HNil.type): List[A] = Nil
    }

  implicit def singleStringIsA[A]: HListsIsA2[A :: HNil, A] =
    new HListsIsA2[A :: HNil, A] {
      override def toList(a: A :: HNil): List[A] = List(a.head)
    }

  implicit def listIsStrings[Tail <: HList, A](implicit hListIsA: HListsIsA2[Tail, A]): HListsIsA2[A :: Tail, A] =
    new HListsIsA2[A :: Tail, A] {
      override def toList(a: A :: Tail): List[A] =
        List(a.head) ::: implicitly[HListsIsA2[Tail, A]].toList(a.tail)
    }
}
