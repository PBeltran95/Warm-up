fun main() {

    printDireccionFormateada(direccion1)
    formatArrayToString(arrayOf(direccion1,direccion2, direccion3))

}

fun formatArrayToString(directions:Array<Direction>){
    for (direction in directions){
        if (direction.piso != null && direction.departament != null){
            println( "piso: ${direction.piso} ; depto: ${direction.departament}")
        }
    }
}


fun printDireccionFormateada(direction: Direction) {
    with(direction) {
        println(
            if (direction.piso == null && direction.departament == null) {
                "Hola a todos, vivo en $pais, soy de la provincia de $provincia, en el partido de $partido, " +
                        "vivo en la calle ${calle.keys.first().nombreDeCalle} ${calle.keys.first().numero}," +
                        " que queda entre las calles ${calle.values.first().entreCalle1} y ${calle.values.first().entreCalle2}, " +
                        "ademas, mi codigo postal es $codigoPostal."
            } else {
                "Hola a todos, vivo en $pais, soy de la provincia de $provincia, en el partido de $partido, " +
                        "vivo en la calle ${calle.keys.first().nombreDeCalle} ${calle.keys.first().numero}, " +
                        "que queda entre las calles ${calle.values.first().entreCalle1} y ${calle.values.first().entreCalle2}, " +
                        "ademas, mi codigo postal es $codigoPostal, vivo en el piso: $piso y mi departamento es el numero $departament."
            }
        )
    }
}

data class Direction(
    var ciudad: String = "",
    var partido: String = "",
    var provincia: String = "",
    var calle: Map<NombreDeCalle, EntreCalles> = mapOf(),
    var pais: String = "",
    var codigoPostal: Int = 0,
    var piso: Int?,
    var departament: Int?
)

data class NombreDeCalle(
    val nombreDeCalle: String,
    val numero: Int
)

data class EntreCalles(
    val entreCalle1: String = "",
    val entreCalle2: String = ""
)

val direccion1 = Direction(
    "Neuquen",
    "Confluencia",
    "Neuquen",
    mapOf(NombreDeCalle("Lainez", 530) to EntreCalles("San Juan", "Planas")),
    "Argentina",
    8300,
    null,
    null
)
val direccion2 = Direction(
    "San Martin de los Andes",
    "Alumine",
    "Neuquen",
    mapOf(NombreDeCalle("Santa Fe", 860) to EntreCalles("Entre Rios", "San Juan")),
    "Argentina",
    8310,
    2,
    4
)
val direccion3 = Direction(
    "Viedma",
    "Adolfo Alsina",
    "Rio Negro",
    mapOf(NombreDeCalle("Linarez", 3020) to EntreCalles("Chocon", "Gonzales")),
    "Argentina",
    8658,
    null,
    null
)