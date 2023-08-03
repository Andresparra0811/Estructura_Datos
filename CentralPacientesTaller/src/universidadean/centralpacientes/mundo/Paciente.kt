/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean
 * Programa de Ingeniería de Sistemas
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Unidad de Estudios: Estructura de Datos
 * Ejercicio: Central de pacientes
 *
 * Fecha: Febrero de 2021
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
    private var codigo = 0

    /**
     * El nombre del paciente
     */
    private var nombre: String = ""

    /**
     * Clínica a la que asiste el paciente
     */
    private var clinica: String = ""

    /**
     * La información médica del paciente
     */
    private var informacionMedica: String = ""

    /**
     * Sexo del paciente
     */
    private var sexo = 0

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
        verificarInvariante()
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Retorna el código del paciente
     * @return El código del paciente
     */
    fun darCodigo(): Int {
        return codigo
    }

    /**
     * Retorna el nombre del paciente
     * @return El nombre del paciente
     */
    fun darNombre(): String {
        return nombre
    }

    /**
     * Retorna la clínica asignada al paciente
     * @return La clínica asignada al paciente
     */
    fun darClinica(): String {
        return clinica
    }

    /**
     * Retorna la información médica del paciente
     * @return La información médica del paciente
     */
    fun darInformacionMedica(): String {
        return informacionMedica
    }

    /**
     * Retorna el sexo del paciente
     * @return El sexo del paciente
     */
    fun darSexo(): Int {
        return sexo
    }


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

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------
    /**
     * Verifica que el invariante de la clase se cumpla. Si algo falla, lanza un AssertError. <br></br>
     * inv:
     * codigo >= 0
     * nombre != ""
     * clinica != ""
     * informacionMedica != ""
     * sexo == HOMBRE o sexo == MUJER
     */
    private fun verificarInvariante() {
        require(codigo >= 0) { "Código inválido" }
        require(nombre != "") { "Nombre inválido" }
        require(clinica != "") { "Clínica inválida" }
        require(informacionMedica != "") { "Información médica inválida" }
        require(sexo == HOMBRE || sexo == MUJER) { "Valor inválido para el atributo sexo" }
    }
}