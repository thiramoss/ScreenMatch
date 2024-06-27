package br.com.thiagoramos.screenmatch.main;

import br.com.thiagoramos.screenmatch.excecao.ErroDeConversaoDeAnoException;
import br.com.thiagoramos.screenmatch.modelos.Titulo;
import br.com.thiagoramos.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class MainBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite um filme para busca: ");
        var busca = leitura.nextLine();

        String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=10e073f4";
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            System.out.println(json);


            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
            TituloOmdb meuTituloOdmb = gson.fromJson(json, TituloOmdb.class);

            Titulo meuTitulo = new Titulo(meuTituloOdmb);
            System.out.println("Titulo convertido");
            System.out.println(meuTitulo);
        } catch (NumberFormatException e){
            System.out.println("Ocorreu um erro");
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e ) {
            System.out.println("O argumento foi inválido");
        } catch (ErroDeConversaoDeAnoException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Programa finalizado corretamente");
    }
}
