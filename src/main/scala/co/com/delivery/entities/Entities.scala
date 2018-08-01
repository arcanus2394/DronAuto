package co.com.delivery.entities

import scala.util.Try

sealed trait Order
sealed trait Orientation

case class I() extends Order
case class A() extends Order
case class D() extends Order

case class Coord(intX: Int,intY: Int)
case class Drone(coord: Coord, orientation: Orientation, id:Int)
case class Deliver(deliver: List[Order])
case class Path(path:List[Deliver])
case class Delivered(delivered: List[Try[Drone]])

object Orientation {
  def newOrientation(c:Char):Orientation ={
    c.toUpper match {
      case 'N' => N()
      case 'S' => S()
      case 'E' => E()
      case 'W' => W()
      case _ => throw new IllegalArgumentException(s"Caracter invalido para creacion de instruccion: $c")
    }
  }
}

object Order {
  def newOrder(c:Char):Order ={
    c.toUpper match {
      case 'A' => A()
      case 'D' => D()
      case 'I' => I()
      case _ => throw new IllegalArgumentException(s"Caracter invalido para creacion de instruccion: $c")
    }
  }
}

case class N() extends Orientation{
  override def toString(): String ={
    "dirección Norte"
  }
}
case class S() extends Orientation{
  override def toString(): String ={
    "dirección Sur"
  }
}
case class E() extends Orientation{
  override def toString(): String ={
    "dirección Este"
  }
}
case class W() extends Orientation{
  override def toString(): String ={
    "dirección Oeste"
  }
}



