package ean.programacionavanzada.tallerprogramacionfuncional

import ean.collections.IList

data class Trabajo( var empresa: String, var salario:Double): Comparable<Trabajo> {
    override fun compareTo(other: Trabajo): Int {
        return compareValues(this.salario,other.salario)
    }
}

data class Persona( var cedula: Int, var nombre: String, var edad:Int, var trabajos:IList<Trabajo>): Comparable<Persona> {


    override fun compareTo(other: Persona): Int {
        return compareValues(this.cedula,other.cedula)
    }
    fun cedula():Int{
        return this.cedula
    }
    fun nombre ():String{
        return this.nombre
    }
    fun edad ():Int{
        return this.edad
    }
    fun trabajos():IList<Trabajo>{
        return this.trabajos
    }

    fun bonificacion (persona:Persona,nombreEmpresa:String ){
        val promedioSalarios:Double= ((persona.trabajos.sumByDouble { it.salario }) / persona.trabajos.size)
        val salarioEmpresaRef = (persona.trabajos.find {it.empresa == nombreEmpresa})!!.salario
        var respuesta:String= ""
        if ((promedioSalarios > 1000000) && (salarioEmpresaRef >= 2000000) && (this.edad >= 18)){
            respuesta="SI"
        }
        else{
            respuesta= "NO"
        }

    }
}