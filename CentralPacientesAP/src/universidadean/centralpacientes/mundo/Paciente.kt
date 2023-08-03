/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean
 * Programa de Ingeniería de Sistemas
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Unidad de Estudios: Estructura de Datos
 * Ejercicio: Central de pacientes
 *
 * Fecha: Marzo de 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package universidadean.centralpacientes.mundo

// -----------------------------------------------------------------
// Constantes
// -----------------------------------------------------------------

/**
 * Constante para representar a un Hombre
 */
const val HOMBRE = 1
/**
 * Constante para representar a una mujer
 */
const val MUJER = 2

/**
 * Esta clase representa un paciente del hospital <br>
 * inv:
 * codigo >= 0
 * nombre != null && nombre != ""
 * clinica != null && clinica != ""
 * informacionMedica != null
 * sexo == HOMBRE o sexo == MUJER
 */
class Paciente {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * El código del paciente
     */
    var codigo = 0

    /**
     * El nombre del paciente
     */
    var nombre: String = ""

    /**
     * Clínica a la que asiste el paciente
     */
    var clinica: String = ""

    /**
     * La información médica del paciente
     */
    var informacionMedica: String = ""

    /**
     * Sexo del paciente
     */
    var sexo = 0

    /**
     * El siguiente paciente de la lista
     */
    var siguiente: Paciente? = null

    // -----------------------------------------------------------------
    // Constructor primario
    // -----------------------------------------------------------------
    constructor()

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Construye un paciente
     * @param cod El código del paciente - cod >= 0
     * @param nom El nombre del paciente - nom!=null y nom!=""
     * @param clin La clínica del paciente - clin!=null y clin!=""
     * @param infoMed la información médica del paciente - infoMed!=null
     * @param sex El sexo del paciente. sex pertenece a { HOMBRE, MUJER }
     */
    constructor(cod: Int, nom: String, clin: String, infoMed: String, sex: Int) {
        codigo = cod
        nombre = nom
        clinica = clin
        informacionMedica = infoMed
        sexo = sex
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna una cadena con la información del paciente
     * @return [ codigo ]: nombre
     */
    override fun toString(): String {
        return "[ $codigo ]: $nombre"
    }

    /**
     * Cambia la información médica del paciente
     * @param informacion Nueva información médica del paciente
     */
    fun cambiarInformacionMedica(informacion: String) {
        informacionMedica = informacion
    }
}