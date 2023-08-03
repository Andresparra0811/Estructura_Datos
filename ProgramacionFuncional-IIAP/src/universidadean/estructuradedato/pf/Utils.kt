/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Utils.kt,v 1.0 2021/11/16 $
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas - Facultad de Ingeniería
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Ejercicio: Personas
 * Fecha: Nov 17 de 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package universidadean.estructuradedato.pf

import com.opencsv.CSVReader
import ean.collections.IList
import ean.collections.TList
import java.io.FileReader
import java.lang.Exception

/**
 * Conjunto de métodos de utilidad para el proyecto de Personas
 */
object Utils {
    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------
    private val ARCHIVO_DATOS: String = "data/Personas.csv"

    //-----------------------------------------------------------------
    // Métodos generales
    //-----------------------------------------------------------------

    fun leerPersonas(): IList<Persona>? {
        var n: Int = 0
        val personas: IList<Persona> = TList()

        try {
            val reader: CSVReader = CSVReader(FileReader(ARCHIVO_DATOS))
            var info = reader.readNext()

            while (info != null) {
                if (n > 0) {
                    val cedula = info[0].toInt()
                    val edad = info[1].toInt()
                    val genero = if (info[2] == "1") 'M' else 'F'
                    val hijos = info[3].toInt()
                    val nivel = when (info[4]) {
                        "1" -> "PRIMARIA"
                        "2" -> "SECUNDARIA"
                        "3" -> "UNIVERSIDAD"
                        else -> "POSTGRADO"
                    }
                    val estrato = info[5].toInt()
                    val ingresos = info[6].toInt()
                    val peso = info[7].toInt()
                    val talla = info[8].toInt()
                    val fuma = info[9] == "1"
                    val lentes = info[10] == "1"
                    val casa = info[11] == "1"
                    val automovil = info[12] == "1"

                    val p = Persona(
                        cedula, edad, genero, hijos, nivel, estrato, ingresos,
                        peso, talla, fuma, lentes, casa, automovil
                    )

                    personas.add(p)
                }
                n++
                info = reader.readNext()
            }
        }
        catch (ex: Exception) {
            ex.printStackTrace()
            return null
        }
        return personas
    }
}
