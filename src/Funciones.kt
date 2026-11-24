
/*
 * FUNCIÓN: REGISTRAR ALUMNO
 * Permite introducir los datos de un alumno
 * y guardarlos en la lista.
 */
fun registrarAlumno(alumnos: MutableList<Alumno>) {

    // Pedimos el nombre y eliminamos espacios al principio y al final
    print("Introduce el nombre: ")
    val nombre = readln().trim()

    // Pedimos los apellidos del alumno
    print("Introduce los apellidos: ")
    val apellidos = readln().trim()

    // Comprobamos que el nombre y los apellidos no estén vacíos
    if (nombre.isEmpty() || apellidos.isEmpty()) {
        println("Error: el nombre y los apellidos no pueden estar vacíos.")
        return // Salimos de la función si hay algún error
    }

    // Pedimos la nota y la convertimos a un número decimal
    // Aceptamos tanto comas como puntos para los decimales
    print("Introduce la nota final: ")
    val nota = readln().replace(",", ".").toDoubleOrNull()

    // Comprobamos que sea un número válido entre 0 y 10
    if (nota == null || nota !in 0.0..10.0) {
        println("Error: la nota debe estar entre 0 y 10.")
        return
    }

    // Creamos un alumno y lo añadimos a la lista
    alumnos.add(Alumno(nombre, apellidos, nota))

    println("Alumno registrado correctamente.")
}


/*
 * FUNCIÓN: LISTAR ALUMNOS
 * Muestra todos los alumnos que hemos registrado.
 */
fun listarAlumnos(alumnos: List<Alumno>) {

    // Comprobamos si la lista está vacía
    if (alumnos.isEmpty()) {
        println("No hay alumnos registrados.")
        return
    }

    println("===== LISTADO DE ALUMNOS =====")

    // Recorremos la lista mostrando cada alumno y su posición
    alumnos.forEachIndexed { indice, alumno ->

        // Sumamos 1 porque las posiciones empiezan en 0
        println("${indice + 1}. ${alumno.nombre} ${alumno.apellidos} - Nota: ${alumno.nota}")
    }
}


/*
 * FUNCIÓN: CALCULAR MEDIA
 * Calcula la media de las notas de todos los alumnos.
 */
fun calcularMedia(alumnos: List<Alumno>): Double {

    // Evitamos calcular la media si no hay alumnos
    if (alumnos.isEmpty()) {
        println("No hay alumnos para calcular la media.")
        return 0.0
    }

    // Obtenemos las notas y calculamos su media
    val media = alumnos.map { it.nota }.average()

    // Mostramos la media con dos decimales
    println("La media del grupo es: %.2f".format(media))

    // Devolvemos el resultado de la media
    return media
}


/*
 * FUNCIÓN: MOSTRAR APROBADOS
 * Muestra únicamente los alumnos con nota igual o superior a 5.
 */
fun mostrarAprobados(alumnos: List<Alumno>) {

    // Filtramos los alumnos que tienen una nota de 5 o más
    val aprobados = alumnos.filter { it.nota >= 5.0 }

    println("===== ALUMNOS APROBADOS =====")

    // Comprobamos si hay alumnos aprobados
    if (aprobados.isEmpty()) {
        println("No hay alumnos aprobados.")
    } else {

        // Mostramos solamente los alumnos aprobados
        listarAlumnos(aprobados)
    }
}


/*
 * FUNCIÓN: MOSTRAR SUSPENSOS
 * Muestra los alumnos que tienen una nota inferior a 5.
 */
fun mostrarSuspensos(alumnos: List<Alumno>) {

    // Filtramos los alumnos que tienen una nota menor que 5
    val suspensos = alumnos.filter { it.nota < 5.0 }

    println("===== ALUMNOS SUSPENSOS =====")

    // Comprobamos si hay alumnos suspensos
    if (suspensos.isEmpty()) {
        println("No hay alumnos suspensos.")
    } else {

        // Mostramos solamente los alumnos suspensos
        listarAlumnos(suspensos)
    }
}


/*
 * FUNCIÓN: BUSCAR ALUMNO
 * Permite buscar alumnos por nombre o apellidos.
 * No hace falta escribir el nombre completo.
 */
fun buscarAlumno(alumnos: List<Alumno>) {

    // Pedimos el texto que queremos buscar
    print("Introduce el texto a buscar: ")
    val texto = readln().trim()

    // Comprobamos que el usuario haya escrito algo
    if (texto.isEmpty()) {
        println("Error: introduce un criterio de búsqueda.")
        return
    }

    // Buscamos coincidencias en los nombres y apellidos
    // ignoreCase permite buscar sin distinguir mayúsculas
    val encontrados = alumnos.filter {
        it.nombre.contains(texto, ignoreCase = true) ||
                it.apellidos.contains(texto, ignoreCase = true)
    }

    // Comprobamos si hemos encontrado algún alumno
    if (encontrados.isEmpty()) {
        println("No se han encontrado alumnos con ese criterio.")
    } else {

        // Mostramos los alumnos encontrados
        println("===== RESULTADOS DE LA BÚSQUEDA =====")
        listarAlumnos(encontrados)
    }
}


/*
 * FUNCIÓN: ELIMINAR ALUMNO
 * Permite eliminar un alumno indicando su número en la lista.
 */
fun eliminarAlumno(alumnos: MutableList<Alumno>) {

    // Comprobamos si existen alumnos registrados
    if (alumnos.isEmpty()) {
        println("No hay alumnos para eliminar.")
        return
    }

    // Mostramos los alumnos para elegir cuál eliminar
    listarAlumnos(alumnos)

    // Pedimos el número del alumno que queremos eliminar
    print("Introduce el número del alumno que deseas eliminar: ")
    val posicion = readln().toIntOrNull()

    // Comprobamos que el número introducido sea válido
    if (posicion == null || posicion !in 1..alumnos.size) {
        println("Error: el alumno seleccionado no existe.")
        return
    }

    // Eliminamos el alumno de la lista
    // Restamos 1 porque las posiciones empiezan en 0
    alumnos.removeAt(posicion - 1)

    println("Alumno eliminado correctamente.")
}
