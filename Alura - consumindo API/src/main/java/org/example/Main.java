package org.example;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();
        System.out.println("Digite sua chave de API: ");
        String chave = leitura.nextLine();
        System.out.println("Digite um filme para busca: ");
        String busca = leitura.nextLine();
        while(!busca.equalsIgnoreCase("sair")) {
            String endereco = "https://www.omdbapi.com/?t=" + busca + "&apikey=" + chave;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            try {
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();
                TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                System.out.println(meuTitulo.toString());
                titulos.add(meuTitulo);
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Digite um filme para busca: ");
            busca = leitura.nextLine();
        }
        System.out.println(titulos.toString());
        leitura.close();

        try {
            FileWriter escrita = new FileWriter("filmes.json");
            escrita.write(gson.toJson(titulos));
            escrita.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}