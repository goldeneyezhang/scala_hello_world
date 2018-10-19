class Greeter(prefix: String, suffix: String) {
    def greet(name: String): Unit =
        println(prefix + name + suffix)
}
case class Point(x: Int, y: Int)
trait TGreeter {
    def greet(name: String): Unit = 
        println("Hello," + name + "!")
}
class DefaultGreeter extends TGreeter

class CustomizableGreeter(prefix: String, postfix: String) extends TGreeter {
    override def greet(name: String): Unit = {
        println(prefix + name + postfix)
    }
}