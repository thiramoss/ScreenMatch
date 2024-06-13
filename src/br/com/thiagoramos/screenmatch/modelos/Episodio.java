package br.com.thiagoramos.screenmatch.modelos;

import br.com.thiagoramos.screenmatch.calculos.Classificavel;

public class Episodio implements Classificavel {
    private int numero;
    private String nome;
    private Serie serie;
    private int totalDeViews;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public void setTotalDeViews(int totalDeViews) {
        this.totalDeViews = totalDeViews;
    }


    @Override
    public int getClassificacao() {
        if(totalDeViews > 100){
            return 4;
        } else {
            return 2;
        }
    }
}
