package vista;

import javax.swing.*;

public class VistaEspecialidadGui extends JFrame {
    private JPanel panelPrincipal;
    private JPanel panelNorte;
    private JPanel panelCentro;
    private JPanel panelSur;
    public JTextField jtxId;
    public JTextField jtxNombre;
    private JLabel lblLid;
    private JLabel lblNombre;
    public JButton btnNuevo;
    public JButton btnActualizar;
    public JButton btnEliminar;
    public JButton btnGuardar;
    public JButton btnSalir;

    public VistaEspecialidadGui(){
        super("Ventana Especialidad");
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(435,140);
        // this.jtfClave.setText("1");
        // this.jtxNombre.setText("Programacion");
        setVisible(true);
    }
}
//ffgg