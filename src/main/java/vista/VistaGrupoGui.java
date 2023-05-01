package vista;

import javax.swing.*;

public class VistaGrupoGui extends JFrame {
    private JPanel panelPrincipal;
    private JPanel panelNorte;
    private JPanel panelCentro;
    public JTextField jtxtClave;
    private JLabel lblClave;
    private JPanel panelSur;
    public JButton btnNuevo;
    public JButton btnActualizar;
    public JButton btnEliminar;
    public JButton btnGuardar;
    public JButton btnSalir;
    public JLabel lblHora;
    public JTextField jtxtHora;
    public JLabel lblSalon;
    public JTextField jtxtSalon;
    private JComboBox cbxCatedratico;
    private JLabel lblCatedratico;
    private JLabel lblAlumno;
    private JComboBox cbxAlumno;
    private JLabel lblMateria;
    private JComboBox cbxMateria;

    public VistaGrupoGui(){
        super("Ventana Grupo");
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(800,150);
        setVisible(true);
    }
}
