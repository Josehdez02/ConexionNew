package vista;

import javax.swing.*;

public class VistaMateriaGui extends JFrame{
    private JPanel panelPrincipal;
    private JPanel PanelNorte;
    private JPanel PanelSur;
    private JPanel PanelCentro;
    public  JTextField txtID;
    public JTextField txtNombre;
    public JButton btnNuevo;
    public JButton btnEliminar;
    public JButton btnGuardar;
    public JButton btnSalir;
    public JLabel lblID;

    public JLabel lblNombre;

    public VistaMateriaGui(){
        super("Ventana Materia");
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(435,140);
        // this.jtfClave.setText("1");
        // this.jtxNombre.setText("Programacion");
        setVisible(true);
    }
}
//loo