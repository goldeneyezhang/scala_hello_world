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

  // Higher Order Functions
  println("-----High Order Functions-----")
  val salaries = Seq(20000, 70000, 40000)
  val doubleSalary = (x: Int) => x*2
  val newSalaries = salaries.map(doubleSalary)
  salaries.map(x => println(x))
  val salaryList : List[Double]= List(100.05d,200.03d,300d,400d,500d)
  println(SalaryRaiser.smallPromotion(salaryList))
  println(SalaryRaiser.bigPromotion(salaryList))
  println(SalaryRaiser.hugePromotion(salaryList))

  val domainName = "www.example.com"
  def getURL = SalaryRaiser.urlBuilder(ssl=true, domainName)
  val endpoint = "users"
  val query= "id=1"
  val url = getURL(endpoint, query)
  println(url)

  // Nested Methods
 println("Factorial of 2: " + NestedMethods.factorial(2))
 println("Factorial of 3: " + NestedMethods.factorial(10))

 // Curring
  val numbers = List(1,2,3,4,5,6,7,8,9,10)
  val res = numbers.foldLeft(0)((m, n) => m + n)
  println(res)
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
object SalaryRaiser {
  private def promotion(salaries: List[Double], promotionFunction: Double => Double): List[Double] =
    salaries.map(promotionFunction)

  def smallPromotion(salaries: List[Double]): List[Double] = 
    promotion(salaries,salary => salary * 1.1d)

  def bigPromotion(salaries: List[Double]): List[Double] =
    promotion(salaries, salary => salary * math.log(salary))
  
  def hugePromotion(salaries: List[Double]): List[Double] =
    promotion(salaries, salary => salary * salary)

    // Functions that return funcitons
    def urlBuilder(ssl: Boolean, domainName: String): (String,String) => String = {
      val schema = if (ssl) "https://" else "http://"
      (endpoint: String,query: String) => s"$schema$domainName/$endpoint?$query"
      }
}
object NestedMethods {
  def factorial(x: Int): Int = {
    def fact(x: Int,accumulator: Int): Int = {
      if (x <= 1) accumulator
      else fact(x - 1,x * accumulator)
    }
    fact(x, 1)
  }
}
trait Curring {
  def foldLeft[B](z: B)(op :(B, A) => B): B
}
