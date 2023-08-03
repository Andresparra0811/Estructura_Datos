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

import universidadean.mundial.mundo.Jugador;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * Es el diálogo para crear un nuevo jugador
 */
public class DialogoCrearJugador extends JDialog {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia a la clase principal de la interfaz
     */
    private InterfazMundial principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Es el panel con los datos para crear el nuevo jugador
     */
    private PanelCrearJugador panelDatos;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el diálogo *
     *
     * @param ventana Es una referencia a la clase principal de la interfaz
     */
    public DialogoCrearJugador(InterfazMundial ventana) {
        super(ventana, true);
        principal = ventana;

        panelDatos = new PanelCrearJugador(this);

        add(panelDatos, BorderLayout.CENTER);

        setTitle("Crear Jugador");
        pack();
        centrar();
    }

    public DialogoCrearJugador(InterfazMundial ventana, Jugador jugador) {
        super(ventana, true);
        principal = ventana;

        panelDatos = new PanelCrearJugador(this, jugador);

        add(panelDatos, BorderLayout.CENTER);

        setTitle("Modificar Jugador");
        pack();
        centrar();
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Centra el diálogo en la pantalla
     */
    private void centrar() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int xEsquina = (screen.width - getWidth()) / 2;
        int yEsquina = (screen.height - getHeight()) / 2;
        setLocation(xEsquina, yEsquina);
    }

    /**
     * Adiciona el jugador al mundial
     */
    public void crearJugador() {
        boolean parametersOk = true;
        String nombre = null;
        int edad = 0;
        String posicion = null;
        double altura = 0;
        double peso = 0;
        double salario = 0;
        String imagen = null;

        nombre = panelDatos.darNombre();

        if (nombre.equals("")) {
            parametersOk = false;
            JOptionPane.showMessageDialog(this, "Debe ingresar el nombre del jugador", "error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            try {
                edad = Integer.parseInt(panelDatos.darEdad());
                if (edad < 0) {
                    parametersOk = false;
                    JOptionPane.showMessageDialog(this, "La edad ingresada no es un valor válido", "error", JOptionPane.ERROR_MESSAGE);
                }
                else {

                    posicion = panelDatos.darPosicion();
                    if (posicion.equals("")) {
                        parametersOk = false;
                        JOptionPane.showMessageDialog(this, "La posición ingresada no es un valor válido", "error", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        try {
                            altura = Double.parseDouble(panelDatos.darAltura());
                            if (altura < 0) {
                                parametersOk = false;
                                JOptionPane.showMessageDialog(this, "La altura ingresada no es un valor válido", "error", JOptionPane.ERROR_MESSAGE);
                            }
                            else {
                                try {
                                    peso = Double.parseDouble(panelDatos.darPeso());
                                    if (peso < 0) {
                                        parametersOk = false;
                                        JOptionPane.showMessageDialog(this, "El peso ingresado no es un valor válido", "error", JOptionPane.ERROR_MESSAGE);
                                    }
                                    else {
                                        try {
                                            salario = Double.parseDouble(panelDatos.darSalario());
                                            if (salario < 0) {
                                                parametersOk = false;
                                                JOptionPane.showMessageDialog(this, "El salario ingresado no es un valor válido", "error", JOptionPane.ERROR_MESSAGE);
                                            }
                                            else {
                                                try {
                                                    imagen = panelDatos.darImagen();
                                                    if (imagen.equals("")) {
                                                        parametersOk = false;
                                                        JOptionPane.showMessageDialog(this, "La ruta de la imagen ingresada no es un valor válido", "error", JOptionPane.ERROR_MESSAGE);
                                                    }
                                                }
                                                catch (NumberFormatException e) {
                                                    parametersOk = false;
                                                    JOptionPane.showMessageDialog(this, "La ruta de la imagen ingresada no es un valor válido", "error", JOptionPane.ERROR_MESSAGE);
                                                }
                                            }
                                        }
                                        catch (NumberFormatException e) {
                                            parametersOk = false;
                                            JOptionPane.showMessageDialog(this, "El salario ingresado no es un valor válido", "error", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                }
                                catch (NumberFormatException e) {
                                    parametersOk = false;
                                    JOptionPane.showMessageDialog(this, "El peso ingresado no es un valor válido", "error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        }
                        catch (NumberFormatException e) {
                            parametersOk = false;
                            JOptionPane.showMessageDialog(this, "La altura ingresada no es un valor válido", "error", JOptionPane.ERROR_MESSAGE);
                        }
                    }

                }
            }
            catch (NumberFormatException e) {
                parametersOk = false;
                JOptionPane.showMessageDialog(this, "La edad ingresada no es un valor válido", "error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (parametersOk) {
            boolean ok = principal.crearJugador(nombre, edad, posicion, altura, peso, salario, imagen);

            if (ok) {
                dispose();
            }
        }
    }

    /**
     * Modifica la información del jugador seleccionado
     */
    public void guardarJugador() {
        boolean parametersOk = true;
        String nombre = null;
        int edad = 0;
        String posicion = null;
        double altura = 0;
        double peso = 0;
        double salario = 0;
        String imagen = null;

        nombre = panelDatos.darNombre();

        if (nombre.equals("")) {
            parametersOk = false;
            JOptionPane.showMessageDialog(this, "Debe ingresar el nombre del jugador", "error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            try {
                edad = Integer.parseInt(panelDatos.darEdad());
                if (edad < 0) {
                    parametersOk = false;
                    JOptionPane.showMessageDialog(this, "La edad ingresada no es un valor válido", "error", JOptionPane.ERROR_MESSAGE);
                }
                else {

                    posicion = panelDatos.darPosicion();
                    if (posicion.equals("")) {
                        parametersOk = false;
                        JOptionPane.showMessageDialog(this, "La posición ingresada no es un valor válido", "error", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        try {
                            altura = Double.parseDouble(panelDatos.darAltura());
                            if (altura < 0) {
                                parametersOk = false;
                                JOptionPane.showMessageDialog(this, "La altura ingresada no es un valor válido", "error", JOptionPane.ERROR_MESSAGE);
                            }
                            else {
                                try {
                                    peso = Double.parseDouble(panelDatos.darPeso());
                                    if (peso < 0) {
                                        parametersOk = false;
                                        JOptionPane.showMessageDialog(this, "El peso ingresado no es un valor válido", "error", JOptionPane.ERROR_MESSAGE);
                                    }
                                    else {
                                        try {
                                            salario = Double.parseDouble(panelDatos.darSalario());
                                            if (salario < 0) {
                                                parametersOk = false;
                                                JOptionPane.showMessageDialog(this, "El salario ingresado no es un valor válido", "error", JOptionPane.ERROR_MESSAGE);
                                            }
                                            else {
                                                try {
                                                    imagen = panelDatos.darImagen();
                                                    if (imagen.equals("")) {
                                                        parametersOk = false;
                                                        JOptionPane.showMessageDialog(this, "La ruta de la imagen ingresada no es un valor válido", "error", JOptionPane.ERROR_MESSAGE);
                                                    }
                                                }
                                                catch (NumberFormatException e) {
                                                    parametersOk = false;
                                                    JOptionPane.showMessageDialog(this, "La ruta de la imagen ingresada no es un valor válido", "error", JOptionPane.ERROR_MESSAGE);
                                                }
                                            }
                                        }
                                        catch (NumberFormatException e) {
                                            parametersOk = false;
                                            JOptionPane.showMessageDialog(this, "El salario ingresado no es un valor válido", "error", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                }
                                catch (NumberFormatException e) {
                                    parametersOk = false;
                                    JOptionPane.showMessageDialog(this, "El peso ingresado no es un valor válido", "error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        }
                        catch (NumberFormatException e) {
                            parametersOk = false;
                            JOptionPane.showMessageDialog(this, "La altura ingresada no es un valor válido", "error", JOptionPane.ERROR_MESSAGE);
                        }
                    }

                }
            }
            catch (NumberFormatException e) {
                parametersOk = false;
                JOptionPane.showMessageDialog(this, "La edad ingresada no es un valor válido", "error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (parametersOk) {
            boolean ok = principal.modificarInformacionJugador(nombre, edad, posicion, altura, peso, salario, imagen);

            if (ok) {
                dispose();
            }
        }
    }
}

