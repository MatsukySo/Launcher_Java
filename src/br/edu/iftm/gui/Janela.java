package br.edu.iftm.gui;

import javax.swing.*;
import java.awt.*;

public class Janela extends JFrame {
    public Janela(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth() - 100;
        int hight = (int) screenSize.getHeight() - 100;
        this.setBounds(50, 50, width, hight);

        CardLayout controleTelas = new CardLayout();
        JPanel telas = new JPanel(controleTelas);

        LoginPanel loginPanel = new LoginPanel(telas);
        PrincipalPainel principalPainel = new PrincipalPainel(telas);


        telas.add(loginPanel, "Tela Login");
        telas.add(principalPainel, "Tela Principal");

        controleTelas.show(telas ,"Tela Login");

        this.add(telas);

        this.setVisible(true);
    }
}
