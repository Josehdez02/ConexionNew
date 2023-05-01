package controlador;

import dao.DAOAlumno;
import dao.DAOEspecialidad;
import modelo.ModeloEspecialidad;
import modelo.ModeloAlumno;
import vista.VistaAlumnoGui;
import vista.VistaEspecialidadGui;
import vista.VistaPrincipal;

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
                DAOEspecialidad d1 = new DAOEspecialidad();
                d1.consultar();
            }
            if (opcion.equals("Alta Alumno")) {
                DAOAlumno d2 = new DAOAlumno();
                d2.consultar();


            }
        } else {
            String opcion = vistaPrincipal.cmbxOpciones.getSelectedItem().toString();
            if (opcion.equals("Alta Especialidad")) {
                VistaEspecialidadGui ve = new VistaEspecialidadGui();
                ModeloEspecialidad me = new ModeloEspecialidad();
                ControladorEspecialidadGui ce = new ControladorEspecialidadGui(me, ve);
            }else if (opcion.equals("Alta Alumno")) {
                VistaAlumnoGui va=new VistaAlumnoGui();
                ModeloAlumno ma = new ModeloAlumno();
                ControladorAlumnoGui ca = new ControladorAlumnoGui(ma, va);

            }
        }
    }
}