import scala.language.implicitConversions

object List2OrderedTest {
    implicit def list2ordered[A](x: List[A])
        (implicit elem2ordered: A => Ordered[A]): Ordered[List[A]] =
        new Ordered[List[A]] {
            // replace with a more useful implementation
            def compare(that: List[A]): Int = 1
    }
    implicit def int2Integer(x: Int) = 
        java.lang.Integer.valueOf(x)
    implicit def int2Range(num: Int): Range = 1 to num

    def sayHello(age: Int)(implicit name: String) = println("my name is:" + name + ",my age is:" + age)

    def spreadNum(range: Range): String = range.mkString(",")

}

class Man(val name: String)

class SuperMan(val name: String) {
    def fly = println("you can fly")
}