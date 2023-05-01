package controlador;

import dao.DAOCatedratico;
import dao.DAOEspecialidad;
import dao.DAOAlumno;
import dao.DAOEspecialidad;
import dao.DAOMateria;
import modelo.ModeloCatedratico;
import modelo.ModeloEspecialidad;
import modelo.ModeloAlumno;
import modelo.ModeloMateria;
import vista.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorVistaPrincipal implements ActionListener {
    private final VistaPrincipal vistaPrincipal;

    public ControladorVistaPrincipal(VistaPrincipal vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;
        this.vistaPrincipal.btnConsultar.addActionListener(this);
        this.vistaPrincipal.btnAceptar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaPrincipal.btnConsultar) {
            String opcion = vistaPrincipal.cmbxOpciones.getSelectedItem().toString();
            if (opcion.equals("Alta Especialidad")) {
                ConsultarEspecialidad c1=new ConsultarEspecialidad();
                c1.consultar();
            }
            if (opcion.equals("Alta Catedratico")) {
                DAOCatedratico d2 = new DAOCatedratico();
                d2.consultar();
            }
            if (opcion.equals("Alta Alumno")) {
                DAOAlumno d3 = new DAOAlumno();
                d3.consultar();

            }
            if (opcion.equals("Alta Materia")) {
                DAOMateria d4 = new DAOMateria();
                d4.consultar();
            }
        }else {
                String opcion = vistaPrincipal.cmbxOpciones.getSelectedItem().toString();
                if (opcion.equals("Alta Especialidad")) {
                    VistaEspecialidadGui ve = new VistaEspecialidadGui();
                    ModeloEspecialidad me = new ModeloEspecialidad();
                    ControladorEspecialidadGui ce = new ControladorEspecialidadGui(me, ve);
                } else if (opcion.equals("Alta Alumno")) {
                    VistaAlumnoGui va = new VistaAlumnoGui();
                    ModeloAlumno ma = new ModeloAlumno();
                    ControladorAlumnoGui ca = new ControladorAlumnoGui(ma, va);
                } else if (opcion.equals("Alta Materia")) {
                    VistaMateriaGui vm = new VistaMateriaGui();
                    ModeloMateria mm = new ModeloMateria();
                    ControladorMateriaGui ce = new ControladorMateriaGui(mm, vm);
                } else if (opcion.equals("Alta Catedratico")) {
                    VistaCatedraticoGui vc = new VistaCatedraticoGui();
                    ModeloCatedratico mc = new ModeloCatedratico();
                    ControladorCatedraticoGui ce = new ControladorCatedraticoGui(mc, vc);
                }
        }
    }
}




