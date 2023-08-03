/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: DialogoCrearEquipo.java, v 1.5 $
 * Universidad Ean (Bogotá - Colombia)
 * Programa de Ingeniería de Sistemas
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Basado en el proyecto Cupi2 de Uniandes
 * Ejercicio: Mundial
 * Fecha: 04-noviembre-2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package universidadean.mundial.interfaz;

import ean.collections.IList;
import universidadean.mundial.mundo.ElementoExisteException;
import universidadean.mundial.mundo.Equipo;
import universidadean.mundial.mundo.Jugador;
import universidadean.mundial.mundo.Mundial;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Esta es la ventana principal de la aplicación.
 */
public class InterfazMundial extends JFrame {
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * La ruta donde deben guardarse los reportes
     */
    private static final String RUTA_REPORTES = "./data/reportes";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo
     */
    private Mundial mundial;

    /**
     * Es una referencia al equipo del cual se están mostrando los datos
     */
    private Equipo equipoSeleccionado;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con los equipos
     */
    private PanelEquipos panelEquipos;

    /**
     * Panel con los jugadores
     */
    private PanelJugadores panelJugadores;

    /**
     * Panel con los botones
     */
    private PanelBotones panelBotones;

    /**
     * Panel con una imagen decorativa
     */
    private PanelImagen panelImagen;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye la interfaz de la aplicación
     *
     * @param m Es el mundial de fútbol que se va a mostrar - m!=null
     */
    public InterfazMundial(Mundial m) {

        // Crea la clase principal
        mundial = m;

        // Construye la forma
        setTitle("Mundial de fútbol CUPI2");
        setLayout(new GridBagLayout());
        setSize(560, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        // Creación de los paneles aquí
        panelImagen = new PanelImagen();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        add(panelImagen, gbc);

        panelEquipos = new PanelEquipos(this, mundial.darNombresEquipos());
        gbc.gridy = 1;
        add(panelEquipos, gbc);

        panelJugadores = new PanelJugadores(this);
        gbc.gridy = 2;
        add(panelJugadores, gbc);

        IList<String> equipos = mundial.darNombresEquipos();
        if (equipos.size() > 0) {
            cambiarEquipoSeleccionado(equipos.get(0));
        }

        panelBotones = new PanelBotones(this);
        gbc.gridy = 3;
        add(panelBotones, gbc);
        centrar();
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Centra la ventana en la pantalla
     */
    private void centrar() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int xEsquina = (screen.width - getWidth()) / 2;
        int yEsquina = (screen.height - getHeight()) / 2;
        setLocation(xEsquina, yEsquina);
    }

    /**
     * Cambia el equipo seleccionado en el panel de detalles del equipo
     *
     * @param nombreEquipo El nombre del equipo a mostrar los detalles - nombreEquipo!=null
     */
    public void cambiarEquipoSeleccionado(String nombreEquipo) {
        equipoSeleccionado = mundial.darEquipo(nombreEquipo);
        panelEquipos.cambiarEquipo(equipoSeleccionado);
        panelJugadores.cambiarJugadores(equipoSeleccionado);
    }

    /**
     * Cambia el jugador seleccionado en el panel de detalles del equipoSeleccionado
     *
     * @param nombreJugador El nombre del jugador - nombreJugador!=null
     */
    public void cambiarJugadorSeleccionado(String nombreJugador) {
        Jugador jugador = equipoSeleccionado.darJugador(nombreJugador);

        if (jugador != null) {
            panelJugadores.cambiarJugador(jugador);
        }

    }

    /**
     * Muestra el diálogo para agregar un nuevo equipoSeleccionado al mundial
     */
    public void mostrarDialogoAgregarEquipo() {
        DialogoCrearEquipo dialogo = new DialogoCrearEquipo(this);
        dialogo.setVisible(true);
    }

    /**
     * Muestra el diálogo para agregar un nuevo jugador al equipoSeleccionado en el panel de jugadores
     */
    public void mostrarDialogoAgregarJugador() {
        DialogoCrearJugador dialogo = new DialogoCrearJugador(this);
        dialogo.setVisible(true);

    }

    /**
     * Muestra el diálogo para modificar un jugador al equipoSeleccionado en el panel de jugadores
     */
    public void mostrarDialogoModificarJugador() {
        if (equipoSeleccionado != null) {
            String nombreJugador = panelJugadores.darJugadorSeleccionado();
            if (nombreJugador != null) {
                Jugador jugador = equipoSeleccionado.darJugador(nombreJugador);
                DialogoCrearJugador dialogo = new DialogoCrearJugador(this, jugador);
                dialogo.setVisible(true);
            }
            else {
                JOptionPane.showMessageDialog(null, "No hay jugador seleccionado. No se puede modificar nada!");
            }
        }
    }

    /**
     * Crea un nuevo equipo en el mundial y actualiza el panel con la lista de equipos <br>
     * <b>pre: <b>No debe haber otro equipo representando al mismo país en el mundial
     *
     * @param pais     Es el país del equipoSeleccionado - pais != null
     * @param director Es el nombre del director técnico del equipoSeleccionado - director != null
     * @param imagen   Es la ruta de la imagen con la bandera del equipoSeleccionado - imagen != null
     * @return Retorna true si el equipo se pudo agregar. Esto sirve para saber si se debe cerrar el diálogo.
     */
    public boolean crearEquipo(String pais, String director, String imagen) {
        boolean ok = false;
        try {
            mundial.agregarEquipo(pais, director, imagen);
            panelEquipos.refrescarEquipos(mundial.darNombresEquipos());
            ok = true;
        }
        catch (ElementoExisteException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        return ok;
    }

    /**
     * Crea un nuevo jugador en el equipo que se muestra en los detalles de equipo del mundial <br>
     * <b>pre: <b>No debe haber otro jugador con el mismo nombre en el equipo
     *
     * @param nombre   El nombre del jugador - nombre != null
     * @param edad     La edad del jugador - edad > 0
     * @param posicion La posición en la que juega el jugador - posicion != null
     * @param altura   Es la altura del jugador en metros - altura > 0
     * @param peso     Es el peso del jugador en kilogramos - peso > 0
     * @param salario  Es el salario del jugador - salario > 0
     * @param imagen   Es la ruta a la imagen con la foto del jugador - imagen != null
     * @return Retorna true si el jugador se pudo agregar. Esto sirve para saber si se debe cerrar el diálogo.
     */
    public boolean crearJugador(String nombre, int edad, String posicion, double altura, double peso, double salario, String imagen) {
        boolean ok = false;

        if (equipoSeleccionado != null) {
            try {
                mundial.agregarJugadorAEquipo(equipoSeleccionado.getPais(), nombre, edad, posicion, altura, peso, salario, imagen);
                equipoSeleccionado = mundial.darEquipo(equipoSeleccionado.getPais());
                panelJugadores.cambiarJugadores(equipoSeleccionado);
                ok = true;
            }
            catch (ElementoExisteException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }

        return ok;
    }

    /**
     * Cambiar la información del jugador seleccionado
     */
    public boolean modificarInformacionJugador(String nombre, int edad, String posicion, double altura, double peso, double salario, String imagen) {
        boolean ok = false;

        if (equipoSeleccionado != null) {
            mundial.cambiarInformaciónJugador(equipoSeleccionado.getPais(), nombre, edad, posicion, altura, peso, salario, imagen);
            equipoSeleccionado = mundial.darEquipo(equipoSeleccionado.getPais());
            panelJugadores.cambiarJugadores(equipoSeleccionado);
            ok = true;
        }

        return ok;
    }

    /**
     * Calcula el valor de la nómina del equipo seleccionado
     */
    public void calcularValorNomina() {
        double nomina = mundial.calcularValorNomina(equipoSeleccionado.getPais());
        String resp = formatearValor(nomina);
        JOptionPane.showMessageDialog(this, "El valor total de la nómina es: " + resp, "Reporte Guardado", JOptionPane.INFORMATION_MESSAGE);

    }

    /**
     * Este método se encarga de modificar la información de los jugadores a partir de un archivo
     */
    public void modificarInformacionJugadores() {
        panelEquipos.refrescarEquipos(mundial.darNombresEquipos());
    }

    /**
     * Formatea un valor numérico para presentar en la interfaz <br>
     *
     * @param valor El valor numérico a ser formateado
     * @return Cadena con el valor formateado con puntos y signos.
     */
    public String formatearValor(double valor) {
        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
        df.applyPattern("$ ###,###.##");
        df.setMinimumFractionDigits(2);
        return df.format(valor);
    }

    /**
     * Este método se encarga de salvar la información del mundial, justo antes de cerrar la aplicación
     */
    public void dispose() {
        try {
            Utils.guardarMundial(mundial);
            super.dispose();
        }
        catch (Exception e) {
            setVisible(true);
            int respuesta = JOptionPane.showConfirmDialog(this, "Problemas salvando la información del mundial:\n" + e.getMessage() + "\n¿Quiere cerrar el programa sin salvar?", "Error", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                super.dispose();
            }
        }
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1
     */
    public void reqFuncOpcion1() {
        if (equipoSeleccionado != null) {
            String resultado = mundial.metodo1(equipoSeleccionado.getPais());
            JOptionPane.showMessageDialog(this, "El jugador más viejo se llama: " + resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Método para la extensión 2
     */
    public void reqFuncOpcion2() {
        if (equipoSeleccionado != null) {
            double resultado = mundial.metodo2(equipoSeleccionado.getPais());
            JOptionPane.showMessageDialog(this, "El promedio de edad es: " + resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz
     *
     * @param args Argumentos para la ejecución de la aplicación. No deben usarse
     */
    public static void main(String[] args) {
        Mundial mundial = new Mundial();

        try {
            Utils.leerMundial(mundial);
        }
        catch (FileNotFoundException e) {
            System.out.printf("Archivo con los equipos, no encontrado!");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        InterfazMundial id = new InterfazMundial(mundial);
        id.setVisible(true);
    }


}
