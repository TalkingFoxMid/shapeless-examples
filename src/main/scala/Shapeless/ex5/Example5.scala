package Shapeless.ex5

import Shapeless.ex4.HListsIsA2.{HListsIsA2, _}
import shapeless.ops.hlist.Mapper
import shapeless._

import scala.collection.immutable

object Example5 extends App {
  object toStringPoly extends Poly1 {
    implicit def allCase[A]: Case.Aux[A, String] =
      at(_.toString)
  }

  def toJson[CC, A <: HList, B <: HList](cc: CC)(
    implicit
    gen: Generic.Aux[CC, A],
    mapper: Mapper.Aux[toStringPoly.type, A, B],
    bIsStrings: HListsIsA2[B, String]
  ): String =
    bIsStrings.toList(
      mapper.apply(
        gen.to(cc)
      )
    ).mkString(";")

  case class Cat(age: Int)

  toJson(Cat(4))


}
