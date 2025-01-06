package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a sua chave:");
        String chave = scanner.nextLine();
        String endereco = "https://v6.exchangerate-api.com/v6/" + chave + "/latest/USD" ;
        Gson gson = new Gson();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String conversionRatesJson = gson.fromJson(response.body(), JsonObject.class)
                    .getAsJsonObject("conversion_rates")
                    .toString();
            Cotacoes cotacoes = gson.fromJson(conversionRatesJson, Cotacoes.class);

            while(true){
                int tipoConversao = 0;
                System.out.println("""
                *******************************************************************************************
                Seja Bem-vindo/a ao Conversor de Moeda =]

                1)  Dólar ==>> Peso argentino
                2)  Peso argentino ==>> Dólar
                3)  Dólar ==>> Real brasileiro
                4)  Real brasileiro ==>> Dólar
                5)  Dólar ==>> Peso Colombiano
                6)  Peso colombiano ==>> Dólar
                7)  Sair
                Escolha uma opção válida:
                *******************************************************************************************
                """);
                do {
                    tipoConversao = scanner.nextInt();
                } while(tipoConversao<1||tipoConversao>7);
                System.out.println("Digite o valor que deseja converter:");
                Double valor = scanner.nextDouble();

                switch (tipoConversao){
                    case 1:
                        System.out.println(cotacoes.dolarPesoArgentino(valor));
                        break;
                    case 2:
                        System.out.println(cotacoes.pesoArgentinoDolar(valor));
                        break;
                    case 3:
                        System.out.println(cotacoes.dolarReal(valor));
                        break;
                    case 4:
                        System.out.println(cotacoes.realDolar(valor));
                        break;
                    case 5:
                        System.out.println(cotacoes.dolarPesoColombiano(valor));
                        break;
                    case 6:
                        System.out.println( cotacoes.pesoColombianoDolar(valor));
                        break;
                    case 7:
                        break;
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}