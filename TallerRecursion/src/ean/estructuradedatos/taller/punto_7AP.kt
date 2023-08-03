package ean.estructuradedatos.taller

data class Nodo(val info: Int, val sig: Nodo? = null)

class CrazyIntList {

    var primero: Nodo? = null

    // Método para insertar un elemento antes del último
    // nodo de la lista
    fun insertarAntesUltimo(elem: Int) {
        require(primero!=null)
        var nodito = Nodo(elem)
        if (primero!!.sig == null){
            primero=nodito
        }
    }

}
