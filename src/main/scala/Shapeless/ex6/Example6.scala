package Shapeless.ex6

import shapeless._

import scala.collection.immutable

object Example6 extends App {
//  trait FromListable[A <: HList] {
//    def fromList(a: List[String]): Option[A]
//  }
//
//  implicit val fromListableSingleton = new FromListable[String :: HNil] {
//    override def fromList(a: List[String]): Option[String :: HNil] = a match {
//      case List(x) => Some(x :: HNil)
//      case _ => None
//    }
//  }
//
//  implicit def fromListableMultiple[Remain <: HList : FromListable] =
//    new FromListable[String :: Remain] {
//      override def fromList(a: List[String]): Option[String :: Remain] = a match {
//        case immutable.::(head, next) => implicitly[FromListable[Remain]].fromList(next).map(head :: _)
//        case Nil => None
//      }
//    }
//
//  def fromList[CC, Repr <: HList : FromListable](list: List[String])(implicit gen: Generic.Aux[CC, Repr]): Option[CC] =
//    implicitly[FromListable[Repr]].fromList(list)
//      .map(gen.from)
//
//  case class Cat(name: String)
//  val aaa = fromList(List("dsf"))

}
