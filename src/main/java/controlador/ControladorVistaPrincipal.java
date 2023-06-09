package controlador;

import dao.DAOCatedratico;
import dao.DAOAlumno;
import dao.DAOEspecialidad;
import dao.DAOMateria;
import dao.DAOGrupo;
import modelo.ModeloCatedratico;
import modelo.ModeloEspecialidad;
import modelo.ModeloAlumno;
import modelo.ModeloMateria;
import modelo.ModeloGrupo;
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
                ConsultarEspecialidad ce=new ConsultarEspecialidad();
                ce.mostrarVentana();

            }
            if (opcion.equals("Alta Catedratico")) {
                ConsultarCatedratico cc=new ConsultarCatedratico();
                cc.mostrarVentana();

            }
            if (opcion.equals("Alta Alumno")) {
                ConsultarAlumno ca=new ConsultarAlumno();
                ca.mostrarVentana();
            }
            if (opcion.equals("Alta Materia")) {
                ConsultarMateria cm=new ConsultarMateria();
                cm.mostrarVentana();
            }
            if (opcion.equals("Alta Grupo")) {
                ConsultarGrupo cg=new ConsultarGrupo();
                cg.mostrarVentana();
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
                    ControladorMateriaGui cm = new ControladorMateriaGui(mm, vm);
                } else if (opcion.equals("Alta Catedratico")) {
                    VistaCatedraticoGui vc = new VistaCatedraticoGui();
                    ModeloCatedratico mc = new ModeloCatedratico();
                    ControladorCatedraticoGui cc = new ControladorCatedraticoGui(mc, vc);
                }else if (opcion.equals("Alta Grupo")) {
                VistaGrupoGui vg = new VistaGrupoGui();
                ModeloGrupo mg = new ModeloGrupo();
                ControladorGrupoGui cg = new ControladorGrupoGui(mg, vg);
            }

        }
    }
}
