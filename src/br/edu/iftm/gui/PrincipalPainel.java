package br.edu.iftm.gui;

import br.edu.iftm.gui.components.Botao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static br.edu.iftm.gui.Janela.screenSize;

public class PrincipalPainel extends TelaPanel{
    private Botao botaoPrincipal;

    public PrincipalPainel(JPanel telas, JFrame janela){
        super(telas, janela);
        JLabel mensagem = new JLabel("Tela Principal");


        botaoPrincipal = new Botao("Voltar", (int)screenSize().getWidth() -117, (int)screenSize().getHeight() -50, 100, 30);
        botaoPrincipal.addActionListener(this);

        this.add(mensagem);
        this.add(botaoPrincipal);
    }

    public void executarBotao(ActionEvent e){
        trocarTela("Tela Login");
    }
}
