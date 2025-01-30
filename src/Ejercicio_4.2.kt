class Persona(val peso: Double, var altura: Double) {

    val imc: Double
        get() = peso / (altura * altura)

    var nombre: String? = null

    constructor(nombre: String, peso: Double, altura: Double) : this(peso, altura){
        this.nombre = nombre
    }

    override fun toString(): String {
        return "Nombre: $nombre, Peso: $peso kg, Altura: $altura m, IMC: ${"%.2f".format(imc)}"
    }


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Persona) return false
        return this.peso == other.peso && this.altura == other.altura
    }
}


fun main() {

    val persona1 = Persona(64.0, 1.86)
    val persona2 = Persona("Antonio", 54.0, 1.60)
    val persona3 = Persona("Adrián", 70.0, 1.75)


    println("Ingrese un nombre para la persona 1:")
    var nuevoNombre: String?
    do {
        nuevoNombre = readLine()
        if (nuevoNombre.isNullOrBlank()) {
            println("**ERROR** Inténtelo de nuevo")
        }
    } while (nuevoNombre.isNullOrBlank())

    persona1.nombre = nuevoNombre
    println("Para la persona 1: \nNombre: ${persona1.nombre}, Peso: ${persona1.peso}kg y Altura: ${persona1.altura}m")


    println("Para la persona 3: \nPeso: ${persona3.peso}kg, Altura: ${persona3.altura}m y IMC: ${persona3.imc}")

    persona3.altura = 1.80
    println("Para la persona 3: \nPeso: ${persona3.peso}kg, Altura: ${persona3.altura}m y IMC: ${persona3.imc}")

    persona2.altura = persona3.altura

    println(persona2)
    println(persona3)

    if(persona2 == persona3){
        println("La persona 2 y la persona 3 son iguales")
    } else {
        println("La persona 2 y la persona 3 no son iguales")
    }
}