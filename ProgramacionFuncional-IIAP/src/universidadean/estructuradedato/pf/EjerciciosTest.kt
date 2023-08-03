package universidadean.estructuradedato.pf

import ean.collections.IList
import ean.collections.TList
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class EjerciciosTest {

    // Aqui guardaremos las personas
    private lateinit var personas: IList<Persona>

    @BeforeEach
    fun leerPersonas() {
        personas = Utils.leerPersonas()!!
    }

    // ------------------------------------------------------------

    @Test
    fun pruebaEjercicio1() {
        assertEquals(38.4961, ejercicio1(personas), 1e-4)
        println("Prueba superada!")
    }

    @Test
    fun pruebaEjercicio2() {
        assertEquals(1085422030, ejercicio2(personas))
        println("Prueba superada!")
    }

    @Test
    fun pruebaEjercicio3() {
        assertTrue(ejercicio3(personas))
        println("Prueba superada!")
    }

    @Test
    fun pruebaEjercicio4() {
        assertEquals(3, ejercicio4(personas))
        println("Prueba superada!!")
    }

    @Test
    fun pruebaEjercicio5() {
        assertEquals(3_614_302.521, ejercicio5(personas, "PRIMARIA"), 1e-3)
        assertEquals(3_771_121.7391, ejercicio5(personas, "UNIVERSIDAD"), 1e-4)
        assertEquals(3_496_475.862, ejercicio5(personas, "POSTGRADO"), 1e-3)
        println("Prueba superada!!")
    }

    @Test
    fun pruebaEjercicio6() {
        assertFalse(ejercicio6(personas))
        println("Prueba superada!!!")
    }

    @Test
    fun pruebaEjercicio7() {
        assertEquals("SECUNDARIA", ejercicio7(personas))
        println("Prueba superada!!")
    }

    @Test
    fun pruebaEjercicio8() {
        val res = TList<Int>(1012170500, 1015693396, 1025592419, 1047920257, 1097110336, 1100188835, 1131238857, 1281424353, 1339418456, 1370607441, 1400093117, 1450159418, 1493867304, 1497900501, 1536842169, 1635538498, 1649939561, 1684818576, 1703081750, 1762317465, 1833677051, 1930975107, 1956010272)
        assertEquals(res, ejercicio8(personas))
        println("Prueba superada!")
    }

    @Test
    fun pruebaEjercicio9() {
        val res = TList<Int>(1007931930, 1026554047, 1032525018, 1062969596, 1071928811, 1075921947, 1092114296, 1097110336, 1111797432, 1128924698, 1172010744, 1213996167, 1218298819, 1220113474, 1220759917, 1227941731, 1238962439, 1271428328, 1274693581, 1281424353, 1319039721, 1332383027, 1333111713, 1360423091, 1370607441, 1371229610, 1372798046, 1393730828, 1402431388, 1417207541, 1456567935, 1477645257, 1487762791, 1493597025, 1511863977, 1517419801, 1522959312, 1525336848, 1536842169, 1545653962, 1574512933, 1579452242, 1598111524, 1605147766, 1631935342, 1638841487, 1649939561, 1665017495, 1684818576, 1709335265, 1711493602, 1712875980, 1713747437, 1715108674, 1734680626, 1741813800, 1759709196, 1799713211, 1803118544, 1813722586, 1826271515, 1832226198, 1833824926, 1841329288, 1850200789, 1858723629, 1876685225, 1881862390, 1895741361, 1902295751, 1904504766, 1911147968, 1912665644, 1914652979, 1936081354, 1941791397, 1972303058, 1988507026)
        assertEquals(res, ejercicio9(personas))
        println("Prueba superada!")
    }

}