abstract class Animal {
    def name: String
}

case class Cat2(name: String) extends Animal
case class Dog2(name: String) extends Animal

object CovarianceTest {
    def printAnimalNames(animals: List[Animal]): Unit = {
        animals.foreach { animal =>
            println(animal.name)
        }
    }
}

abstract class Printer[-A] {
    def print(value: A): Unit
}

class AnimalPrinter extends Printer[Animal] {
    def print(animal: Animal): Unit =
        println("The animal's name is :"+ animal.name)
}

class CatPrinter extends Printer[Cat2] {
    def print(cat: Cat2): Unit =
        println("The cat's name is: " + cat.name)
}

object ContravarianceTest {
    val myCat: Cat2 = Cat2("Boots")

    def printMyCat(printer: Printer[Cat2]): Unit = {
        printer.print(myCat)
    }
}