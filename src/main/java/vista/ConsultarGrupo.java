package vista;

import javax.swing.*;

public class ConsultarGrupo extends JFrame {
    private JPanel panelPrincipal;
    public JTable tableGrupo;

    public ConsultarGrupo() {
        super("Grupo");
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);

        setVisible(true);
    }
}
