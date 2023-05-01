package vista;

import javax.swing.*;

public class VistaCatedraticoGui extends JFrame{
    private JPanel panelPrincipal;
    private JPanel panelNorte;
    private JPanel panelCentro;
    private JPanel panelSur;
    public JTextField jtxRFC;
    public JLabel lblRFC;
    public JTextField jtxNombre;
    public JLabel lblNombre;
    public JButton btnNuevo;
    public JButton btnActualizar;
    public JButton btnEliminar;
    public JButton btnGuardar;
    public JButton btnSalir;

    public VistaCatedraticoGui(){
        super("Ventana Catedratico");
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(435,140);
        setVisible(true);
    }
}

