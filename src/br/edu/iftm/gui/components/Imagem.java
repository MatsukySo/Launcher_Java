package br.edu.iftm.gui.components;

import javax.swing.*;

public class Imagem extends JLabel{
    public Imagem(String name){
        super();
        ImageIcon icone = new ImageIcon(Imagem.class.getResource("/imagens/" + name));
        setIcon(icone);
        repaint();
    }
}