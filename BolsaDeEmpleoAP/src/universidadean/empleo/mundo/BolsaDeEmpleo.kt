/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnología de la Información y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Basado en un Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: Bolsa de Empleo
 * Fecha: 28 de octubre de 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package universidadean.empleo.mundo

import ean.collections.IList
import ean.collections.TList

/**
 * Es la clase que se encarga de manejar y organizar los aspirantes
 */
class BolsaDeEmpleo {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la lista que contiene todos los aspirantes
     */
    private val aspirantes: IList<Aspirante> = TList()

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye una nueva bolsa de emplea sin aspirantes.
     */
    constructor()

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna una lista de aspirantes. La lista retornada no es la misma que la almacenada en esta clase, pero si tiene el mismo orden.
     *
     * @return lista de aspirantes
     */
    fun darAspirantes(): IList<Aspirante> {
        return aspirantes.copy()
    }

    /**
     * Agrega un nuevo aspirante a la bolsa
     */
    fun agregarAspirante(nombreA: String, profesionA: String, aniosExperienciaA: Int, edadA: Int, telefonoA: String, imagenA: String): Boolean {
        val aspiranteBuscado: Int = buscarAspirante(nombreA)
        var agregado = false
        if (aspiranteBuscado == -1) {
            val nuevoAspirante = Aspirante(nombreA, profesionA, aniosExperienciaA, edadA, telefonoA, imagenA)
            aspirantes.add(nuevoAspirante)
            agregado = true
        }
        return agregado
    }

    /**
     * Organiza la lista de aspirantes por nombre usando el algoritmo de burbuja.
     */
    fun ordenarPorNombre(): Unit {
        val comparadorNombre: Comparator<Aspirante> = compareBy(Aspirante::nombre)

        val n = aspirantes.size
        repeat(n){
            for (j in 0 until n-1){
                if (comparadorNombre.compare(aspirantes[j],aspirantes[j+1]) > 0){
                    var t = aspirantes[j]
                    aspirantes[j]= aspirantes[j+1]
                    aspirantes[j+1] = t
                    }
                }
            }
    }

    /**
     * Organiza la lista de aspirantes por edad usando el algoritmo de selección
     */
    fun ordenarPorEdad() {
        val comparadorEdad: Comparator<Aspirante> = compareBy(Aspirante::edad)


            fun findPositionMinElem(pos: Int): Int {
                val n= aspirantes.size
                var menor=aspirantes[pos]
                var respuesta:Int=aspirantes.indexOf(menor)
                for (i in 0 until n-1){
                    for (j in pos until n){
                        if (comparadorEdad.compare (aspirantes[j],menor) < 0){
                            menor= aspirantes[j]
                            respuesta= aspirantes.indexOf(aspirantes[j])
                        }

                    }
                }
                return respuesta
            }
            for (i in 0 until aspirantes.size-1) {
                val m = findPositionMinElem(i)
                if (i != m) {
                    var t= aspirantes[i]
                    aspirantes[i]= aspirantes[m]
                    aspirantes[m]= t
                }
            }

    }

    /**
     * Organiza la lista de aspirantes por profesión usando el algoritmo de burbuja
     */
    fun ordenarPorProfesion() {
        val comparadorProfesion: Comparator<Aspirante> = compareBy(Aspirante::profesion)
        val n = aspirantes.size

        repeat(n){
            for (j in 0 until n-1){
                if (comparadorProfesion.compare(aspirantes[j],aspirantes[j+1]) > 0){
                    var t = aspirantes[j]
                    aspirantes[j]= aspirantes[j+1]
                    aspirantes[j+1] = t
                }
            }

        }

    }

    /**
     * Organiza la lista de aspirantes por años de experiencia usando el algoritmo de inserción
     */
    fun ordenarPorAniosDeExperiencia() {
        val comparadorExp :Comparator<Aspirante> = compareBy(Aspirante::aniosExperiencia)
       fun findPositionMinElem(pos: Int): Int {
           val n= aspirantes.size
           var menor=aspirantes[pos]
           var respuesta:Int=aspirantes.indexOf(menor)
           for (i in 0 until n-1){
               for (j in pos until n){
                   if (comparadorExp.compare(aspirantes[j],menor) < 0){
                       menor= aspirantes[j]
                       respuesta= aspirantes.indexOf(aspirantes[j])
                   }

               }
           }
                return respuesta
            }

            for (i in 0 until aspirantes.size) {
                val m = findPositionMinElem(i)
                if (i != m) {
                    var t= aspirantes[i]
                    aspirantes[i]= aspirantes[m]
                    aspirantes[m]= t
                }
            }


    }

    /**
     * Busca un Aspirante según su nombre y retorna la posición en la que se encuentra.
     * Use búsqueda lineal.
     */
    fun buscarAspirante(nombre: String): Int {
        var respuesta:Int= -1
        for (i in 0 until aspirantes.size){
                var elemento:Aspirante= aspirantes[i]
                if (elemento.nombre == nombre){
                    respuesta = i
                }
            }
            return respuesta
        }



    /**
     * Busca un aspirante utilizando una búsqueda binaria. <br></br>
     * Ojo: La lista de aspirantes se encuentra ordenada por nombre. <br></br>
     */
    fun buscarBinarioPorNombre(nombre: String): Int {
        var posicion = -1
        var ini = 0
        var fin: Int = aspirantes.size - 1
        while (ini <= fin && posicion != -1){
            var puntoMedio= (ini+fin)/2
            if (aspirantes[puntoMedio].nombre == nombre){
                posicion= aspirantes.indexOf(aspirantes[puntoMedio])
            }
            else{
                if (nombre<aspirantes[puntoMedio].nombre){
                    fin= puntoMedio-1
                }
                else{
                    ini= puntoMedio+1
                }
            }
        }
        return posicion
    }

    /**
     * Busca el aspirante que tenga la menor edad en la bolsa de empleo.
     *
     * Se retornó la posición donde se encuentra el aspirante más joven.
     * Si no hay aspirantes en la bolsa se retornó -1
     */
    fun buscarAspiranteMasJoven(): Int {

        var aspiranteMasJoven = aspirantes[0]
        var aspiranteMasJovenPos= -1
        val comparadorEdad: Comparator<Aspirante> = compareBy(Aspirante::edad)

        for (i in 0 until aspirantes.size) {
            if (comparadorEdad.compare(aspirantes[i], aspiranteMasJoven) < 0){
                aspiranteMasJoven = aspirantes[i]
                aspiranteMasJovenPos = i

            }
        }

        return aspiranteMasJovenPos



    }

    /**
     * Busca el aspirante que tenga la mayor edad en la bolsa.
     *
     * Se retornó la posición donde se encuentra el aspirante con más edad.
     * Si no hay aspirantes en la bolsa se retornó -1
     */
    fun buscarAspiranteMayorEdad(): Int {

        var aspiranteMayorEdad = aspirantes[0]
        var aspiranteMayorEdadPos= -1
        val comparadorEdad: Comparator<Aspirante> = compareBy(Aspirante::edad)

        for (i in 0 until aspirantes.size) {
            if (comparadorEdad.compare(aspirantes[i], aspiranteMayorEdad) > 0){
                aspiranteMayorEdad = aspirantes[i]
                aspiranteMayorEdadPos= i
            }
        }

        return  aspiranteMayorEdadPos
    }

    /**
     * Busca el aspirante con más años de experiencia en la bolsa.
     *
     * Se retornó la posición donde se encuentra el aspirante con mayor experiencia.
     * Si no hay aspirantes en la bolsa se retornó -1
     */
    fun buscarAspiranteMayorExperiencia(): Int {

        var aspiranteMayorExp = aspirantes[0]
        var aspiranteMayorExpPos= -1
        val comparadorExp: Comparator<Aspirante> = compareBy(Aspirante::aniosExperiencia)

        for (i in 0 until aspirantes.size) {
            if (comparadorExp.compare(aspirantes[i], aspiranteMayorExp) > 0){
                aspiranteMayorExp = aspirantes[i]
                aspiranteMayorExpPos = i
            }
        }

        return  aspiranteMayorExpPos
    }

    /**
     * Contrata a un aspirante.
     * Es decir, se eliminó el aspirante con el nombre dado de la lista de aspirantes.
     *
     * Se retornó true si el aspirante estaba registrado en la bolsa
     * o false de lo contrario
     */
    fun contratarAspirante(nombre: String): Boolean {
        var respuesta= false
        var posicionAspirante = buscarAspirante(nombre)
        if (posicionAspirante != -1){
            aspirantes.remove(posicionAspirante)
            respuesta=true
        }
        return respuesta
    }

    /**
     * Elimina todos los aspirantes de la bolsa cuyos años de experiencia
     * son menores a la cantidad de años especificada
     * Retorna la cantidad de aspirantes que fueron eliminados
     */
    fun eliminarAspirantesPorExperiencia(aniosExperiencia: Int): Int {
        var cont = 0
        var i= 0
        while(i<aspirantes.size){
            if (aspirantes[i].aniosExperiencia < aniosExperiencia){
                aspirantes.remove(i)
                cont++
            }
            else{
                i++
            }
        }

        return cont
    }

}