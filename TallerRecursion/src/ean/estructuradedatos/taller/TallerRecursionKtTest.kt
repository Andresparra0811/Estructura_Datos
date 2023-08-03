package ean.estructuradedatos.taller

import ean.collections.IList
import ean.collections.TList
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class TallerRecursionKtTest {

    @Test
    fun pruebaFactorial() {
        assertEquals(120, factorial(5))
        assertEquals(3628800, factorial(10))
    }

    @Test
    fun pruebaFibonacci() {
        assertEquals(89, fibonacci(11))
        assertEquals(75_025, fibonacci(25))
    }

    @Test
    fun pruebaElevar() {
        assertEquals(1024, elevar(2, 10))
        assertEquals(1_000_000, elevar(10, 6))
    }

    // Probar el triángulo de Pascal
    @Test
    fun pruebaPascal() {
        assertEquals(3, pascal(3,2))
        assertEquals(6, pascal(4,3))
        assertEquals(120, pascal(10, 8))
        assertEquals(5005, pascal(15, 7))
    }

    @Test
    fun pruebaSumatoria() {
        assertEquals(55, sumatoria(10))
        assertEquals(5050, sumatoria(100))
        assertEquals(500500, sumatoria(1000))
    }

    @Test
    fun pruebaSumaCuadrados() {
        assertEquals(1240, sumaCuadrados(15))
        assertEquals(9455, sumaCuadrados(30))
    }

    @Test
    fun pruebaSerie() {
        assertEquals(3.4361, serie(1000), 0.0001)
        assertEquals(4.5869, serie(10_000), 0.0001)
    }

    @Test
    fun pruebaContarDigitos() {
        assertEquals(7, contarDigitos(1_215_677))
        assertEquals(1, contarDigitos(1))
        assertEquals(9, contarDigitos(865_711_981))
    }

    @Test
    fun pruebaSumarDigitos() {
        assertEquals(15, sumarDigitos(5712))
        assertEquals(10, sumarDigitos(1234))
    }

    @Test
    fun pruebaEsMultiploDeTres() {
        assertTrue(esMultiploDe3(19_533))
        assertFalse(esMultiploDe3(2_933))
    }

    @Test
    fun probarCantidadDigitosPares() {
        assertEquals(4, cantidadDigitosPares(816_425))
        assertEquals(0, cantidadDigitosPares(73_911))
        assertEquals(6, cantidadDigitosPares(4_816_420))
    }

    @Test
    fun probarEsNumeroBinario() {
        assertTrue(esNumeroBinario(11))
        assertTrue(esNumeroBinario(1000110))
        assertFalse(esNumeroBinario(410))
    }

    @Test
    fun probarPoseeDigito() {
        assertTrue(poseeDigito(67_810, 7))
        assertTrue(poseeDigito(8_576, 8))
        assertFalse(poseeDigito(98_175, 4))
    }

    @Test
    fun probarDigitoMasGrande() {
        assertEquals(9, digitoMasGrande(17_928))
        assertEquals(1, digitoMasGrande(1000))
        assertEquals(6, digitoMasGrande(26_403))
    }

    @Test
    fun probarImprimirLista() {
        imprimirLista(TList(3, 1, 8, 6, 4, 2))
    }

    @Test
    fun probarDigitos() {
        assertEquals(TList(3, 4, 2, 1, 9), digitos(34_219))
        assertEquals(TList(8), digitos(8))
        assertEquals(TList(2, 0, 0, 1, 3, 6), digitos(200_136))
    }

    @Test
    fun probarconvertirDecimalBinario() {
        assertEquals(TList(1, 1, 1, 1), convertirDecimalBinario(15))
        assertEquals(TList(1, 0, 0, 1, 1, 0, 1), convertirDecimalBinario(77))
        assertEquals(TList(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), convertirDecimalBinario(1024))
        assertEquals(TList(1, 1, 0, 1, 1, 0, 1, 0, 0, 1), convertirDecimalBinario(873))
    }

    @Test
    fun probarSumarParesLista() {
        assertEquals(30, sumarParesLista(TList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)))
        assertEquals(0, sumarParesLista(TList(11, 21, 31, 41, 51, 61, 71)))
        assertEquals(34, sumarParesLista(TList(4, 10, 12, 11, 15, 8)))
    }

    @Test
    fun probarbuscarElementoEnUnaLista() {
        assertEquals(2, buscarElementoEnUnaLista(TList(40, 12, 18, 57, 1, 198, 43, 33, 12), 18))
        assertEquals(6, buscarElementoEnUnaLista(TList(40, 12, 18, 57, 1, 198, 43, 33, 12), 43))
        assertEquals(-1, buscarElementoEnUnaLista(TList(40, 12, 18, 57, 1, 198, 43, 33, 12), 6))
    }

    @Test
    fun probarConvertirListaDigitosNumero() {
        assertEquals(45_186, convertirListaDigitosNumero(TList(4, 5, 1, 8, 6)))
        assertEquals(8, convertirListaDigitosNumero(TList(8)))
        assertEquals(371_811, convertirListaDigitosNumero(TList(3, 7, 1, 8, 1, 1)))
    }

    @Test
    fun probarExisteElemento() {
        assertTrue(existeElemento(TList<String>("hola", "casa", "tierra", "rojo", "azul"), "casa"))
        assertFalse(existeElemento(TList<String>("hola", "casa", "tierra", "rojo", "azul"), "perro"))
    }

    @Test
    fun probarInvertirLista() {
        val lst: IList<Char> = TList('p', 'a', 'r', 'c', 'o', 's')
        val inv: IList<Char> = TList('s', 'o', 'c', 'r', 'a', 'p')
        assertEquals(inv, invertirLista(lst))
    }

    @Test
    fun probarPalindrome() {
        assertTrue(esPalindrome("dabalearrozalazorraelabad"))
        assertTrue(esPalindrome("ablewasIereIsawelba"))
        assertFalse(esPalindrome("palindrome"))
    }

    @Test
    fun probarMayorDeUnaLista() {
        val lst: IList<Int> = TList(17, 8, -4, 30, 18, 180, 6, 2, 20)

        assertEquals(180, mayorDeUnaLista(lst))
    }

    @Test
    fun probarPuntosPrimerCuadrante() {
        val lp: IList<Punto> = TList(Punto(3, 4), Punto(2, -1), Punto(-5, -10), Punto(5, 6), Punto (-2, 2))
        assertEquals(2, puntosPrimerCuadrante(lp).size)
    }

    @Test
    fun probarPuntoMasLejano() {
        val lp: IList<Punto> = TList(Punto(3, 4), Punto(2, -1), Punto(-5, -10), Punto(5, 6), Punto (-2, 2))
        assertEquals(Punto(-5, -10), puntoMasLejano(lp))
        assertNull(puntoMasLejano(TList()))
    }
}