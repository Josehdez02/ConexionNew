package controlador;
import dao.DAOGrupo;
import dao.DAOCatedratico;
import modelo.ModeloAlumno;
import modelo.ModeloGrupo;
import modelo.ModeloCatedratico;
import modelo.ModeloMateria;
import vista.VistaGrupoGui;
import vista.VistaCatedraticoGui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorGrupoGui implements ActionListener {

    private final ModeloGrupo modeloGrupo;
    private final VistaGrupoGui vistaGrupo;
    public ControladorGrupoGui(ModeloGrupo modeloGrupo, VistaGrupoGui vistaGrupo) {
        this.modeloGrupo = modeloGrupo;
        this.vistaGrupo= vistaGrupo;

        this.vistaGrupo.btnGuardar.addActionListener(this);
        this.vistaGrupo.btnNuevo.addActionListener(this);
        this.vistaGrupo.btnSalir.addActionListener(this);
        this.vistaGrupo.btnEliminar.addActionListener(this);
        //this.vistaGrupo.btnActualizar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        DAOGrupo dao = new DAOGrupo();
        String hora=vistaGrupo.jtxtHora.getText();
        String clavecad=vistaGrupo.jtxtClave.getText();
        String saloncad=vistaGrupo.jtxtSalon.getText();
        boolean err=true;
        int clave=0;
        int salon=0;

        if (hora.length()>0&clavecad.length()>0&saloncad.length()>0) {
            try {
                salon = Integer.parseInt(vistaGrupo.jtxtSalon.getText());
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null,
                        "Se ingreso una letra en el salon",
                        "AVISO",
                        JOptionPane.INFORMATION_MESSAGE);
                err = false;
            }
        } else if (hora.length()>0&clavecad.length()>0&saloncad.length()==0) {
            JOptionPane.showMessageDialog(null,
                    "Faltan Datos",
                    "AVISO",
                    JOptionPane.INFORMATION_MESSAGE);
            err=false;
        } else if (hora.length()>0&clavecad.length()==0&saloncad.length()>0) {
            JOptionPane.showMessageDialog(null,
                    "Faltan Datos",
                    "AVISO",
                    JOptionPane.INFORMATION_MESSAGE);
            err=false;
        } else if (hora.length()==0&clavecad.length()==0&saloncad.length()==0) {
            JOptionPane.showMessageDialog(null,
                    "Faltan Datos",
                    "AVISO",
                    JOptionPane.INFORMATION_MESSAGE);
            err=false;
        }
        if (hora.length()>0&clavecad.length()>0&saloncad.length()>0){
            try {
                clave=Integer.parseInt(vistaGrupo.jtxtClave.getText());
            }catch (Exception error){
                JOptionPane.showMessageDialog(null,
                        "Se ingreso una letra en la clave",
                        "AVISO",
                        JOptionPane.INFORMATION_MESSAGE);
                err=false;
            }
        } else if (hora.length()==0&clavecad.length()>0&saloncad.length()>0) {
            JOptionPane.showMessageDialog(null,
                    "Faltan Datos",
                    "AVISO",
                    JOptionPane.INFORMATION_MESSAGE);
            err=false;
        }

        if (err==true) {
        if (this.vistaGrupo.btnNuevo == evento.getSource()) {
            clear();
        } else if (vistaGrupo.btnGuardar == evento.getSource()) {
            modeloGrupo.setClave(clave);
            modeloGrupo.setHora(hora);
            modeloGrupo.setSalon(salon);
            modeloGrupo.setModeloCatedratico((ModeloCatedratico) vistaGrupo.cbxCatedratico.getSelectedItem());
            modeloGrupo.setModeloAlumno((ModeloAlumno)vistaGrupo.cbxAlumno.getSelectedItem());
            modeloGrupo.setModeloMateria((ModeloMateria)vistaGrupo.cbxMateria.getSelectedItem());
            if (dao.agregar(modeloGrupo)) {
                JOptionPane.showMessageDialog(null,
                        "Registro Guardado!",
                        "AVISO",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                        "Ups! Falló al intentar agragar Grupo.\n"
                                + "Intente nuevamente",
                        "Aviso",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
            clear();
        }else if (vistaGrupo.btnSalir==evento.getSource()){
            Salir();

        } else if (vistaGrupo.btnEliminar==evento.getSource()) {
            dao.eliminar(Integer.parseInt(vistaGrupo.jtxtClave.getText()));

        }else if (vistaGrupo.btnActualizar==evento.getSource()){

        }

    }

    public void clear(){
        this.vistaGrupo.jtxtClave.setText("");
        this.vistaGrupo.jtxtHora.setText("");
        this.vistaGrupo.jtxtSalon.setText("");
    }

    public void Salir(){System.exit(0);}

}
