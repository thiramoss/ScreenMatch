import br.com.thiagoramos.screenmatch.calculos.CalculadoraTempo;
import br.com.thiagoramos.screenmatch.calculos.FiltroRecomendacao;
import br.com.thiagoramos.screenmatch.modelos.Episodio;
import br.com.thiagoramos.screenmatch.modelos.Filme;
import br.com.thiagoramos.screenmatch.modelos.Serie;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Filme meuFilme = new Filme();
        meuFilme.setNome("La La Land");
        meuFilme.setAnoDeLancamento(2016);
        meuFilme.setDuracaoEmMinutos(128);
        System.out.println("Duração do filme: " + meuFilme.getDuracaoEmMinutos());

        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(8);
        meuFilme.avalia(9);
        meuFilme.avalia(10);
        System.out.println("Total de avaliações: " + meuFilme.getTotalDeAvaliacoes());
        System.out.println("Média de avaliações: " + meuFilme.pegaMedia());

        Serie lost = new Serie();
        lost.setNome("Lost");
        lost.setAnoDeLancamento(2000);
        lost.exibeFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);
        System.out.println("Duração para maratonar: " + lost.getDuracaoEmMinutos());

        CalculadoraTempo calculadora = new CalculadoraTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(lost);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtrar(meuFilme);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setTotalDeViews(300);
        filtro.filtrar(episodio);

        Filme filmeDoThiago = new Filme();
        filmeDoThiago.setNome("Pulp Fiction");
        filmeDoThiago.setDuracaoEmMinutos(200);
        filmeDoThiago.setAnoDeLancamento(1994);
        filmeDoThiago.avalia(10);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filmeDoThiago);
        listaDeFilmes.add(meuFilme);

        System.out.println("Tamanho da lista: " + listaDeFilmes.size());
        System.out.println("Primeiro filme: " + listaDeFilmes.get(0).getNome());
        System.out.println(listaDeFilmes);



    }
}