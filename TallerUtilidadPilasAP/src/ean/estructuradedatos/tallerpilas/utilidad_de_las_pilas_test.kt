package ean.estructuradedatos.tallerpilas

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas
 * Faculta de Ingeniería
 * <p>
 * Proyecto Taller con las Pilas
 * Autor: Universidad EAN - Octubre 18, 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

import ean.collections.IList
import ean.collections.Utils
import ean.collections.Utils.join
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


internal class ConvertidorDeInfijoAPostfijoTest {
    //-------------------------------------
    // Métodos
    //-------------------------------------
    @Test
    fun probarBalanceador() {
        // Ejemplo de expresión bien balanceada
        assertTrue {
            chequearBalanceo("[a {b / (c-d) + e/(f+g)}-h]")
        }

        // Ejemplo de expresión mal balanceada
        assertFalse {
            chequearBalanceo("a {b [c - d ] e] ) f")
        }

        // Ejemplo de expresión mal balanceada
        assertFalse {
            chequearBalanceo("{a ( b * c ) / [d + e] / f )- g}")
        }
    }

    @Test
    fun testReplaceDelimiters() {
        val first = reemplazarDelimitadores("x [ {a ( b * c ) / [d + e] / f }- g]")
        val secnd = dividirExpresion("x ( (a ( b * c ) / (d + e) / f )- g)")
        assertTrue(first == secnd)
    }

    @Test
    fun probarConvertirInfijoPostfijo() {
        var postfijo: String

        // 1. Primera prueba
        postfijo = convertir("((40 + 30) - 25)")
        assertEquals("40 30 + 25 -", postfijo)

        // 2. Prueba
        postfijo = convertir("(a + (b * c))")
        assertEquals("a b c * +", postfijo)

        // 3. Prueba
        postfijo = convertir("((a - b) * c)")
        assertEquals("a b - c *", postfijo)

        // 4. Prueba
        postfijo = convertir("((a % b) * (c % d))")
        assertEquals("a b % c d % *", postfijo)

        // 5. Prueba
        postfijo = convertir("(a / (b * (c + (d - 5))))")
        assertEquals("a b c d 5 - + * /", postfijo)

        // 6. Prueba
        postfijo = convertir("((a / (b - c)) * d)")
        assertEquals("a b c - / d *", postfijo)

        // 7. Prueba
        postfijo = convertir("((a - ((b / ((c - d) * e)) + f )) % g)")
        assertEquals("a b c d - e * / f + - g %", postfijo)

        // 8. Prueba
        postfijo = convertir("(((a - b) * c) / (((d * e) / (f % g)) + h))")
        assertEquals("a b - c * d e * f g % / h + /", postfijo)

        // 9. Prueba
        postfijo = convertir("(a * (((b + c) * d) + e))")
        assertEquals("a b c + d * e + *", postfijo)
    }

    @Test
    fun pruebaFinal() {
        val aEvaluar = dividirExpresion("({[2 * 3] / (4 - 2)} + {5 * 6})")
        if (Evaluador.estánSímbolosAgrupaciónBalanceados(aEvaluar)) {
            Evaluador.reemplazarDelimitadoresPorParéntesis(aEvaluar)
            val expresiónFinal = Evaluador.convertirAPostfijo(aEvaluar)
            val valorFinal = Evaluador.evaluarExpresiónPostfija(expresiónFinal)
            assertEquals(33, valorFinal)
        }
        else {
            fail("Algo malo ocurrió por aquí")
        }
    }
}

//-----------------------------------------------------------------------------------------------------------

/**
 * Función de utilidad para realizar la conversión
 */
fun convertir(expresión: String): String {
    val anExpression = Utils.parse(expresión)
    return join(Evaluador.convertirAPostfijo(anExpression))
}

/**
 */
fun dividirExpresion(expresión: String): IList<String> = Utils.parse(expresión)

fun chequearBalanceo(expresión: String): Boolean {
    return Evaluador.estánSímbolosAgrupaciónBalanceados(dividirExpresion(expresión))
}

fun reemplazarDelimitadores(expresión: String): IList<String> {
    val expr = dividirExpresion(expresión)
    Evaluador.reemplazarDelimitadoresPorParéntesis(expr)
    return expr
}
