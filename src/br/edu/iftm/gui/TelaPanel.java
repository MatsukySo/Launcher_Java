package br.edu.iftm.gui;

import br.edu.iftm.gui.components.Imagem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaPanel extends JPanel implements ActionListener {
    private JPanel telas;
    private CardLayout controleTelas;
    private JFrame janela;

    public TelaPanel(JPanel telas, JFrame janela){
        this.telas = telas;
        this.controleTelas = (CardLayout) telas.getLayout();
        this.janela = janela;
        this.setBackground(Color.decode("#282a36"));
        this.setLayout(null);

        Imagem iconClose =  new Imagem("iconClose.png");
        Imagem iconMinimize = new Imagem("iconMinimize.png");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) screenSize.getWidth();

        iconClose.setBounds(x -32,  0, 32, 32);
        iconMinimize.setBounds(x - 64, 0, 32, 32);

        iconClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                janela.dispose();
            }
        });

        iconMinimize.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                janela.setState(JFrame.ICONIFIED);
            }
        });
        this.add(iconClose);
        this.add(iconMinimize);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        executarBotao(e);
    }

    protected void executarBotao(ActionEvent e){

    }

    protected void trocarTela(String indentificadorTela){
        controleTelas.show(telas ,indentificadorTela);
    }
}
