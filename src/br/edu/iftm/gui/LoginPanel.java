package br.edu.iftm.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginPanel extends JPanel implements ActionListener{
    private JPanel telas;
    private CardLayout controleTelas;

    public LoginPanel(JPanel telas){
        this.telas = telas;
        this.controleTelas = (CardLayout) telas.getLayout();

        JLabel mensagem = new JLabel("Login Painel");

        JButton botao = new JButton("Fazer login");

        botao.addActionListener(this::actionPerformed);
        this.add(mensagem);
        this.add(botao);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controleTelas.show(telas ,"Tela Principal");
    }
}