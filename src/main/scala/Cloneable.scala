trait Clonable extends java.lang.Cloneable {
    override def clone(): Cloneable = {
        super.clone().asInstanceOf[Cloneable]
    }
}
trait Resetable {
    def reset: Unit
}
