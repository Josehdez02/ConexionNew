package controlador;

import dao.DAOEspecialidad;
import dao.DAOMateria;
import modelo.ModeloEspecialidad;
import modelo.ModeloMateria;
import vista.ConsultarEspecialidad;
import vista.VistaEspecialidadGui;
import vista.VistaMateriaGui;
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
        if (e.getSource()==vistaPrincipal.btnConsultar) {
            String opcion = vistaPrincipal.cmbxOpciones.getSelectedItem().toString();
            if (opcion.equals("Alta Especialidad")) {
                DAOEspecialidad d1=new DAOEspecialidad();
                d1.consultar();

            }
        } else {
            String opcion = vistaPrincipal.cmbxOpciones.getSelectedItem().toString();
            if (opcion.equals("Alta Especialidad")) {
                VistaEspecialidadGui ve = new VistaEspecialidadGui();
                ModeloEspecialidad me = new ModeloEspecialidad();
                ControladorEspecialidadGui ce = new ControladorEspecialidadGui(me, ve);
            }

        }
        if (e.getSource()==vistaPrincipal.btnConsultar) {
            String opcion = vistaPrincipal.cmbxOpciones.getSelectedItem().toString();
            if (opcion.equals("Alta Materia")) {
                DAOMateria d2=new DAOMateria();
                d2.consultar();

            }
        }
        else {
            String opcion = vistaPrincipal.cmbxOpciones.getSelectedItem().toString();
            if (opcion.equals("Alta Materia")) {
                VistaMateriaGui vm = new VistaMateriaGui();
                ModeloMateria mm = new ModeloMateria();
                ControladorMateriaGui ce = new ControladorMateriaGui(mm, vm);
            }

        }
    }
}
///pruebaaa