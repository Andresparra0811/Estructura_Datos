/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean
 * Programa de Ingenier�a de Sistemas
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Unidad de Estudios: Estructura de Datos
 * Ejercicio: Central de pacientes
 * <p>
 * Fecha: Febrero de 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package universidadean.centralpacientes.interfaz;

import ean.collections.IList;
import universidadean.centralpacientes.mundo.Paciente;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import static universidadean.centralpacientes.mundo.PacienteKt.HOMBRE;
import static universidadean.centralpacientes.mundo.PacienteKt.MUJER;

/**
 * Panel para el manejo de la informaci�n del paciente
 */
public class PanelInformacionPaciente extends JPanel {
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    /**
     * Representa el genero del paciente
     */
    public static final String MASCULINO = "Masculino";

    /**
     * Representa el genero del paciente
     */
    public static final String FEMENINO = "Femenino";

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Texto para el nombre del paciente
     */
    private JTextField textoNombre;

    /**
     * Texto para el c�digo del paciente
     */
    private JTextField textoCodigo;

    /**
     * Combo para las cl�nicas del paciente
     */
    private JComboBox comboClinicas;

    /**
     * Bot�n para el g�nero del paciente
     */
    private JRadioButton botonMasculino;

    /**
     * Bot�n para el g�nero del paciente
     */
    private JRadioButton botonFemenino;

    /**
     * �rea para la informaci�n m�dica del paciente
     */
    private JTextArea areaInformacionMedica;

    /**
     * Grupo para los botones del g�nero
     */
    private ButtonGroup grupo;

    /**
     * Etiqueta para la cl�nica
     */
    private JLabel etiquetaClinica;

    /**
     * Etiqueta para el g�nero
     */
    private JLabel etiquetaSexo;

    /**
     * Etiqueta para la historia
     */
    private JLabel etiquetaHistoriaClinica;

    /**
     * Etiqueta para el nombre
     */
    private JLabel etiquetaNombre;

    /**
     * Etiqueta para el c�digo
     */
    private JLabel etiquetaCodigo;

    /**
     * Barra de desplazamiento para la �rea de la historia
     */
    private JScrollPane barraDesplazamientoAreaHistoria;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel
     */
    public PanelInformacionPaciente() {
        setLayout(new GridBagLayout());
        setBorder(new TitledBorder("Informaci�n del Paciente"));

        // Nombre del paciente
        etiquetaNombre = new JLabel("Nombre");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        add(etiquetaNombre, gbc);

        textoNombre = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        add(textoNombre, gbc);

        // C�dula del paciente
        etiquetaCodigo = new JLabel("C�digo");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(etiquetaCodigo, gbc);

        textoCodigo = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 2;
        add(textoCodigo, gbc);

        // Cl�nica asignada al paciente
        etiquetaClinica = new JLabel("Cl�nica");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        add(etiquetaClinica, gbc);

        comboClinicas = new JComboBox();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 2;
        add(comboClinicas, gbc);

        // Sexo del paciente
        etiquetaSexo = new JLabel("Sexo");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.BOTH;
        add(etiquetaSexo, gbc);

        botonMasculino = new JRadioButton(MASCULINO);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.BOTH;
        botonMasculino.setSelected(true);
        add(botonMasculino, gbc);

        botonFemenino = new JRadioButton(FEMENINO);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.BOTH;
        add(botonFemenino, gbc);

        grupo = new ButtonGroup();
        grupo.add(botonMasculino);
        grupo.add(botonFemenino);

        // Informaci�n m�dica del paciente
        etiquetaHistoriaClinica = new JLabel("Informaci�n M�dica");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.BOTH;
        add(etiquetaHistoriaClinica, gbc);

        areaInformacionMedica = new JTextArea();
        areaInformacionMedica.setLineWrap(true);
        areaInformacionMedica.setWrapStyleWord(true);
        barraDesplazamientoAreaHistoria = new JScrollPane(areaInformacionMedica);
        barraDesplazamientoAreaHistoria.setPreferredSize(new Dimension(200, 100));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 3;
        add(barraDesplazamientoAreaHistoria, gbc);

    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Cambia la informaci�n del combo de cl�nicas con la lista de cl�nicas en la lista dada
     * @param clinicas Nueva lista de cl�nicas. clinicas!=null
     */
    public void cambiarInformacionComboClinicas(IList<String> clinicas) {
        comboClinicas.removeAllItems();

        for (int cont = 0; cont < clinicas.size(); cont++) {
            comboClinicas.addItem(clinicas.get(cont));
        }
        comboClinicas.setSelectedIndex(-1);
    }

    /**
     * Habilita el �rea en la que se muestra la informaci�n m�dica del paciente
     *
     */
    public void habilitarAreaInformacionMedica() {
        areaInformacionMedica.setEditable(true);
    }

    /**
     * Habilita todos los componentes del panel
     *
     */
    public void habilitarComponentes() {
        textoCodigo.setEditable(true);
        textoNombre.setEditable(true);
        botonFemenino.setEnabled(true);
        botonMasculino.setEnabled(true);
        areaInformacionMedica.setEditable(true);
        comboClinicas.setEnabled(true);
    }

    /**
     * Deshabilita todos los componentes del panel
     *
     */
    public void deshabilitarComponentes() {
        textoCodigo.setEditable(false);
        textoNombre.setEditable(false);
        botonFemenino.setEnabled(false);
        botonMasculino.setEnabled(false);
        areaInformacionMedica.setEditable(false);
        comboClinicas.setEnabled(false);
    }

    /**
     * Retorna el c�digo del paciente que se va a insertar
     * @return El c�digo del paciente a ser insertado
     * @throws NumberFormatException Si el c�dula ingresada por el usuario no es un n�mero
     */
    public int darCodigoPaciente() throws NumberFormatException {
        String cadena = textoCodigo.getText();
        int ced = Integer.parseInt(cadena);

        return ced;
    }

    /**
     * Retorna el nombre del paciente que se va a insertar
     * @return El nombre del paciente que se va a insertar
     */
    public String darNombrePaciente() {
        return textoNombre.getText();
    }

    /**
     * Retorna la cl�nica del paciente que se va a insertar
     * @return La cl�nica del paciente que se va a insertar
     */
    public String darClinicaPaciente() {
        return (String) comboClinicas.getSelectedItem();
    }

    /**
     * Retorna el sexo del paciente que se va a insertar
     * @return El sexo del paciente que se va a insertar
     */
    public int darSexoPaciente() {
        return botonFemenino.isSelected() ? MUJER : HOMBRE;

    }

    /**
     * Retorna la informaci�n m�dica del paciente que se va a insertar
     * @return La informaci�n m�dica del paciente que se va a insertar
     */
    public String darInformacionMedicaPaciente() {
        return areaInformacionMedica.getText();
    }

    /**
     * Muestra la informaci�n del paciente
     * @param paciente Paciente del que se va a mostrar la informaci�n - paciente!=null
     */
    public void mostrarInformacionPaciente(Paciente paciente) {
        textoNombre.setText(paciente.darNombre());
        textoCodigo.setText(Integer.toString(paciente.darCodigo()));
        areaInformacionMedica.setText(paciente.darInformacionMedica());
        comboClinicas.setSelectedItem(paciente.darClinica());

        if (paciente.darSexo() == HOMBRE) {
            botonMasculino.setSelected(true);
        }
        else {
            botonFemenino.setSelected(true);
        }
    }
}
