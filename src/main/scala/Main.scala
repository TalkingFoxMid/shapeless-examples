import shapeless.{::, Generic, HList, HNil}

object Main extends App {
  trait IsAList[HL <: HList, A] {
    def toList(a: HL): List[A]
  }

  implicit def singletonAList[A] = new IsAList[A :: HNil, A] {
    override def toList(a: A :: HNil): List[A] = List(a.head)
  }

  implicit def stringListGeneric[Remaining <: HList, A](
    implicit isH: IsAList[Remaining, A]
  ) =
    new IsAList[A :: Remaining, A] {
      override def toList(a: A :: Remaining): List[A] =
        a.head :: isH.toList(a.tail)
    }

  def toListInt[CC, HL <: HList](cat: CC)(implicit a: IsAList[HL, Int],
                                          gen: Generic.Aux[CC, HL]): List[Int] =
    a.toList(gen.to(cat))

  case class Cat(age: Int, speed: Int, tail: Int)

  val lst: List[Int] = toListInt(Cat(1,2,3))
  println(lst)
}
