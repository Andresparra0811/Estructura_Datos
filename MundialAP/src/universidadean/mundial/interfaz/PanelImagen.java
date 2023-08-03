/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: DialogoCrearEquipo.java, v 1.5 $
 * Universidad Ean (Bogotá - Colombia)
 * Programa de Ingeniería de Sistemas
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Basado en el proyecto Cupi2 de Uniandes
 * Ejercicio: Mundial
 * Fecha: 04-noviembre-2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package universidadean.mundial.interfaz;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * Es el panel donde se muestra una imagen decorativa
 */
public class PanelImagen extends JPanel {

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Imagen del titulo
     */
    private JLabel imagen;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel
     */
    public PanelImagen() {
        FlowLayout layout = new FlowLayout();
        layout.setHgap(0);
        layout.setVgap(0);
        setLayout(layout);
        //
        // Carga la imagen
        ImageIcon icono = new ImageIcon("data/titulo.png");

        // La agrega a la etiqueta
        imagen = new JLabel("");
        imagen.setIcon(icono);
        add(imagen);
        //
        // Color de fondo blanco
        setBackground(Color.WHITE);
        setBorder(new LineBorder(Color.GRAY));
    }
}
