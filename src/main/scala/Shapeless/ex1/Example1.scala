package Shapeless.ex1

import shapeless.{HList, HNil}

object Example1 extends App {

  import HListIsStrings._

  // We can use rule HListIsStrings for any of HList to proof that this generic list contains only Strings
  // We can't create this rule manually:

  // This code won't compile, because trait HListIsStrings is sealed:

  // val ruleIsStrings = new HListIsStrings[String :: HNil] {}

  // There is only one way to proof that HList contains only Strings.q
  // And this is recursive auto-derivation by implicits that we can find in HListIsStrings object.

  def isStrings[A <: HList](a: A)(implicit isStrings: HListIsStrings[A]): Unit = ()

  isStrings("1" :: "2" :: "3" :: HNil)
  isStrings("1" :: HNil)
  isStrings(HNil)
  isStrings("1" :: "2" :: "3" :: "4" :: "5" :: HNil)

  // But this will not compile because there is no implicit HListIsStrings[String :: Int :: HNil]

  // isStrings("1" :: 4 :: HNil)
  // isStrings(4 :: HNil)


}
