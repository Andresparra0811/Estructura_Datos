/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnologías de la Información
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Unidad de Estudios de Estructura de Datos
 * Ejercicio: Triangulo
 * Basado en el ejercicio de Cupi2
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package triangulo.mundo
import kotlin.math.sqrt
import kotlin.math.pow

/**
 * Clase que representa un triángulo.
 */
class Triangulo {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Primer punto del triángulo.
     */
    private val punto1: Punto = Punto(200.0, 50.0)

    /**
     * Segundo punto del triángulo.
     */
    private val punto2: Punto = Punto(300.0, 200.0)

    /**
     * Tercer punto del triángulo.
     */
    private val punto3: Punto = Punto(100.0, 200.0)

    /**
     * Color de las líneas.
     */
    private val colorLineas: Color = Color(60, 168, 56)

    /**
     * Color del relleno.
     */
    private val colorRelleno: Color = Color(0, 83, 24)

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el punto 1 del triángulo.
     * @return Punto 1.
     */
    fun darPunto1(): Punto {
        return this.punto1
    }

    /**
     * Retorna el punto 2 del triángulo.
     * @return Punto 2.
     */
    fun darPunto2(): Punto {

        return this.punto2
    }

    /**
     * Retorna el punto 3 del triángulo.
     * @return Punto 3.
     */
    fun darPunto3(): Punto {
        return this.punto3
    }

    /**
     * Retorna el color de las líneas del triángulo.
     * @return Color de las líneas.
     */
    fun darColorLineas(): Color {
        return this.colorLineas
    }

    /**
     * Retorna el color del relleno del triángulo.
     * @return Color del relleno.
     */
    fun darColorRelleno(): Color {
        return this.colorRelleno
    }

    /**
     * Retorna el perímetro del triángulo.
     * @return Perímetro del triángulo.
     */
    fun darPerimetro(): Double {
        // Retorna la suma de todos los lados
        val lado_1= calcularLado1()
        val lado_2= calcularLado2()
        val lado_3= calcularLado3()
        val perimetro= lado_1 + lado_2 + lado_3
        return perimetro
    }

    /**
     * Retorna el área del triángulo, calculada utilizando la formula de Herón. <br></br>
     * @return Área del triángulo.
     */
    fun darArea(): Double {
        // TODO
        // Calcula y devuelve el área
        val perimetro= darPerimetro()
        val semiperimetro= perimetro / 2.0
        val lado_1= calcularLado1()
        val lado_2= calcularLado2()
        val lado_3= calcularLado3()

        val area = sqrt(semiperimetro * (semiperimetro * lado_3)  * (semiperimetro * lado_2) * (semiperimetro * lado_1) )

        return area
    }

    /**
     * Calcula la altura del triángulo, teniendo en cuenta como base la línea entre el punto 1 y 2. <br></br>
     * Tenga en cuenta que Área = (Base * Altura) / 2.
     * @return Altura del triángulo.
     */
    fun darAltura(): Double {
        val area = darArea()
        val lado_1= calcularLado1()
        val altura = (2 * area) / lado_1
        return altura
    }

    /**
     * Calcula la distancia entre el punto 1 y 2.
     * @return Distancia entre el punto 1 y el punto 2.
     */
    private fun calcularLado1(): Double {
        // calcula la distancia
        val lado_1= sqrt((punto2.darX()- punto1.darX()).pow(2)+(punto2.darY()- punto1.darY()).pow(2))
        return lado_1
    }

    /**
     * Calcula la distancia entre el punto 2 y 3.
     * @return Distancia entre el punto 2 y 3.
     */
    private fun calcularLado2(): Double {
        // calcula la distancia
        val lado_2= sqrt((punto3.darX()- punto2.darX()).pow(2)+(punto3.darY()- punto2.darY()).pow(2))
        return lado_2
    }

    /**
     * Calcula la distancia entre el punto 3 y 1.
     * @return Distancia entre el punto 3 y 1.
     */
    private fun calcularLado3(): Double {
        // calcula la distancia
        val lado_3= sqrt((punto1.darX()- punto3.darX()).pow(2)+(punto1.darY()- punto3.darY()).pow(2))
        return lado_3
    }

    /**
     * Calcula el ángulo opuesto entre un vértice de referencia y los otros dos vértices de un triángulo.
     * @param pX1 Coordenada X del vértice de referencia.
     * @param pY1 Coordenada Y del vértice de referencia.
     * @param pX2 Coordenada X del vértice opuesto 1.
     * @param pY2 Coordenada Y del vértice opuesto 1.
     * @param pX3 Coordenada X del vértice opuesto 2.
     * @param pY3 Coordenada Y del vértice opuesto 2.
     * @return Ángulo opuesto entre vértice de referencia y los otros dos vértices.
     */
    fun calcularAnguloOpuesto(pX1: Double, pY1: Double, pX2: Double, pY2: Double, pX3: Double, pY3: Double): Double {
        // Ángulo 1
        var angulo1 = Math.atan2(pY2 - pY1, pX2 - pX1)

        // Ángulo 2
        var angulo2 = Math.atan2(pY3 - pY1, pX3 - pX1)

        // Garantiza que la diferencias de ángulos sea la más pequeña.
        if (Math.abs(angulo1 - angulo2) > Math.PI) {
            angulo1 = if (angulo1 < 0) angulo1 + 2.0 * Math.PI else angulo1
            angulo2 = if (angulo2 < 0) angulo2 + 2.0 * Math.PI else angulo2
        }

        // Calcula el ángulo opuesto
        var anguloOpuesto = (angulo1 + angulo2) / 2.0 + Math.PI
        anguloOpuesto = anguloOpuesto % (2.0 * Math.PI)
        return anguloOpuesto
    }

    /**
     * Cambia el valor de la coordenada X y Y del punto 1.
     * @param pX Nuevo valor de la coordenada X. pX > 0.
     * @param pY Nuevo valor de la coordenada Y. pY > 0.
     */
    fun cambiarPunto1(pX: Double, pY: Double) {

        this.punto1.cambiarX(pX)
        this.punto1.cambiarY(pY)
    }

    /**
     * Cambia el valor de la coordenada X y Y del punto 2.
     * @param pX Nuevo valor de la coordenada X. pX > 0.
     * @param pY Nuevo valor de la coordenada Y. pY > 0.
     */
    fun cambiarPunto2(pX: Double, pY: Double) {

        this.punto2.cambiarX(pX)
        this.punto2.cambiarY(pY)
    }

    /**
     * Cambia el valor de la coordenada X y Y del punto 3.
     * @param pX Nuevo valor de la coordenada X. pX > 0.
     * @param pY Nuevo valor de la coordenada Y. pY > 0.
     */
    fun cambiarPunto3(pX: Double, pY: Double) {

        this.punto3.cambiarX(pX)
        this.punto3.cambiarY(pY)
    }

    /**
     * Cambia el color de relleno del triángulo.
     * @param pRojo Valor de componente rojo del RGB. pRojo >= 0.
     * @param pVerde Valor de componente verde del RGB. pVerde >= 0.
     * @param pAzul Valor de componente azul del RGB. pAzul >= 0.
     */
    fun cambiarColorRelleno(pRojo: Int, pVerde: Int, pAzul: Int) {

        colorRelleno.cambiarRojo(pRojo)
        colorRelleno.cambiarVerde(pVerde)
        colorRelleno.cambiarAzul(pAzul)
    }

    /**
     * Cambia el color de la líneas del triángulo.
     * @param pRojo Valor de componente rojo del RGB. pRojo >= 0.
     * @param pVerde Valor de componente verde del RGB. pVerde >= 0.
     * @param pAzul Valor de componente azul del RGB. pAzul >= 0.
     */
    fun cambiarColorLineas(pRojo: Int, pVerde: Int, pAzul: Int) {

        colorLineas.cambiarRojo(pRojo)
        colorLineas.cambiarVerde(pVerde)
        colorLineas.cambiarAzul(pAzul)
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------
    /**
     * Permite obtener el tipo del triángulo
     * "equilátero" si los tres lados son iguales
     * "isosceles" si dos lados son iguales
     * "escaleno" si los tres lados son diferentes
     */
    fun metodo1(): String {
        var tipo_triangulo=""
        val lado_1= calcularLado1()
        val lado_2= calcularLado2()
        val lado_3= calcularLado3()


        if (lado_1 ==lado_2 && lado_1==lado_3 && lado_3==lado_2){
            tipo_triangulo="Equilatero"
        }
        else if((lado_1!=lado_2 && lado_1!=lado_3 && lado_3!=lado_2)){
            tipo_triangulo="Escaleno"
        }
        else {
            tipo_triangulo = "Isoceles"
        }
        return tipo_triangulo

    }

    /**
     * Permite saber si el triángulo es rectángulo o no
     * @return "Es triangulo rectángulo" si es un triángulo rectángulo
     *         "No es triángulo rectángulo"  si no es un triángulo rectángulo
     */
    fun metodo2(): String {
        val lado_1=calcularLado1()
        val lado_2=calcularLado2()
        val lado_3=calcularLado3()
        var hipotenusa=0.0
        var cateto_1=0.0
        var cateto_2=0.0
        var resultado=""

        if (lado_1>lado_2 && lado_1> lado_3)
        {
            hipotenusa=lado_1
            cateto_1=lado_3
            cateto_2=lado_2
        }
        else if (lado_2>lado_1 && lado_2> lado_3)
        {
            hipotenusa=lado_2
            cateto_1=lado_3
            cateto_2=lado_1
        }
        else{
            hipotenusa=lado_3
            cateto_1=lado_1
            cateto_2=lado_2
        }
        val pitagoras= sqrt (cateto_1.pow(2)+ cateto_2.pow (2))

        if (pitagoras==hipotenusa){
            resultado="Es un triángulo rectángulo"
        }
        else{
            resultado="No es un triángulo rectángulo"
        }

        return resultado
    }

    
    }


