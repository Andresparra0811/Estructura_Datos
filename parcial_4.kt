package parcial

import ean.collections.IList
import ean.collections.TList

data class Aspirante (val cedula:Int,val nombre:String, val profesion:String, val añoNacimiento:Int, val añosExperiencia:Int ){

    fun retornar_edad ():Int{
        var edad_aspirante = 2021 - añoNacimiento
        return edad_aspirante
    }


}

class BolsaDeEmpleo {
    val aspirantes: IList<Aspirante> = TList()

    fun adicionarAspirante (cedula:String,nombre:String,profesion:String,añoNacimiento: Int,añosExperiencia: Int){
        val aspirante_nuevo = Aspirante (cedula, nombre, profesion, añoNacimiento, añosExperiencia)
        aspirantes.add (aspirante_nuevo)
    }

    fun cedulasAspirantes():IList<Int>{
        val lista_cedulas: IList<Int> = TList()
        for (x in aspirantes){
            lista_cedulas.add(x.cedula)
        }
        return lista_cedulas
    }

    fun buscarAspirante(cedula:Int):Aspirante?{
        for (aspirante in aspirantes){
            if (aspirante.cedula== cedula){
                return aspirante
            }
        }
        return null
    }

    fun buscarAspiranteMasViejo (){
        var pos_aspirante: Int=0
        var mayor_edad = aspirantes[0].retornar_edad()
        for (x in 0 until aspirantes.size) {
                if (aspirantes[x].retornar_edad() >= mayor_edad) {
                    mayor_edad = aspirantes[x].retornar_edad()
                    pos_aspirante = x
                }
            }

        return pos_aspirante
    }

    fun darAspiranteMasJoven(){
        var cedula_aspirante:Int = 0
        var menor_edad = 0

        for (x in 0 until aspirantes.size){
            if (aspirantes [x].retornar_edad() < menor_edad ){
                menor_edad= aspirantes[x].retornar_edad()
                cedula_aspirante= aspirantes[x].cedula
            }
        }
        return cedula_aspirante
    }

    fun darAspiranteMayorExperiencia(profesion:String):Aspirante?{
        var aspirante_mayor: Aspirante?=null
        var mayor_experiencia=0
        for (x in aspirantes) {
                if (x.añosExperiencia > mayor_experiencia) {
                    mayor_experiencia = x.añosExperiencia
                    aspirante_mayor = x
                }
            }

        return aspirante_mayor
    }

    fun promedioAñosExperienciaPorProfesion(profesion){

    }

    fun contratarAspirante(cedula:Int) {
        var contratado: Int = 0
        for (x in 0 until aspirantes.size) {
            if (aspirantes[x].cedula == cedula) {
                contratado =x
            }
        }
        if (contratado!= null){
            aspirantes.remove(contratado)
        }
    }

    fun candidatos(profesion:String, edad:Int, añosExperiencia:Int): IList<Int> {
        val lista_cedulas: IList<Int> = TList()
        for (x in aspirantes){
            if(x.profesion==profesion){
                if(x.retornar_edad()>=edad){
                    if(x.añosExperiencia>=añosExperiencia){
                        lista_cedulas.add(x.cedula)
                    }
                }
            }
        }
        return lista_cedulas
    }

}

