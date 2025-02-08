package br.edu.iftm.gui.components;

import javax.swing.*;
import javax.xml.stream.Location;
import java.awt.*;

public class Botao extends JButton {
    public Botao(String texto, int x, int y, int width, int height){
        super(texto);

        this.setBackground(Color.decode("#414450"));
        this.setFocusPainted(false);
        this.setForeground(Color.decode("#ced0d6"));
        this.setBorderPainted(true);
        this.setBounds(x, y, width, height);
    }
}