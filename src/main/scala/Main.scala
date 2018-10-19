object Main extends App {
  println(1)
  println(1+1)
  println("Hello!")
  println("Hello, Shanghai!")
  
  //Functions
  println("------Functions--------")
  val addOne =(x:Int) => x+1
  println(addOne(1))
  val add = (x: Int,y: Int) => x + y
  println(add(1,2))
  
  //Methods
  println("-----Methods---------")
  def addMethods(x: Int,y: Int): Int = x + y
  println(addMethods(10,20))
  def addThenMultiply(x: Int,y: Int)(multiplier: Int): Int = (x + y) * multiplier
  println(addThenMultiply(1,2)(3))
  def name: String = System.getProperty("user.name")
  println("Hello, " + name + "!")
  
  def getSquareString(input: Double): String = {
    val square = input * input
    square.toString
  }
  println(getSquareString(10))

  // Classes
  println("-----Classes-----")
  val greeter = new Greeter("Hello, ","!")
  greeter.greet("Scala developer")

  //Case Classes
  println("-----Case Classes-----")
  val point = Point(1,2)
  val anotherPoint = Point(1,2)
  val yetAnotherPoint = Point(2,2)
  if (point == anotherPoint) {
   println(point + " and " + anotherPoint + " are the same.")
   } else {
    println(point + " and "+ anotherPoint + " are different.")
  }

  if (point == yetAnotherPoint) {
   println(point + " and " + yetAnotherPoint + " are the same.")
   } else {
    println(point + " and "+ yetAnotherPoint + " are different.")
  }

  // Ojbects
  println("-----Objects-----")
}
object IdFactory {
  private var counter = 0
}
