package org.example;


import conexion.Conexion;
import controlador.ControladorEspecialidadGui;
import controlador.ControladorVistaPrincipal;
import modelo.ModeloEspecialidad;
import vista.VistaEspecialidadGui;
import vista.VistaPrincipal;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        //Conexion con=new Conexion();
        //con.abrir();
        VistaPrincipal v1=new VistaPrincipal();
        ControladorVistaPrincipal c1=new ControladorVistaPrincipal(v1);
    }
}
//cvc