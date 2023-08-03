/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnología de la Información y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Basado en un Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: Bolsa de Empleo
 * Fecha: 27 de octubre de 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package universidadean.empleo.mundo

/**
 * Esta clase representa la información de un Aspirante
 */
data class Aspirante(val nombre: String,
                     val profesion: String,
                     val aniosExperiencia: Int,
                     val edad: Int,
                     val telefono: String,
                     val imagen: String) {

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    companion object {
        /**
         * Indica que la profesión es ADMINISTRADOR
         */
        @JvmField
        val ADMINISTRADOR = "Administrador"

        /**
         * Indica que la profesión es INGENIERO INDUSTRIAL
         */
        @JvmField
        val INGENIERO_INDUSTRIAL = "Ingeniero Industrial"

        /**
         * Indica que la profesión es contador
         */
        @JvmField
        val CONTADOR = "Contador"

        /**
         * Indica que la profesión es economista
         */
        @JvmField
        val ECONOMISTA = "Economista"

    }

    /**
     * Retorna una cadena con el nombre del aspirante, su profesión y los años de experiencia
     */
    override fun toString(): String {
        return "$nombre - $profesion"
    }


}