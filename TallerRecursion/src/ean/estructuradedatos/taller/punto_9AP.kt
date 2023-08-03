package ean.estructuradedatos.taller

import ean.collections.IQueue
import ean.collections.IList
import ean.collections.TList

data class ProductoInvestigativo (private val titulo:String, private val codigo:Int, private val  numPaginas:Int, private val anyoPublicacion:Int,
                                  val codigo_categoria:Categoria){

    fun getTitulo():String{
        return titulo
    }
    fun getCodigo():Int{
        return codigo
    }
    fun getNumPaginas():Int{
        return numPaginas
    }
    fun getAnyoPublicacion():Int{
        return anyoPublicacion
    }
    fun codigo_categoria():Categoria{
        return codigo_categoria
    }


}
data class Categoria (private val codigoCategoria:Int , private val nombre_categoria:String, private val  puntosProductos:Int, private val vigencia:Boolean){

    fun getCodigoCategoria():Int{
        return codigoCategoria
    }
    fun getNombre_categoria():String{
        return nombre_categoria
    }
    fun getPuntosProductos():Int{
        return puntosProductos
    }
    fun getVigencia():Boolean{
        return vigencia
    }

}
fun categoria_codigo(cola: IQueue<Categoria>, codigo: Int?): Categoria? {
    var copy: IQueue<Categoria> = cola.copy()
    var frente:Categoria? = copy.front
    var resultado:Categoria? = Categoria(0,"",0,false)
    while(!copy.isEmpty){
        if (frente?.getCodigoCategoria() == codigo){
            resultado = frente
        }
        else{
            resultado = null
        }
        copy.dequeue()

    }
    return resultado

}

fun clasificarInvestigador (listaProductos:IList<ProductoInvestigativo>, categorias: IQueue<Categoria> ):String{
    var copy: IQueue<Categoria> = categorias.copy()
    var clase:String = ""
    var puntos:Int = 0
    var i=0

    while (i<listaProductos.size){
        if (listaProductos[i].getAnyoPublicacion() > 2011){
            while (!copy.isEmpty){
                var frente:Categoria? = copy.front
                if ((listaProductos[i].getCodigo() == frente?.getCodigoCategoria()) && frente.getVigencia()){
                    puntos += frente.getPuntosProductos()
                }
            }

        }
        i++
    }

    clase = when (puntos) {
        in 0..15 -> {
            "INVESTIGADOR JUNIOR"
        }
        in 16..24 -> {
            "INVESTIGADOR ASOCIADO"
        }
        in 25..44 -> {
            "INVESTIGADOR TITULAR"
        }
        else -> {
            "INVESTIGADOR SENIOR"
        }
    }
    return clase
}

