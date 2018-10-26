trait Clonable extends java.lang.Cloneable {
    override def clone(): Cloneable = {
        super.clone().asInstanceOf[Cloneable]
    }
}
trait Resetable {
    def reset: Unit
}
object TestClone {
    /* def cloneAndReset(obj: Cloneable with Resetable): Cloneable = {
        val cloned = obj.clone()
        obj.reset
        cloned
    } */
}
