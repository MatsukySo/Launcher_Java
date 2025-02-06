package br.edu.iftm.gui;

import br.edu.iftm.gui.components.Botao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static br.edu.iftm.gui.Janela.screenSize;


public class LoginPanel extends TelaPanel{
    public LoginPanel(JPanel telas, JFrame janela){
        super(telas, janela);

        int width = (int) screenSize().getWidth();
        int height = (int) screenSize().getHeight();

        JLabel mensagem = new JLabel("Login Painel");

        Botao botaoLogin = new Botao("Fazer login",width/2 - 50,height/2 + 200, 150, 40);
        botaoLogin.addActionListener(this);

        this.add(mensagem);
        this.add(botaoLogin);
        boxLogin();
    }

    JPasswordField caixaSenha;
    JTextField caixaLogin;
    public void boxLogin(){
        int width = (int) screenSize().getWidth();
        int height = (int) screenSize().getHeight();

        caixaLogin = caixaLogin = new JTextField();
        caixaLogin.setBackground(Color.decode("#ced0d6"));
        caixaLogin.setBounds(width/2 - 43,height/2 + 130, 130, 20);

        JLabel txtLogin = new JLabel("Login:");
        txtLogin.setForeground(Color.decode("#ced0d6"));
        txtLogin.setBounds(width/2 - 42,height/2 + 110, 130, 20);

        caixaSenha = caixaSenha = new JPasswordField();

        caixaSenha.setBackground(Color.decode("#ced0d6"));
        caixaSenha.setBounds(width/2 - 43,height/2 + 170, 130, 20);
        JLabel txtSenha = new JLabel("Senha:");
        txtSenha.setBounds(width/2 - 42,height/2 + 152, 130, 20);
        txtSenha.setForeground(Color.decode("#ced0d6"));

        this.add(caixaLogin);
        this.add(txtLogin);

        this.add(caixaSenha);
        this.add(txtSenha);
    }

    public void executarBotao(ActionEvent e) {
        if (caixaLogin.getText().equals("MatsukySo") && caixaSenha.getText().equals("983212,")) {
            trocarTela("Tela Principal");
            caixaSenha.setText("");
        }
        else{
            JOptionPane.showMessageDialog(null, "Senha ou Login incorretos!");
        }
    }
}