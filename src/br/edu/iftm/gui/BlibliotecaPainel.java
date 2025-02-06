package br.edu.iftm.gui;

import br.edu.iftm.gui.components.Botao;
import br.edu.iftm.modelos.Games;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;

import static br.edu.iftm.gui.Janela.screenSize;

public class BlibliotecaPainel extends TelaPanel{
    private ArrayList<Games> games;
    private Botao botaoPrincipal;

    public BlibliotecaPainel(JPanel telas, JFrame janela){
        super(telas, janela);
         this.games = new ArrayList<Games>();


        botaoPrincipal = new Botao("Deslogar", (int)screenSize().getWidth() -117, (int)screenSize().getHeight() -50, 100, 30);
        botaoPrincipal.addActionListener(this);

        this.add(botaoPrincipal);
        loadingGames();
    }
    private void loadingGames(){
        String jsonString = readJsonGames();
        JSONArray jsonArray = new JSONArray(jsonString);

        for(int i = 0; i < jsonArray.length(); i++){
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);


            games.add(new Games(jsonObject));
        }
        for(Games game : games){
            System.out.println(game.getIcone());
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

    public void executarBotao(ActionEvent e){
        trocarTela("Tela Login");
    }
}
