package Consumo

class Consumo {
    private var metrosDeAguaConsumido:Double= 0.0
    private var estrato:Int = 1


    constructor (metrosDeAguaConsumido:Double,estrato:Int ){
        require (estrato >= 1 && estrato <= 6)
        this.metrosDeAguaConsumido= metrosDeAguaConsumido
        this.estrato= estrato
    }
    fun calcular_pago ():Double{


        var valor_pagar:Double= 0.0

        if (this.metrosDeAguaConsumido in 1.0..20_0000.0){
            valor_pagar= 35_000.0
        }

        else if ((this.metrosDeAguaConsumido > 60000.0) && (estrato==1 || estrato==2)){
            valor_pagar = ((35_000.0) + ((this.metrosDeAguaConsumido- 20_000) * 400.0)) * 0.8
        }
        else if ((this.metrosDeAguaConsumido > 60000.0) && (estrato==3 || estrato==4)){
            valor_pagar = ((35_000.0) + ((this.metrosDeAguaConsumido- 20_000) * 400.0)) * 0.9
        }

        else if ((this.metrosDeAguaConsumido > 60000.0) && (estrato==5 || estrato==6)){
            valor_pagar = ((35_000.0) + ((this.metrosDeAguaConsumido- 20_000) * 400.0))
        }

        return valor_pagar
    }
}
