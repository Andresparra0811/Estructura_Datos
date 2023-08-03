/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas
 * Faculta de Ingeniería
 *
 * Taller Objetos Comparadores
 * Autor: EAN - Octubre 12, 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package ean.estructuradedatos.taller

import ean.collections.IList
import ean.collections.TList
import org.junit.jupiter.api.Assertions.assertNotSame
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

// Pruebas de comparadores
class PruebasComparadores {
    // Atributos de pruebas
    private val prod1: Producto = Producto("papa", 450.0, 5)
    private val prod2: Producto = Producto("arroz", 1300.0, 100)
    private val prod3: Producto = Producto("jamón", 7100.0, 20)

    private var listaProductos: IList<Producto> = TList()

    @Test
    fun pruebasCompararSuperHéroes() {
        val superman = SuperHéroe("Superman", 100, "Tierra 1")
        val batman1 = SuperHéroe("Batman", 43, "Tierra 1")
        val batman2 = SuperHéroe("Batman", 38, "Tierra 2")
        val arrow = SuperHéroe("Green Arrow", 21, "Tierra 1")
        val mujerMaravilla = SuperHéroe("Mujer Maravilla", 81, "Tierra 1")
        val vegeta = SuperHéroe("Vegeta", 21, "Capsule")

        // Pruebas
        assertTrue(superman > batman1)
        assertTrue(batman1 != batman2)
        assertTrue(arrow < mujerMaravilla)
        assertTrue(mujerMaravilla < vegeta )
        assertTrue(vegeta > superman)
    }

    // ------------------------------------------------------------------------------------

    // Pruebas de las clases Productos
    @Test
    fun prueba1() {
        assertTrue(prod1 < prod2)
        assertTrue(prod3 > prod3)
    }

    @Test
    fun prueba2() {
        val cmp = ComparadorDeProductosPorNombre()
        assertTrue(cmp.compare(prod1, prod2) > 0)
    }

    @Test
    fun prueba3() {
        assertTrue(ComparadorPorNombreYPrecio.compare(prod2, prod3) < 0 )
    }
    @Test
    fun prueba4 (){
        assertTrue(comparadorPorCantidad.compare(prod2, prod3) > 0 )

    }
    @Test
    fun pruebaReloj1() {
        val r1 = Reloj()
        val r2 = Reloj(14, 21, 9)

        println(r1.toAMPMString())

        assertEquals("14:21:09", r2.toString())
        assertEquals("02:21:09 PM", r2.toAMPMString())
    }

    @Test
    fun pruebaReloj2() {
        val r1 = Reloj()
        val r2 = Reloj(14, 21, 9)
        val r3 = Reloj(14, 21, 59)
        val r4 = Reloj(14, 21, 59)
        val mn = Reloj(23, 59, 59)
        val cero = Reloj(0, 0, 0)

        assertTrue(r1 < mn)
        assertTrue(r3 == r4)
        assertFalse(r3 === r4)

        assertTrue(r3 > r2)

        r4.avanzarUnSegundo()
        assertTrue(r4 == Reloj(14, 22, 0))

        assertTrue(mn > cero)
        mn.avanzarUnSegundo()
        assertTrue(mn == cero)
        cero.retrocederUnSegundo()
        assertTrue(mn < cero)


    }
}
