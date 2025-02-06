package br.edu.iftm.gui;

import br.edu.iftm.gui.components.Botao;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static br.edu.iftm.gui.Janela.screenSize;


public class LoginPanel extends TelaPanel{

    public LoginPanel(JPanel telas, JFrame janela){
        super(telas, janela);
        JLabel mensagem = new JLabel("Login Painel");

        int width = (int) screenSize().getWidth();
        int height = (int) screenSize().getHeight();

        Botao botaoLogin = new Botao("Fazer login",width/2 - 50,height/2 + 200, 150, 40);
        botaoLogin.addActionListener(this);

        this.add(mensagem);
        this.add(botaoLogin);
    }

    public void executarBotao(ActionEvent e){
        trocarTela("Tela Principal");
    }
}