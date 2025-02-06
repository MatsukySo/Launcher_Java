package br.edu.iftm.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class PrincipalPainel extends TelaPanel{
    private JButton botaoPrincipal;

    public PrincipalPainel(JPanel telas, JFrame janela){
        super(telas, janela);
        JLabel mensagem = new JLabel("Tela Principal");

        botaoPrincipal = new JButton("Voltar");
        botaoPrincipal.addActionListener(this);

        this.add(mensagem);
        this.add(botaoPrincipal);
    }

    public void executarBotao(ActionEvent e){
        trocarTela("Tela Login");
    }
}
