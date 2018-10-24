case class User(name: String, age: Int)
object Foobar {
    def foo(n: Int, v: Int) =
        for(i <- 0 until n;
            j<-i until n if i + j == v)
            yield (i, j)
}