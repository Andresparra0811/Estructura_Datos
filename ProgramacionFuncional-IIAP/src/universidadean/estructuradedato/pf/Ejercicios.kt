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

import ean.collections.IList
import ean.collections.sort
import kotlin.math.pow

/**
 * Hallar el promedio de edad de las mujeres que no funan y tienen
 * ingresos superiores al millón y medio de pesos.
 */
fun ejercicio1(personas: IList<Persona>): Double {
    val personasCriterio= personas.filter { it.genero== 'F' && !it.fuma && it.ingresos > 1500000 }
    return (personasCriterio.sumBy { it.edad }.toDouble() / personasCriterio.count().toDouble() )

}

/**
 * Obtener la cédula de la persona con la mayor altura
 */
fun ejercicio2(personas: IList<Persona>): Int {
    val persona=personas.maxWith(compareBy(Persona :: altura))
    return persona!!.cedula
}

/**
 * Determinar si el promedio de los ingresos de las mujeres es mayor
 * al promedio de los ingresos de los hombres
 */
fun ejercicio3(personas: IList<Persona>): Boolean {
    val promedioIngresoMujeres= (personas.filter { it.genero =='F' }.sumBy { it.ingresos }.toDouble()) / (personas.filter { it.genero =='F' }.count().toDouble())
    val promedioIngresoHombres= (personas.filter { it.genero =='M' }.sumBy { it.ingresos }.toDouble()) / (personas.filter { it.genero =='M' }.count().toDouble())

    return promedioIngresoMujeres  > promedioIngresoHombres
}

/**
 * En la lista hay personas pertenecientes a 3 estratos diferentes: el 2, el 3 y el 4.
 * Determinar cuál de los 3 estratos tiene mayor cantidad de mujeres
 */
fun ejercicio4(personas: IList<Persona>): Int {
    val personasEstrato2= personas.filter { it.estrato==2 }.count()
    val personasEstrato3= personas.filter { it.estrato==3 }.count()
    val personasEstrato4= personas.filter { it.estrato==4 }.count()

    if (personasEstrato2 > personasEstrato3 && personasEstrato2 > personasEstrato4){
        return 2
    }
    else if (personasEstrato3 > personasEstrato2 && personasEstrato3 > personasEstrato4){
        return 3
    }
    else{
        return 4
    }
}

/**
 * Escriba una función que reciba la lista de personas y un nivel
 * educativo y que retorne el promedio de ingresos de las personas
 * que tienen ese nivel educativo
 */
fun ejercicio5(personas: IList<Persona>, nivelEducativo: String): Double {
    return (personas.filter { it.nivelEducativo ==nivelEducativo }.sumBy { it.ingresos }.toDouble()) / (personas.filter { it.nivelEducativo==
    nivelEducativo}.count().toDouble())
}

/**
 * Escriba una función que retorne true si todas las mujeres que usan
 * lentes y no tienen hijos tienen ingresos por encima de los dos millones
 * de pesos; debe retornar false en caso contrario
 */
fun ejercicio6(personas: IList<Persona>): Boolean {
    return personas.filter { it.usaLentes && it.hijos == 0}.all { it.ingresos > 2_000_000}
}

/**
 * Hay cuatro niveles educativos en las personas: PRIMARIA, SECUNDARIA, UNIVERSIDAD
 * y POSTGRADO. Determine cuál de los 4 niveles educativos tiene el mayor promedio
 * de edad
 */
fun ejercicio7(personas: IList<Persona>): String {
    val promedioEdadPrimaria= personas.filter { it.nivelEducativo =="PRIMARIA" }.sumBy { it.edad }.toDouble() /
            personas.filter{ it.nivelEducativo=="PRIMARIA"}.count().toDouble()
    val promedioEdadSecundaria= personas.filter { it.nivelEducativo =="SECUNDARIA" }.sumBy { it.edad }.toDouble() /
            personas.filter{ it.nivelEducativo=="SECUNDARIA"}.count().toDouble()
    val promedioEdadUniversidad= personas.filter { it.nivelEducativo =="UNIVERSIDAD" }.sumBy { it.edad }.toDouble() /
            personas.filter{ it.nivelEducativo=="UNIVERSIDAD"}.count().toDouble()
    val promedioEdadPostgrado= personas.filter { it.nivelEducativo =="POSTGRADO" }.sumBy { it.edad }.toDouble() /
            personas.filter{ it.nivelEducativo=="POSTGRADO"}.count().toDouble()

    if (promedioEdadPrimaria > promedioEdadSecundaria && promedioEdadPrimaria > promedioEdadUniversidad && promedioEdadPrimaria > promedioEdadPostgrado){
        return "PRIMARIA"
    }
    else if (promedioEdadSecundaria > promedioEdadPrimaria && promedioEdadSecundaria> promedioEdadUniversidad && promedioEdadSecundaria > promedioEdadPostgrado){
        return "SECUNDARIA"
    }
    else if (promedioEdadUniversidad > promedioEdadPrimaria && promedioEdadUniversidad> promedioEdadSecundaria && promedioEdadUniversidad > promedioEdadPostgrado){
        return "UNIVERSIDAD"
    }
    else{
        return "POSTGRADO"
    }
}

/**
 * Obtener las cédulas de las personas que no tienen casa ni automóvil ni usan lentes
 * y su altura es inferior al promedio de altura de todas las personas. La lista debe
 * estar ordenada de menor a mayor.
 */
fun ejercicio8(personas: IList<Persona>): IList<Int> {
    val promedioAltura= personas.sumBy { it.altura }.toDouble() / personas.count().toDouble()
    val personasCondicion = personas.filter { !it.tieneCasa && !it.usaLentes && !it.tieneAutomovil && it.altura < promedioAltura }.map { it.cedula }
    val n = personasCondicion.size
    return personasCondicion.sort()
}

/**
 * Para los hombres, el índice de masa corporal o IMC se calcula dividiendo el peso entre el cuadrado de
 * la altura (en metros). Cuando este IMC es igual a 30 o superior, se dice que el hombre está obeso.
 * Retorne la lista de las cédulas (ordenada de menor a mayor) de los hombres obesos de la lista.
 * OJO: la altura de las personas en la lista está en centímetros, así que haga la conversión
 * a metros antes de elevar al cuadrado.
 */
fun ejercicio9(personas: IList<Persona>): IList<Int> {
    val listaObesos= personas.filter {(it.peso / (it.altura.toDouble() /100 ).pow(2) >= 30.0) && it.genero== 'M'}.map { it.cedula }
    return listaObesos.sort()
}