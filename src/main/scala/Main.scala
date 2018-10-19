import scala.collection.mutable.ArrayBuffer
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
  val newId: Int = IdFactory.create()
  println(newId)
  val newerId: Int = IdFactory.create()
  println(newerId)

  //Traits
  println("-----Traits-----")
  val greeter1 = new DefaultGreeter()
  greeter1.greet("Scala developer")

  val customerGreeter = new CustomizableGreeter("How are you, ","?")
  customerGreeter.greet("Scala developer")

  TypeHierarchy.show()
  //Class
  val point2 = new Point2(2,3)
  println(point2)
  val pointx = new Point2(1)
  println(pointx.x)

  val point3 = new Point3
  point3.x = 99
  point3.y = 101

  val iterator = new IntIterator(10)
  iterator.next() 
  iterator.next()

  //Subtyping

  val dog = new Dog("Harry")
  val cat = new Cat("Sally")

  val animals = ArrayBuffer.empty[Pet]
  animals.append(dog)
  animals.append(cat)
  animals.foreach(pet => println(pet.name))
  
  // Mixins
  val d = new D
  println(d.message)
  println(d.loudMessage)

  val richStringIter = new RichStringIter
  richStringIter foreach println
}
object IdFactory {
  private var counter = 0
  def create(): Int = {
    counter += 1
    counter
    }
}
object TypeHierarchy {
  def show(): Unit = {
   println("------Type Hierarchy-----")
    val list: List[Any] = List(
      "a string",
      732,
      'c',
      true,
      () => "an anonymous function returning a string"
    )
    list.foreach(element => println(element))

    val x: Long = 987654321
    val y: Float = x  // 9.8765434E8 (note that some precision is lost in this case)

    val face: Char = '☺'
    val number: Int = face  // 9786

  }
  
}
