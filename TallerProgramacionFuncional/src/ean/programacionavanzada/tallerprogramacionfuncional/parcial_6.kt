package ean.programacionavanzada.tallerprogramacionfuncional

import ean.collections.IDictionary
import ean.collections.IList

data class Vivienda( var habitantes: Int, var estrato: Int, var tipo:String, var pisos:Int){

}

fun impuestoPredial(vivienda:Vivienda):Int{
    require(vivienda.estrato in 1..6)
    require(vivienda.tipo == "casa" || vivienda.tipo == "apartamento"  )
    var impuesto= 0

    if ((vivienda.estrato == 1 || vivienda.estrato==2 || vivienda.estrato== 3) && vivienda.pisos==1 ){
        impuesto = 5000 * vivienda.habitantes
    }
    else if ((vivienda.estrato == 1 || vivienda.estrato==2 || vivienda.estrato== 3) && vivienda.pisos >= 2 ){
        impuesto = 2000 * vivienda.habitantes
    }
    else if ((vivienda.estrato == 4 || vivienda.estrato==5 || vivienda.estrato== 6) && vivienda.tipo== "apartamento"){
        impuesto = 1_000_000
    }
    else{
        impuesto = 500_000 * vivienda.pisos
    }
    return impuesto
}

fun mayorImpuesto(viviendas: IDictionary<String, Vivienda>):String{
    var direccionMayorImpuesto:String= ""
    var impuestoMayor:Int=0

    for (vivienda in viviendas.keys){
        if (impuestoPredial(viviendas[vivienda]!!) > impuestoMayor){
            impuestoMayor= impuestoPredial(viviendas[vivienda]!!)
            direccionMayorImpuesto=vivienda
        }
    }
    return direccionMayorImpuesto

}

fun estaVacia (viviendas: IDictionary<String, Vivienda>, direccion:String):Boolean?{
    val vivienda= viviendas[direccion]
    if (vivienda!= null){
        return vivienda.habitantes== 0
    }
    else{
        return null
    }
}


fun promedioVivienda (viviendas: IDictionary<String, Vivienda>,direcciones: IList<String>):Double{
    val direccionesDiccionario = direcciones.filter { viviendas[it] != null}
    val direccionesCondiciones= direccionesDiccionario.filter { viviendas[it]!!.habitantes > 0 &&  viviendas[it]!!.tipo == "casa" && viviendas[it]!!.pisos >= 2 }
    val numViviendas= direccionesCondiciones.count()
    val sumaHabitantes= direccionesCondiciones.sumBy {viviendas[it]!!.habitantes }
    val promedio =sumaHabitantes.toDouble() / numViviendas.toDouble()

    return promedio
}