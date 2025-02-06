package br.edu.iftm.modelos;

import org.json.JSONObject;

public class Games {
    private String nome;
    private String caminho;
    private String icone;
    private String fundo;

    public Games(String nome, String caminho, String icone, String fundo) {
        this.nome = nome;
        this.caminho = caminho;
        this.icone = icone;
        this.fundo = fundo;
    }

    public Games(JSONObject jsonObject){
        this.nome = jsonObject.getString("nome");
        this.caminho = jsonObject.getString("caminho");
        this.icone = jsonObject.getString("icone");
        this.fundo = jsonObject.getString("fundo");

    }

    public String getName() {
        return nome;
    }

    public void setName(String name) {
        this.nome = name;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    public String getFundo() {
        return fundo;
    }

    public void setFundo(String fundo) {
        this.fundo = fundo;
    }
}
