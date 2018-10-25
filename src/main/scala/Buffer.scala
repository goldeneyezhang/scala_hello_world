trait Buffer {
    type T
    val element: T
}
abstract class SeqBuffer extends Buffer {
    type U
    type T <: Seq[U]
    def length = element.length
}

abstract class IntSeqBuffer extends SeqBuffer {
    type U = Int
}

object BufferTest {
    def newIntSeqBuf(elem1: Int, elem2: Int): IntSeqBuffer = 
        new IntSeqBuffer {
            type T = List[U]
            val element = List(elem1,elem2)
        }
  
}