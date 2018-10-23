import scala.util.Random

object CustomerID {
    def apply(name: String) = s"$name--${Random.nextLong}"

    def unapply(customerID: String): Option[String] = {
        val stringArray: Array[String] = customerID.split("--")
        if (stringArray.tail.nonEmpty) Some(stringArray.head) else None
    }
}