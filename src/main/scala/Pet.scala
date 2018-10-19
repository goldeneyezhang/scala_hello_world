

trait Pet {
    val name: String
}

class Cat(val name: String) extends Pet
class Dog(val name: String) extends Pet
abstract class AbsIterator {
    type T 
    def hasNext: Boolean
    def next(): T 
}
class StringIterator(s: String) extends AbsIterator {
    type T = Char
    private var i = 0
    def hasNext = i < s.length
    def next() = {
        val ch = s charAt i 
        i += 1
        ch
    }
}

trait RichIterator extends AbsIterator {
    def foreach(f: T => Unit): Unit = while (hasNext) f(next())
}

class RichStringIter extends StringIterator("scala") with RichIterator
