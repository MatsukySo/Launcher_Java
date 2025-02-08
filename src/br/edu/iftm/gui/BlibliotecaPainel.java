package br.edu.iftm.gui;
import br.edu.iftm.gui.components.Botao2;
import br.edu.iftm.gui.components.Imagem;
import br.edu.iftm.modelos.Games;
import org.json.JSONArray;
import org.json.JSONObject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class BlibliotecaPainel extends TelaPanel{
    private ArrayList<Games> games;
    private JPanel grid;
    private Imagem imagemFundo;
    private Botao2 botao;
    private String cam;
    private String name;

    public BlibliotecaPainel(JPanel telas, JFrame janela){
        super(telas, janela);
         this.games = new ArrayList<Games>();
         grid = new JPanel(new FlowLayout(FlowLayout.LEFT, 22,19));
         grid.setBackground(Color.decode("#1c1d25"));

        loadingGames();
        exibirJogos();
        trocarImagemFundo("fundoValorant.png");

        JScrollPane scrollPane = new JScrollPane(grid);
        botao = new Botao2("Iniciar!", 1270, 400, 300,120, "#414450", "#ced0d6");
        botao.setFont(new Font("Arial", Font.BOLD|Font.ITALIC, 60));
        botao.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("Clicou " + cam);
                ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
                scheduler.schedule(() -> {
                    janela.dispose();
                    System.exit(0);
                }, 5, TimeUnit.SECONDS);
                executarJogo(cam);
            }
        });

        scrollPane.setBounds(10,530, 1580, 360);
        scrollPane.getHorizontalScrollBar().setUnitIncrement(40);

        this.add(scrollPane);
        this.add(imagemFundo);
        this.add(botao);
    }

    private void loadingGames(){
        String jsonString = readJsonGames();
        JSONArray jsonArray = new JSONArray(jsonString);

        for(int i = 0; i < jsonArray.length(); i++){
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            games.add(new Games(jsonObject));
        }
    }

    private void trocarImagemFundo(String imagem){
        if(imagemFundo != null) {
            remove(imagemFundo);
        }
        imagemFundo = new Imagem(imagem);
        imagemFundo.setBounds(0, 0, 1600, 900);
        add(imagemFundo);
        repaint();
        revalidate();
    }

    final Games[] Select = new Games[1];
    private void exibirJogos(){
        final boolean[] gameSelected = {false};
        int posicaoX = 5;
        int posicaoy = 60;
        final int POSITIN_MAX_X = 1380;


        for(Games game : games){
            String icone = game.getIcone();
            Imagem imagem = new Imagem(icone);
            imagem.setBounds(100,50, 300, 300);

            posicaoX += 10 + 310;
            imagem.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    String caminho = game.getCaminho();
                    cam = caminho;
                    String imagemFundo = game.getFundo();
                    trocarImagemFundo(imagemFundo);
                    gameSelected[0] = true;
                    Select[0] = game;
                }
            });

            imagem.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    if(gameSelected[0] == false) {
                        String imagemFundo = game.getFundo();
                        trocarImagemFundo(imagemFundo);
                    }
                }
            });
            grid.add(imagem);
        }
    }


    private void executarJogo(String caminho){
        File arquivo = new File(caminho);
        String pasta = arquivo.getAbsoluteFile().getParent();
        try {
            Runtime.getRuntime().exec(caminho, null, new File(pasta));
        } catch (IOException e) {
            throw new RuntimeException(e);
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