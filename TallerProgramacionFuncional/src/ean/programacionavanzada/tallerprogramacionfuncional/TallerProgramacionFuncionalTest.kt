/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas
 * Faculta de Ingeniería
 *
 * Taller de Programacion Funcional
 * @author (@universidadean.edu.co)
 * Fecha: 11 de noviembre de 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package ean.programacionavanzada.tallerprogramacionfuncional

import ean.collections.*
import org.testng.Assert.*
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import kotlin.math.roundToInt

class TallerProgramacionFuncionalTest {
    private val deptos: IList<Departamento> = TList()
    private val municipios: IList<Municipio> = TList()

    @BeforeMethod
    fun setUp() {
        Utils.obtenerDepartamentos(deptos)
        Utils.obtenerMunicipios(municipios)
    }

    @Test
    fun pruebaContar() {
        assertEquals(32, contarCapitales(municipios))
    }

    @Test
    fun pruebaF(): Unit {

    }

    @Test
    fun prueba0(): Unit {
        assertEquals(20, sinPoblacionUrbana(municipios))
    }

    @Test
    fun pruebaDensidad(): Unit {

    }

    @Test
    fun pruebaForEachIndexed() {

    }

    @Test
    fun pruebaMunConJota() {
        println(munConJota(municipios))
    }

    @Test
    fun departamentoMayorSuperficie() {
        // Funcion que halla el nombre del depto con más superficie
        fun nomDepto(deptos: IList<Departamento>): String {
            return deptos.maxWith(compareBy(Departamento::superficie))!!.nombre
        }

        println(nomDepto(deptos))
    }

    @Test
    fun prueba11(): Unit {
        // Pruebas del groupBy
        val lista = TList<Int>(4, 58, 23, 7, 65, 22, 41, 78)

    }

    @Test
    fun losCincoDepartamentosConMasMunicipios() {
        // Imprima en orden descendente, los nombres de los departamentos con más municipios
    }

    @Test
    fun prueba12(): Unit {
        val l = TList<Int>(1, 345, 89, 2345, 188, 3567)
        println("Mas digitos ${numMasDigitos(l)}")
    }

    @Test
    fun prueba1() {
        // Hallar el nombre capital del departamento con nomobre dado
        fun capitalDepto(nomDepto:String): String =
            municipios.find { it.departamento == nomDepto && it.esCapital}!!.nombre

        println(capitalDepto("Vichada"))
    }

    @Test
    fun prueba02() {
        // Obtener la lista de los nombres de las capitales de los
        // departamentos que pertenecen al eje cafetero
        fun capitalesEjeCaf(mun: IList<Municipio>): IList<Pair<String, String>> {
            val capitales=mun.filter { m -> (m.departamento== "Caldas" || m.departamento == "Quindio" || m.departamento == "Risaralda") && (m.esCapital)  }
            val listaDepartamentoCapital:IList <Pair <String,String>> = TList()
            capitales.forEach {
                listaDepartamentoCapital.add(Pair(it.departamento,it.nombre))
            }
            return listaDepartamentoCapital
        }

        println(capitalesEjeCaf(municipios))
    }

    @Test
    fun pruebaN(): Unit {
        val l: IList<Nota> = TList()
        l.add(Nota(40.0, 3))
        l.add(Nota(70.0, 4))
        l.add(Nota(81.0, 3))
        l.add(Nota(72.0, 4))
        l.add(Nota(88.0, 6))

        // Hallar la definitiva más alta
        val mayorD= l.maxWith(compareBy(Nota::definitiva))
        println(mayorD!!.definitiva)
        //¿Cuántos céditos tiene la materia de la peor nota?
        val menorD= l.minWith(compareBy(Nota::definitiva))
        val creditosMenor= menorD!!.créditos
        println(creditosMenor)

        // Obtener la suma de la definitiva por los créditos de las notas
        // y luego la suma de los créditos de cada una de las notas
        val definitivaxcreditos= l.fold(0){a,e -> ((a+ (e.definitiva * e.créditos)).roundToInt())}
        val sumaCreditos= l.sumBy { it.créditos }
        println (definitivaxcreditos)
        println (sumaCreditos)
        val prom = ((l.sumBy { it.créditos }) /( l.sumByDouble { it.definitiva }))
        // El promedio se halla dividiendo la suma de las definitivas entre los créditos

        println("Promedio = $prom")

        // Pruebas con el FOLD
        val lista = TList(4, 11, 6, 5,  8, 3, 1)


        val lst = TList(40, 11, 6, 80, 5, 3, 1)

        val nums = TList(40, 12, 6, 88, 3, 5, 1)

    }




}