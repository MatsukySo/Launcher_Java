package br.edu.iftm.gui;

import javax.swing.*;
import java.awt.*;

public class Janela extends JFrame {

    public static Dimension screenSize(){
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        return size;
    }

    public Janela(){
        int width = (int) screenSize().getWidth() - 100;
        int hight = (int) screenSize().getHeight() - 100;
        this.setBounds(50, 50, width, hight);

        CardLayout controleTelas = new CardLayout();
        JPanel telas = new JPanel(controleTelas);

        LoginPanel loginPanel = new LoginPanel(telas, this);
        PrincipalPainel principalPainel = new PrincipalPainel(telas, this);


        telas.add(loginPanel, "Tela Login");
        telas.add(principalPainel, "Tela Principal");

        controleTelas.show(telas ,"Tela Login");

        this.add(telas);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setVisible(true);
    }
}
