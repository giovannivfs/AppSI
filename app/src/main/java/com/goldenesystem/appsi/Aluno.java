package com.goldenesystem.appsi;

/**
 * Classe utilizada para gerar o tipo aluno com as informações necessarias para exibição na tela sobre
 */

public class Aluno {
    private  String nome;
    private String ra;
    private int image;

    public Aluno(String nome, String ra, int image) {
        this.nome = nome;
        this.ra = ra;
        this.image = image;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
