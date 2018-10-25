abstract class Animal3 {
    def name: String
}
abstract class Pet3 extends Animal3 {}

class Cat3 extends Pet3 {
    override def name: String = "Cat"
}

class Dog3 extends Pet3 {
    override def name: String = "Dog"
}

class Lion3 extends Animal3 {
    override def name: String = "Lion"
}

class PetContainer[P <: Pet3](p: P) {
    def pet: P = p
}