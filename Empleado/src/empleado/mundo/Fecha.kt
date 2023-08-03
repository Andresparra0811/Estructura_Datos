/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnologías de la Información
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Unidad de Estudios de Estructura de Datos
 * Ejercicio: Empleados
 * Basado en el ejercicio de Cupi2
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package empleado.mundo

/**
 * Clase para representar una fecha.
 */
class Fecha(
    /**
     * Día de la fecha.
     */
    private val dia: Int,
    /**
     * Mes de la fecha.
     */
    private val mes: Int,
    /**
     * Año de la fecha.
     */
    private val anio: Int
) {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------


    /**
     * Retorna el día de la fecha.
     * @return Día de la fecha.
     */
    fun darDia(): Int {
        return dia
    }

    /**
     * Retorna el mes de la fecha.
     * @return Mes de la fecha.
     */
    fun darMes(): Int {
        return mes
    }

    /**
     * Retorna el año de la fecha.
     * @return Año de la fecha.
     */
    fun darAnio(): Int {
        return anio
    }

    /**
     * Retorna la diferencia en meses que hay entre dos fechas.
     * @param pFecha Fecha contra la que se está comparando. pFecha != null.
     * @return Diferencia en meses de la fechas.
     */
    fun darDiferenciaEnMeses(pFecha: Fecha): Int {
        var diferencia = 0
        val otroAnho = pFecha.darAnio()
        val otroMes = pFecha.darMes()
        val otroDia = pFecha.darDia()

        // Calcula la diferencia en meses
        diferencia = 12 * (otroAnho - anio) + (otroMes - mes)

        // Si el día no es mayor, resta un mes
        if (otroDia < dia) {
            diferencia--
        }
        return diferencia
    }

    /**
     * Retorna una cadena que representa la fecha.
     * @return Cadena con la información de la fecha, sigue el formato dia-mes-año.
     */
    override fun toString(): String {
        return "$dia-$mes-$anio"
    }

}
