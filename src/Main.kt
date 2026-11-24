
fun main() {

    val alumnos = mutableListOf<Alumno>()
    var opcion: Int?

    // Menú Principal
    do {
        println()
        println("===== GESTOR DE ALUMNOS =====")
        println("1. Registrar alumno")
        println("2. Listar alumnos")
        println("3. Calcular media del grupo")
        println("4. Mostrar aprobados")
        println("5. Mostrar suspensos")
        println("6. Buscar alumno")
        println("7. Eliminar alumno")
        println("8. Salir")
        print("Seleccione una opción: ")

        opcion = readln().toIntOrNull()

    // Llamada a las funciones

        when (opcion) {
            1 -> registrarAlumno(alumnos)
            2 -> listarAlumnos(alumnos)
            3 -> calcularMedia(alumnos)
            4 -> mostrarAprobados(alumnos)
            5 -> mostrarSuspensos(alumnos)
            6 -> buscarAlumno(alumnos)
            7 -> eliminarAlumno(alumnos)
            8 -> println("Saliendo del programa...")
            else -> println("Error: opción no válida.")
        }

    } while (opcion != 8)
}
