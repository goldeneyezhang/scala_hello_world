import scala.collection.mutable.ArrayBuffer
import scala.util.Random
import scala.util.matching.Regex

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
  val res2 =numbers.foldLeft(0)(_+_) 
  println(res)
  println(res2)
  val numberFunc = numbers.foldLeft(List[Int]())_
  val squares = numberFunc((xs, x) => xs:+ x*x)
  println(squares.toString())
  // 复杂
  val cubes = numberFunc((xs, x) => xs:+ x*x*x)
  println(cubes.toString())

  // Case Class
  val frankenstein = Book("978-0486282114")
  println(frankenstein)
  var message1 = Message("Guillaume@quebec.ca","jorge@catalonia.es", "Ça va ?")
  // message1.sender = "travis@washington.us"  // this line does not compile
  println(message1.sender)
  // Pattern
  val patternX: Int = Random.nextInt(10)

  patternX match {
    case 0 => "zero"
    case 1 => "one"
    case 2 => "two"
    case _ => "many"
  }

  var someSms = SMS("12345", "Are you there?")
  val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")
  println(Pattern.showNotification(someSms))  // prints You got an SMS from 12345! Message: Are you there?
  println(Pattern.showNotification(someVoiceRecording))  // you received a Voice Recording from Tom! Click the link to hear it: voicerecording.org/id/123
  val importantPeopleInfo = Seq("867-5309", "jenny@gmail.com")
  val someSms2 = SMS("867-5309", "Are you there?")
  val someVoiceRecording2 = VoiceRecording("Tom", "voicerecording.org/id/123")
  val importantEmail = Email("jenny@gmail.com", "Drinks tonight?",  "I'm free after 5!")
  val importantSms = SMS("867-5309", "I'm here! Where are you?")

  println(Pattern.showImportantNotification(someSms,importantPeopleInfo))
  println(Pattern.showImportantNotification(someVoiceRecording, importantPeopleInfo))
  println(Pattern.showImportantNotification(importantEmail, importantPeopleInfo))
  println(Pattern.showImportantNotification(importantSms, importantPeopleInfo))

  val circle1 = new Circle(5.0)
  println(circle1.area)

  // Regex
  val numberPattern: Regex = "[0-9]".r
  numberPattern.findFirstMatchIn("awesomepassword") match {
      case Some(_) => println("Password OK")
      case None => println("Password must contain a number")
  }
  val keyValPattern: Regex = "([0-9a-zA-Z-#() ]+): ([0-9a-zA-Z-#() ]+)".r
  val input: String = 
     """background-color: #A03300;
    |background-image: url(img/header100.png);
    |background-position: top center;
    |background-repeat: repeat-x;
    |background-size: 2160px 108px;
    |margin: 0;
    |height: 108px;
    |width: 100%;""".stripMargin

 for (patternMatch <- keyValPattern.findAllMatchIn(input))
  println(s"key: ${patternMatch.group(1)} value: ${patternMatch.group(2)}")
  // Extractor Objects
  val customer1ID = CustomerID("Sukyong")
  customer1ID match {
    case CustomerID(name) => println(name)
    case _ => println("Could not extract a CustomerID")
  }
  val CustomerID(name2) = "--asdfasdfasdf"

  //For Comprehensions
  val userBase = List(User("Travis", 28),
    User("Kelly", 33),
    User("Jennifer", 44),
    User("Dennis", 23))

  val twentySomethings = for (user <- userBase if(user.age >=20 && user.age < 30))
    yield user.name
  
  twentySomethings.foreach(name => println(name)) 

  Foobar.foo(10, 10) foreach {
      case (i, j) =>
          println(s"($i, $j) ") 
  }

  // Generic Classes
  val stack = new Stack[Int]
  stack.push(1)
  stack.push(2)
  println(stack.pop)
  println(stack.pop)

  val stack2 = new Stack[Fruit]
  val apple = new Apple
  val banana = new Banana
  // stack.push(apple)
  // stack.push(banana)

  // Covariance
  val cats: List[Cat2] = List(Cat2("Whiskers"), Cat2("Tom"))
  val dogs: List[Dog2] = List(Dog2("Fido"), Dog2("Rex"))
   CovarianceTest.printAnimalNames(cats)
   CovarianceTest.printAnimalNames(dogs)

   val catPrinter: Printer[Cat2] = new CatPrinter
   val animalPrinter: Printer[Animal] = new AnimalPrinter

   ContravarianceTest.printMyCat(catPrinter)
   ContravarianceTest.printMyCat(animalPrinter)

   // Upper Type Bounds
   val dogContainer = new PetContainer[Dog3](new Dog3)
   val catContainer = new PetContainer[Cat3](new Cat3)

   // this would not compile
   // val lionContainer = new PetContainer[Lion3](new Lion3)
   // Lower Type Bounds
   val africanSwallowList = ListNode[AfricanSwallow](AfricanSwallow(),Nil())
   val birdList: Node[Bird] = africanSwallowList
   birdList.prepend(new EuropeanSwallow)
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