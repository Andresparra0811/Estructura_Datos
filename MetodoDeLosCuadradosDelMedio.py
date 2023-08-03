
def parte_media_cuadrado():
    
    semilla = int(input('Ingrese la semilla: '))

    if semilla in range (1000,9999):

        cantidadNum = int(input('Ingrese las cantidad de números: '))

        for numero in range(cantidadNum):

            semilla = semilla
            semilla_alCuadrado = pow(semilla,2)
            tamaño_semillaCuadrada = len(str(semilla_alCuadrado))

            if tamaño_semillaCuadrada == 8:
                string_Semilla = str(semilla_alCuadrado)
                medio = string_Semilla[2:6]
                num_medio = int(medio)
                r = num_medio / 10000
            else:
                if tamaño_semillaCuadrada != 8:
                    string_Semilla = str(semilla_alCuadrado)
                    medio = string_Semilla[1:5]
                    num_medio = int(medio)
                    r = num_medio / 10000
            print(f'[{numero}] La semilla  es: {semilla};     Pseudoaleatorio: {num_medio};')
            semilla = num_medio

            if num_medio == 0:
                break

    else:
        print('Debe de ingresar 4 digitos.')


parte_media_cuadrado()