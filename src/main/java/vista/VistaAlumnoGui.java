package vista;

import dao.DAOEspecialidad;
import modelo.ModeloEspecialidad;

import javax.swing.*;

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
    private JPanel panelPricipal;
    private JLabel lblNumControl;
    private JPanel panelCentro;
    private JLabel lblNombre;
    private JPanel panelSur;
    public JButton btnActualizar;
    //public final static ArrayList<ModeloEspecialidad>esepecialida=new ArrayList<>();

    public VistaAlumnoGui(){
        super("Ventana Alumno");
        setContentPane(panelPricipal);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500,200);
        // this.jtfClave.setText("1");
        // this.jtxNombre.setText("Programacion");
       // cbxEspecialidad.removeAllItems();
        //for (ModeloEspecialidad e : DAOEspecialidad.lista){
          //  cbxEspecialidad.addItem(e.getNombre());
       // }
        setVisible(true);
    }
}
//E