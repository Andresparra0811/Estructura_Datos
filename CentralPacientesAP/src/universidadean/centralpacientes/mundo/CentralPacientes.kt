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

import kotlin.Throws
import java.util.ArrayList

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
    var primero: Paciente? = null

    /**
     * Número de pacientes en la central
     */
    var numPacientes = 0

    /**
     * Vector de clínicas manejadas por la central
     */
    private val listaClinicas: ArrayList<String> = ArrayList()

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Retorna el número de pacientes de la clínica
     * @return El número de pacientes de la clínica
     */
    fun darNumeroPacientes(): Int {
        var p = primero
        var numPacientes= 0
        while (p != null){
            p=p.siguiente
            numPacientes++
        }
        return numPacientes
    }

    /**
     * Adiciona un paciente al principio de la lista
     * @param pac El paciente a ser agregado al comienzo de la lista.
     * @throws YaExisteException si hay otro paciente en la lista con un codigo igual a pac.codigo
     */
    fun agregarPacienteAlComienzo(pac: Paciente) {
        var codigo:Paciente?=localizar(pac.codigo)
        if(codigo==null) {
            pac.siguiente = primero
            primero = pac
        }
        else{
            throw YaExisteException(pac.codigo)
        }
    }

    /**
     * Adiciona un paciente al final de la lista.
     * @param pac El paciente a ser agregado al final la lista.
     * @throws YaExisteException si hay otro paciente en la lista con un codigo igual a pac.codigo
     */
    fun agregarPacienteAlFinal(pac: Paciente) {
        var codigo:Paciente?=localizar(pac.codigo)
        if(codigo==null) {
            var ult = primero
            while (ult!!.siguiente != null) {
                ult = ult.siguiente
            }
            ult.siguiente = pac
        }
        else{
            throw YaExisteException(pac.codigo)
        }
    }

    /**
     * Adiciona un paciente a la lista de pacientes antes del paciente con el código especificado.
     * @param cod El código del paciente antes del que se va insertar el nuevo paciente.
     * @param pac El paciente que se va a adicionar.
     * @throws NoExisteException Si el paciente antes del que se va a realizar la adición no se encuentra registrado.
     * @throws YaExisteException si hay otro paciente en la lista con un codigo igual a pac.codigo
     */

    fun agregarPacienteAntesDe(cod: Int, pac: Paciente) {

        var posicion= encontrarPosicion(cod)
        var codigo:Paciente?=localizar(pac.codigo)
        if(codigo==null) {
            if(posicion!=-1){
                if (posicion==0){
                    agregarPacienteAlComienzo(pac)
                }
                else{
                    var p=primero
                    for (i in 0 until posicion-1 ){
                        p=p!!.siguiente
                    }
                    var r=p!!.siguiente
                    pac!!.siguiente=r
                    p!!.siguiente=pac
                    }
                }
            else{
                throw NoExisteException(cod)
                }

            }else{
                throw YaExisteException(pac.codigo)
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
        var posicion= encontrarPosicion(cod)
        var codigo_paciente:Paciente?=localizar(pac.codigo)
        if(codigo_paciente==null) {
            if(posicion!=-1){

                var p=primero

                for (i in 0 until posicion ){
                    p=p!!.siguiente
                }

                var r=p!!.siguiente
                pac!!.siguiente=r
                p!!.siguiente=pac

            }else{
                throw NoExisteException(cod)
            }

        }else{
            throw YaExisteException(pac.codigo)

        }
    }

    /**
     * Busca el paciente con el código dado en la lista de pacientes.
     * @param codigo El código del paciente que se va a buscar
     * @return El paciente con el código especificado. Si el paciente no existe se retorna null
     */
    fun localizar(codigo: Int): Paciente? {
        var ult=primero
        while(ult!=null){
            if (ult!!.codigo==codigo)
            {
                return ult
            }
            ult=ult!!.siguiente
        }
        return null
    }

    /**
     * Busca el paciente anterior al paciente con el código especificado
     * @param cod Código del paciente del que se desea el paciente anterior
     * @return El paciente anterior al paciente con el código dado.
     * Se retorna null si el paciente con el código dado no existe o si es el primero de la lista
     */
    fun localizarAnterior(codigo: Int): Paciente? {
        var paciente:Paciente?=localizar(codigo)
        var paciente_siguiente:Paciente?=null
        var paciente_anterior:Paciente?=null

        if(paciente!=null){
            var ult= primero
            while(ult!!.siguiente!=null){
                paciente_siguiente=ult!!.siguiente
                if(paciente_siguiente!!.codigo==codigo){
                    paciente_anterior=ult
                }
                ult=ult!!.siguiente
            }
        }
        return paciente_anterior
    }

    /**
     * Retorna el último paciente de la lista
     * @return El último paciente de la lista. Si la lista está vacía se retorna null
     */
    fun localizarUltimo(): Paciente? {
        var ult=primero
        while(ult!=null){
            ult=ult!!.siguiente
        }
        return ult

    }


    /**
     * Busca la posición del paciente que tiene  el código especificado
     * @param cod Código del paciente del que se desea saber la posición
     * @return La posición (entre 0 y el tamaño - 1) donde se encuentra el primer paciente con el código dado. Si no se
     *         encuentra el paciente, deberá retornarse -1.
     */
    fun encontrarPosicion(cod: Int): Int {
        var ult=primero
        var cont=0
        while(ult!=null){
            if (ult.codigo==cod)
            {
                return cont
            }
            ult=ult!!.siguiente
            cont++
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
        var ult=primero
        val posicion=encontrarPosicion(cod)
        var r:Paciente?=null
        if (posicion==0){
            primero=primero!!.siguiente
        }
        else if (posicion!=-1){
            for (i in 0 until posicion){
                if (ult!!.siguiente!!.codigo==cod) {
                    r = ult!!.siguiente!!.siguiente
                    ult!!.siguiente = r
                    }
                ult = ult.siguiente

            }

        }
        else{
            throw NoExisteException(cod)
        }
    }

    /**
     * Devuelve una lista con los pacientes de la central
     * @return Lista de Pacientes
     */
    fun darPacientes(): ArrayList<Paciente> {

        var resultado = ArrayList<Paciente>()
        var ult=primero
        while(ult!=null){
            resultado.add(ult)
            ult=ult!!.siguiente
        }
        return resultado
    }



    /**
     * Retorna la lista de clínicas manejadas por la central
     * @return La lista de clínicas manejadas por la central
     */
    fun darListaClinicas(): ArrayList<String> {
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
        var ult=primero
        while(ult!=null){
            if (ult!!.sexo== HOMBRE){
                cont= cont + 1
            }
            ult=ult!!.siguiente
        }
        return cont
    }

    /**
     * Permite obtener el número de pacientes de sexo femenino que hay en la lista de pacientes
     * @return la cantidad de mujeres
     */
    fun cantMujeres(): Int {
        var cont = 0
        var ult=primero
        while(ult!=null){
            if (ult!!.sexo== MUJER){
                cont= cont + 1
            }
            ult=ult!!.siguiente
        }
        return cont
    }

    /**
     * Permite obtener el paciente con el menor código. Si la lista esta vacía se debe retornar null
     * @return el paciente con el código más pequeño o null si la lista está vacía
     */
    fun darPacienteMenorCodigo(): Paciente? {

        var paciente: Paciente?= null
        var menor=0
        var ult=primero

        if(primero!=null){
            menor=primero!!.codigo
        }
        while(ult!=null){
            if (ult!!.codigo<menor){
                menor=ult!!.codigo
            }
            ult=ult!!.siguiente
        }
        paciente=localizar(menor)

        return paciente
    }

    /**
     * Permite obtener el paciente con el mayor código. Si la lista esta vacía se debe retornar null
     * @return el paciente con el código más grande o null si la lista está vacía
     */
    fun darPacienteMayorCodigo(): Paciente? {
        var paciente: Paciente?= null
        var mayor=0
        var ult=primero

        if(primero!=null){
            mayor=primero!!.codigo
        }
        while(ult!=null){
            if (ult!!.codigo>mayor){
                mayor=ult!!.codigo
            }
            ult=ult!!.siguiente
        }
        paciente=localizar(mayor)

        return paciente

    }

    /**
     * Obtener el promedio del codigo de aquellos pacientes de sexo femenino
     * @return el promedio de código
     */
    fun promedioCodigoMujeres(): Double {
        var num_mujeres:Int = 0
        var suma:Double= 0.0
        var ult=primero
        while(ult!=null){
            if (ult!!.sexo== MUJER){
                suma=suma + ult!!.codigo
                num_mujeres++
            }
            ult=ult!!.siguiente
        }
        val promedio:Double = (suma /num_mujeres)
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