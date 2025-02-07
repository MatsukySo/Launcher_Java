package br.edu.iftm.gui;

import br.edu.iftm.gui.components.Botao;
import br.edu.iftm.gui.components.Imagem;
import br.edu.iftm.modelos.Games;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class BlibliotecaPainel extends TelaPanel{
    private ArrayList<Games> games;
    private JPanel grid;

    public BlibliotecaPainel(JPanel telas, JFrame janela){
        super(telas, janela);
         this.games = new ArrayList<Games>();
         grid = new JPanel(new FlowLayout(FlowLayout.LEFT, 15,20));
         grid.setBackground(Color.decode("#1c1d25"));

        loadingGames();
        exibirJogos();
        JScrollPane scrollPane = new JScrollPane(grid);
        scrollPane.setBounds(5,50, 1595, 850);
        scrollPane.getVerticalScrollBar().setUnitIncrement(40);
        scrollPane.getHorizontalScrollBar().setUnitIncrement(40);

        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.add(scrollPane);
    }
    private void loadingGames(){
        String jsonString = readJsonGames();
        JSONArray jsonArray = new JSONArray(jsonString);

        for(int i = 0; i < jsonArray.length(); i++){
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            games.add(new Games(jsonObject));
        }
    }

    private void exibirJogos(){

        int posicaoX = 5;
        int posicaoy = 60;
        final int POSITIN_MAX_X = 1380;

        int alt = (games.size() / 4) * 310 + 10;
        grid.setPreferredSize(new Dimension(1550,alt + 40));

        for(Games game : games){
            String icone = game.getIcone();
            Imagem imagem = new Imagem(icone);
            imagem.setBounds(posicaoX,posicaoy,300, alt);

            posicaoX += 10 + 310;
            if(posicaoX > POSITIN_MAX_X){
                posicaoy += 320;
                posicaoX = 5;
            }
            grid.add(imagem);
        }
    }

    private String readJsonGames(){
        File fileJson = new File("Games.json");
        StringBuilder conteudoArquivo = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileJson));
            String line = reader.readLine();
            while (line != null){
               conteudoArquivo.append(line);
               line = reader.readLine();
            }

            reader.close();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return conteudoArquivo.toString();
    }

}