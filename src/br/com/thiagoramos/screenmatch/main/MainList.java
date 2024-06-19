package br.com.thiagoramos.screenmatch.main;

import br.com.thiagoramos.screenmatch.modelos.Filme;
import br.com.thiagoramos.screenmatch.modelos.Serie;
import br.com.thiagoramos.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;


public class MainList {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("La La Land", 2016);
        meuFilme.avalia(9);
        Filme outroFilme = new Filme("Dogville", 2003);
        outroFilme.avalia(8);
        Filme filmeDoThiago = new Filme("Pulp Fiction", 1994);
        filmeDoThiago.avalia(10);
        Serie lost = new Serie("Lost", 2000);
        lost.avalia(10);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(filmeDoThiago);
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(lost);

        Filme f1 = filmeDoThiago;

        for (Titulo item: lista) {
            System.out.println(item.getNome());
            if (item instanceof Filme filme && filme.getClassificacao() > 2) {
                System.out.println("Classificação: " + filme.getClassificacao());
            }
            //Filme filme = (Filme)item;
            //System.out.println("Classificação: " + filme.getClassificacao());
        }

        ArrayList<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Tom Cruise");
        buscaPorArtista.add("Natalie Portman");
        buscaPorArtista.add("Ashton Kutcher");

        System.out.println(buscaPorArtista);

        Collections.sort(buscaPorArtista);
        System.out.println(buscaPorArtista);

        Collections.sort(lista);
        System.out.println(lista);

    }
}
