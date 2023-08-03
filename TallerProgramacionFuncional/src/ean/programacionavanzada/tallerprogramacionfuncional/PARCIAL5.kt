package ean.programacionavanzada.tallerprogramacionfuncional

import ean.collections.IList

data class Horno( val código:Int,val ancho:Double,val largo:Double, val temperaturaMax:Double,val estado:Boolean){

}

data class Plato (val nombre:String, val tipo:String, val anchoPlato:Double ,val largoPlato:Double,val temperaturaCocción:Double) {

}

data class Cocina (val piso:Int, val nombreChef:String,val hornos:IList<Horno>){
    fun hornoPlato(plato:Plato):Horno?{
        require(plato.tipo=="REPOSTERIA" || plato.tipo=="ESPECIAL")

        if (plato.tipo== "REPOSTERIA"){
            return hornos.find { it.estado && plato.temperaturaCocción <= it.temperaturaMax && it.ancho >= plato.anchoPlato && it.largo>= plato.largoPlato }
        }
        else{
            return hornos.find { it.estado && plato.temperaturaCocción <= it.temperaturaMax && it.ancho >= plato.anchoPlato  }
        }
    }

}