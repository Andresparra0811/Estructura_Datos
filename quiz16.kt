package ean.programacionavanzada.tallerprogramacionfuncional

import ean.collections.IList

data class NotaFinal( var definitiva: Double, var créditos: Int, var nombreEstudiante:String, var nombreMateria:String){

    fun definitiva():Double{
        return this.definitiva
    }
    fun creditos ():Int{
        return this.créditos
    }
    fun nombreEstudiante ():String{
        return this.nombreEstudiante
    }
    fun nombreMateria():String{
        return this.nombreMateria
    }

}

fun materiasPromedio80(notas: IList<NotaFinal>, nombreEst: String): IList<String> {
    val notasEstudiante = notas.filter { it.nombreEstudiante() == nombreEst }
    val notasPromedio80 = notasEstudiante.filter { it.definitiva() > 80 }
    val notasMayor4Creditos = notasPromedio80.filter { it.creditos() >= 4 }
    return notasMayor4Creditos.map { it.nombreMateria() }
}