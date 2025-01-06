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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        FileWriter escrita = null;
        try {
            escrita = new FileWriter("filmes.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Digite um filme para busca: ");
        String busca = leitura.nextLine();
        while(!busca.equalsIgnoreCase("sair")) {
            String endereco = "https://www.omdbapi.com/?t=" + busca + "&apikey=933fcca4";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            try {
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();
                Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
                TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                escrita.write(meuTitulo.toString() + "\n");
                System.out.println(meuTitulo.toString());

            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Digite um filme para busca: ");
            busca = leitura.nextLine();
        }
        leitura.close();
        try {
            escrita.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}