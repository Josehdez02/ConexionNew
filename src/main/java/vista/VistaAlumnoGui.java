package vista;

import dao.DAOEspecialidad;
import modelo.ModeloEspecialidad;

import javax.swing.*;
import java.util.List;

public class VistaAlumnoGui extends JFrame{
    private JPanel panelNorte;
    public JTextField jtxNumControl;
    public JButton btnNuevo;
    public JButton btnGuardar;
    public JButton btnSalir;
    public JTextField jtxNombre;
    public JButton btnConsultar;
    public JButton btnEliminar;
   // public JComboBox cbxEspecialidad;
    private JLabel lblEspecialidad;
    private JPanel panelPrincipal;
    private JLabel lblNumControl;
    private JPanel panelCentro;
    private JLabel lblNombre;
    private JPanel panelSur;
    public JComboBox cbxEspecialidad;
    //public final static ArrayList<ModeloEspecialidad>esepecialida=new ArrayList<>();

    public VistaAlumnoGui(){
        super("Ventana Alumno");
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(600,150);
        DAOEspecialidad daoEspecialidad=new DAOEspecialidad();
        List<ModeloEspecialidad> especialidades = daoEspecialidad.consultar();
       // cbxEspecialidad.removeAllItems();
        for (ModeloEspecialidad e : daoEspecialidad.consultar()){
            cbxEspecialidad.addItem(e);
        }
        setVisible(true);
    }

}
//E
