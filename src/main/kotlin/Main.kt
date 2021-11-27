class Pila<E>(var lista:List<E?>){
    private val listaMutable = lista.toMutableList()

    fun tope(): E? = listaMutable.lastOrNull()

    fun push(elemento: E) = listaMutable.add(elemento)

    fun pop(): E? = if(!this.vacia()) listaMutable.removeAt(listaMutable.size - 1) else null

    fun vacia():Boolean = tope() == null

}

fun <E> reverse(lista: List<E>): List<E> {// =(lista?:listOf(null)).reversed()
    val pila = Pila(lista)
    val iterador = lista.listIterator()
    val resultado: MutableList<E> = mutableListOf()
    while(iterador.hasNext()) {
        resultado.add(pila.tope()!!) //Al estar dentro del bucle while, sabemos al 100% que existe, al menos, un elemento, y la funcion 'tope' no devolverá null.
        pila.pop()
        iterador.next()
    }
    return resultado
}

fun main() {
    val numbers = listOf("one", "two", "three", "four")
    val numbersRev = reverse(numbers)
    if (!listOf("four", "three", "two", "one").equals(numbersRev))
        println("Error")
    else
        println("Correcto")

    println(numbersRev)

    //Pruebas propias
    /*val li = listOf("one", "two")
    val pil = Pila(li)
    //pil.push("three")
    pil.pop()
    pil.pop()
    print(pil.tope())
    pil.pop()
    print(pil.tope())*/
}