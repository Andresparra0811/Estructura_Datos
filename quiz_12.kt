package ean.programacionavanzada.pais

import ean.collections.IBinarySearchTree
import ean.collections.TAVL

class Votante: Comparable<Votante> {
    // Atributos
    var cédula: Int = 0
    var nombre: String = ""
    var votoEnBlanco: Boolean = false
    var votoCandidato: String = ""
    // Constructores:
    constructor()

    constructor(cédula: Int, nombre: String, votoEnBlanco: Boolean, votoCandidato: String) {
        this.cédula = cédula
        this.nombre = nombre
        this.votoEnBlanco = votoEnBlanco
        this.votoCandidato = votoCandidato
    }

    override fun compareTo(other: Votante): Int {
        return  compareValues(this.cédula,other.cédula)
    }


}

class Votación {
    private val votantes: IBinarySearchTree<Votante> = TAVL()

    constructor()

    fun cantidadVotantes(): Int {
        fun numVotantes(arbol: IBinarySearchTree<Votante>): Int {
            var contador:Int = 0
            if (arbol.isEmpty){
                return contador
            }
            else{
                contador= numVotantes(arbol.left) + numVotantes(arbol.right)
                if (arbol.root != null){
                    contador++
                }
                return contador
            }
        }


        // Usamos la función anterior
        return numVotantes(votantes)
    }
    fun cantidadVotantesBlanco(): Int {
        fun numVotantesBlanco(arbol: IBinarySearchTree<Votante>): Int {
            var contador:Int = 0
            if (arbol.isEmpty){
                return contador
            }
            else{
                contador= numVotantesBlanco(arbol.left) + numVotantesBlanco(arbol.right)
                if (arbol.root != null && arbol.root.votoEnBlanco){
                    contador++
                }
                return contador
            }
        }
        return numVotantesBlanco(votantes)

    }

    fun cantidadVotosCandidato (candidato:String):Int{
        fun numVotantesCandidato(arbol: IBinarySearchTree<Votante>,nomCandidato:String):Int{
            var contador:Int = 0
            if (arbol.isEmpty){
                return 0
            }
            else{
                var contador = numVotantesCandidato(arbol.left,nomCandidato) + numVotantesCandidato(arbol.right,nomCandidato)
                if (arbol.root.votoCandidato == candidato){
                    contador++

                }
                return contador
            }
        }
        return numVotantesCandidato(votantes,candidato)
    }

}

fun decidirVotacion(votacionPresidente:Votación):String{
    var respuesta:String = ""
    val candidato_1= "ZULUAGA"
    val candidato_2= "SANTOS"
    if ((votacionPresidente.cantidadVotantesBlanco()) > (votacionPresidente.cantidadVotantes().toDouble() / 2) ){

        respuesta = "ELECCION INVALIDA"
    }

    else if (votacionPresidente.cantidadVotosCandidato(candidato_1) == votacionPresidente.cantidadVotosCandidato(candidato_2) ){
        respuesta= "EMPATE"
    }

    else if (votacionPresidente.cantidadVotosCandidato(candidato_1) > votacionPresidente.cantidadVotosCandidato(candidato_2)){
        respuesta = candidato_1
    }

    else{
        respuesta = candidato_2
    }

    return respuesta
}

