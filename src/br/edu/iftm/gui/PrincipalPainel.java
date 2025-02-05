package br.edu.iftm.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrincipalPainel extends JPanel implements ActionListener {
    private JPanel telas;
    private CardLayout controleTelas;

    public PrincipalPainel(JPanel telas){
        this.telas = telas;
        this.controleTelas = (CardLayout) telas.getLayout();

        JLabel mensagem = new JLabel("Principal Painel");
        JButton botao = new JButton("Voltar");

        botao.addActionListener(this::actionPerformed);
        this.add(mensagem);
        this.add(botao);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controleTelas.show(telas ,"Tela Login");
    }
}
