package vista;

import dao.DAOCatedratico;
import dao.DAOAlumno;
import dao.DAOMateria;
import modelo.ModeloAlumno;
import modelo.ModeloCatedratico;
import modelo.ModeloMateria;

import javax.swing.*;
import java.util.List;

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
    public JComboBox cbxCatedratico;
    private JLabel lblCatedratico;
    private JLabel lblAlumno;
    public JComboBox cbxAlumno;
    private JLabel lblMateria;
    public JComboBox cbxMateria;
    DAOCatedratico daoCatedratico=new DAOCatedratico();
    List<ModeloCatedratico> catedraticos = daoCatedratico.consultar();
    DAOAlumno daoAlumno=new DAOAlumno();
    List<ModeloAlumno> alumnos = daoAlumno.consultar();
    DAOMateria daoMateria=new DAOMateria();
    List<ModeloMateria> materias = daoMateria.consultar();
    public VistaGrupoGui(){
        super("Ventana Grupo");
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(600,200);
        for (ModeloCatedratico e : daoCatedratico.consultar()){
            cbxCatedratico.addItem(e);
        }
        for (ModeloAlumno e : daoAlumno.consultar()){
            cbxAlumno.addItem(e);
        }
        for (ModeloMateria e : daoMateria.consultar()){
            cbxMateria.addItem(e);
        }
        setVisible(true);

    }


}
