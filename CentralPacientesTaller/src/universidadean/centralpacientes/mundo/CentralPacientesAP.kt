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

import ean.collections.IList
import ean.collections.TList
import kotlin.Throws

/**
 * Excepción generada cuando un paciente con un código dado no existe
 */
class NoExisteException(private val codigo: Int) : Exception("El paciente con código $codigo no está registrado")

/**
 * Excepción que informa que el paciente que se va a agregar ya está registrado en la central
 */
class YaExisteException(private val codigo: Int) : Exception("El paciente con código $codigo ya está registrado")

/**
 * Esta clase representa una central en la que se maneja una lista de pacientes
 */
class CentralPacientes {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Primer paciente de la lista
     */
    private val pacientes: IList<Paciente> = TList()

    /**
     * Vector de clínicas manejadas por la central
     */
    private val listaClinicas: IList<String> = TList()

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Retorna el número de pacientes de la clínica
     * @return El núme0ro de pacientes de la clínica
     */
    fun darNumeroPacientes(): Int {
        return pacientes.size
    }

    /**
     * Adiciona un paciente al principio de la lista
     * @param pac El paciente a ser agregado al comienzo de la lista.
     * @throws YaExisteException si hay otro paciente en la lista con un codigo igual a pac.codigo
     */
    fun agregarPacienteAlComienzo(pac: Paciente) {
        if (localizar(pac.darCodigo()) == null) {
            pacientes.addToHead(pac)
        }
        else {
            throw YaExisteException(pac.darCodigo())
        }

    }

    /**
     * Adiciona un paciente al final de la lista.
     * @param pac El paciente a ser agregado al final la lista.
     * @throws YaExisteException si hay otro paciente en la lista con un codigo igual a pac.codigo
     */
    fun agregarPacienteAlFinal(pac: Paciente) {
        if (localizar(pac.darCodigo())== null){
            pacientes.add(pac)
        }
        throw YaExisteException(pac.darCodigo())


    }

    /**
     * Adiciona un paciente a la lista de pacientes antes del paciente con el código especificado.
     * @param cod El código del paciente antes del que se va insertar el nuevo paciente.
     * @param pac El paciente que se va a adicionar.
     * @throws NoExisteException Si el paciente antes del que se va a realizar la adición no se encuentra registrado.
     * @throws YaExisteException si hay otro paciente en la lista con un codigo igual a pac.codigo
     */

    fun agregarPacienteAntesDe(cod: Int, pac: Paciente) {
        val sipacesta=localizar(pac.darCodigo())
        var posicion=encontrarPosicion(cod)
        if (posicion> -1 && sipacesta==null){
            posicion= posicion - 1
            pacientes.add(posicion,pac)
            }

        else{
            if (posicion==-1 ){

                throw NoExisteException(cod)
            }
            else if(sipacesta!=null){
                throw YaExisteException(pac.darCodigo())
            }
        }
    }

    /**
     * Adiciona un paciente a la lista de pacientes después del paciente con el código especificado.
     * @param cod El código del paciente después del que se va insertar el nuevo paciente.
     * @param pac El paciente que se va a adicionar.
     * @throws NoExisteException Si el paciente después del que se va a realizar la adición no se encuentra registrado.
     * @throws YaExisteException si hay otro paciente en la lista con un codigo igual a pac.codigo
     */
    fun agregarPacienteDespuesDe(cod: Int, pac: Paciente) {
        var posicion=encontrarPosicion(cod)
        val paciente_codigo=localizar(pac.darCodigo())
        if (posicion> -1 && paciente_codigo==null){
            posicion= posicion + 1
            pacientes.add(posicion,pac)
        }
        else {
            if (posicion==-1)
            {
                throw NoExisteException(cod)
            }
            else
            {
                throw YaExisteException(pac.darCodigo())
            }
        }

    }

    /**
     * Busca el paciente con el código dado en la lista de pacientes.
     * @param codigo El código del paciente que se va a buscar
     * @return El paciente con el código especificado. Si el paciente no existe se retorna null
     */
    fun localizar(codigo: Int): Paciente? {
        for (paciente in pacientes){
            if (paciente.darCodigo()== codigo){
                return paciente
            }
        }
        return null
    }

    /**
     * Busca la posición del paciente que tiene  el código especificado
     * @param cod Código del paciente del que se desea saber la posición
     * @return La posición (entre 0 y el tamaño - 1) donde se encuentra el primer paciente con el código dado. Si no se
     *         encuentra el paciente, deberá retornarse -1.
     */
    fun encontrarPosicion(cod: Int): Int {
        for (paciente in 0 until pacientes.size)
        {
            val codigo_paciente= pacientes[paciente]
            if (codigo_paciente.darCodigo()==cod)
            {
                return paciente
            }
        }
        return -1
    }


    /**
     * Elimina el paciente con el código especificado.
     * @param cod El código del paciente a ser eliminado. cod >= 0
     * @throws NoExisteException Si el paciente con el código especificado no existe y por tanto no pudo ser eliminado de la lista
     */
    @Throws(NoExisteException::class)
    fun eliminarPaciente(cod: Int) {
        if(localizar(cod)!= null)
        {
            val posicion=encontrarPosicion(cod)
            pacientes.remove(posicion)
        }
        else{
            throw NoExisteException(cod)
        }


    }

    /**
     * Devuelve una lista con los pacientes de la central
     * @return Lista de Pacientes
     */
    fun darPacientes(): IList<Paciente> {
        return pacientes
    }

    /**
     * Retorna la lista de clínicas manejadas por la central
     * @return La lista de clínicas manejadas por la central
     */
    fun darListaClinicas(): IList<String> {
        return listaClinicas
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------
    /**
     * Permite obtener el número de pacientes de sexo masculino que hay en la lista de pacientes
     * @return la cantidad de hombres
     */
    fun cantHombres(): Int {
        var cont = 0
        for (paciente in pacientes) {
            if (paciente.darSexo()== HOMBRE){
                cont++
            }

        return cont
    }
    }

    /**
     * Permite obtener el número de pacientes de sexo femenino que hay en la lista de pacientes
     * @return la cantidad de mujeres
     */
    fun cantMujeres(): Int {
        var cont = 0
        for (paciente in pacientes) {
            if (paciente.darSexo()== MUJER){
                cont++
            }
        }
        return cont
    }

    /**
     * Permite obtener el paciente con el menor código. Si la lista esta vacía se debe retornar null
     * @return el paciente con el código más pequeño o null si la lista está vacía
     */
    fun darPacienteMenorCodigo(): Paciente? {
        var pac: Paciente? = null
        if (pacientes.isNotEmpty()){
            var menor_codigo=0
            for (paciente in pacientes)
                if(paciente.darCodigo()<menor_codigo){
                    menor_codigo=paciente.darCodigo()
                    pac=paciente
                }
        }
        return pac
    }

    /**
     * Permite obtener el paciente con el mayor código. Si la lista esta vacía se debe retornar null
     * @return el paciente con el código más grande o null si la lista está vacía
     */
    fun darPacienteMayorCodigo(): Paciente? {
        var pac: Paciente? = null
        if (pacientes.isNotEmpty()){
            var mayor_codigo=0
            for (paciente in pacientes)
                if(paciente.darCodigo()>mayor_codigo){
                    mayor_codigo=paciente.darCodigo()
                    pac=paciente
                }
        }
        return pac
    }

    /**
     * Obtener el promedio del codigo de aquellos pacientes de sexo femenino
     * @return el promedio de código
     */
    fun promedioCodigoMujeres(): Double {
        var suma= 0
        val mujeres= cantMujeres()
        for (paciente in pacientes) {
            if (paciente.darSexo() == MUJER) {
                suma+=paciente.darCodigo()
            }
        }
        val promedio=(suma/mujeres).toDouble()
        return promedio
    }
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Crea una nueva central sin pacientes y con una lista predefinida de clínicas
     */
    init {
        listaClinicas.add("Clínica del Country")
        listaClinicas.add("Clínica Palermo")
        listaClinicas.add("Clínica Reina Sofía")
        listaClinicas.add("Clínica El Bosque")
        listaClinicas.add("Clínica San Ignacio")
        listaClinicas.add("Otra")
    }
}