package br.edu.iftm.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class LoginPanel extends TelaPanel{
    private JButton botaoLogion;

    public LoginPanel(JPanel telas, JFrame janela){
        super(telas, janela);
        JLabel mensagem = new JLabel("Login Painel");


        botaoLogion = new JButton("Fazer login");
        botaoLogion.addActionListener(this);

        this.add(mensagem);
        this.add(botaoLogion);
    }

    public void executarBotao(ActionEvent e){
        trocarTela("Tela Principal");
    }
}