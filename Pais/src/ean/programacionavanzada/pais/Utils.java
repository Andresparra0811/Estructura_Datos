/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Utils.java,v 1.0 2017/02/17 08:09 lacobo Exp $
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas - Facultad de Ingeniería
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Ejercicio: Pais
 * Autor: Luis Cobo - Feb 27, 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package ean.programacionavanzada.pais;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Conjunto de métodos de utilidad  para el proyecto de País
 */
public class Utils {
    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------
    final static String ARCHIVO_DEPTOS = "data/departamentos.csv";
    final static String ARCHIVO_MUNICIPIOS = "data/municipios.csv";

    //-----------------------------------------------------------------
    // Métodos generales
    //-----------------------------------------------------------------

    /**
     * Lee desde el archivo de departamentos
     * @param pais el objeto país donde guardaremos los diversos deptos
     * @return el número de datos obtenidos
     */
    public static int obtenerDepartamentos(Pais pais) {
        int n = 0;

        try {
            CSVReader reader = new CSVReader(new FileReader(ARCHIVO_DEPTOS));
            String[] linea;

            while ((linea = reader.readNext()) != null) {
                if (n > 0) {
                    String nom = linea[0];
                    double sup = Double.parseDouble(linea[3]);
                    int pobl = Integer.parseInt(linea[4]);
                    double idh = Double.parseDouble(linea[6]);
                    int añoc = Integer.parseInt(linea[7]);

                    pais.agregarDepartamento(nom, pobl, sup, idh, añoc);
                }

                n++;
            }
        }
        catch (FileNotFoundException e) {
            System.err.println("Error: archivo de datos no encontrado!");
        }
        catch (IOException e) {
            System.err.println("Error: lectura de datos incorrecta!");
        }
        return n;
    }

    /**
     * Permite leer los datos de los diversos municipios que se tienen en el archivo
     * @param pais el objeto donde almacenaremos los datos de los municipios
     * @return el número de municipios obtenidos
     */
    public static int obtenerMunicipios(Pais pais) {
        int n = 0;
        try {
            CSVReader reader = new CSVReader(new FileReader(ARCHIVO_MUNICIPIOS));
            String[] linea;

            while ((linea = reader.readNext()) != null) {
                if (n > 0) {
                    String codigo = linea[0].trim();
                    int cod = Integer.parseInt(codigo);
                    String nom = linea[1];
                    int pobUrb = Integer.parseInt(linea[2]);
                    int pobRur = Integer.parseInt(linea[3]);
                    String dep = linea[4];
                    boolean cap = Integer.parseInt(linea[5].trim()) == 1;

                    pais.agregarMunicipio(cod, nom, dep, pobUrb, pobRur, cap);
                }
                n++;
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return n;
    }

}
