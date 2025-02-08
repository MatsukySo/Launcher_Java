package br.edu.iftm.gui.components;

import javax.swing.*;
import java.awt.*;

public class Botao2 extends JButton {
    public Botao2(String texto, int x, int y, int width, int height, String cor1, String cor2){
        super(texto);
        this.setBackground(Color.decode(cor1));
        this.setFocusPainted(false);
        this.setForeground(Color.decode(cor2));
        this.setBorderPainted(true);
        this.setBounds(x, y, width, height);
    }
}
