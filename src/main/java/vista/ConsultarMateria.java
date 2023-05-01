package vista;

import javax.swing.*;

public class ConsultarMateria extends  JFrame{
    private JPanel panelPrincipal;
    public JTable tableMateria;

    public ConsultarMateria(){
        super("Materia");
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);

        setVisible(true);
    }
}
//po
