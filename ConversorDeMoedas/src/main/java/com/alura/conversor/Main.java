package com.alura.conversor;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Sua chave da API
        String chaveApi = "8f81a819029929dbabb99cba"; 
        String endereco = "https://v6.exchangerate-api.com/v6/" + chaveApi + "/latest/USD";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        String jsonResponse = "";
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            jsonResponse = response.body();

        } catch (IOException | InterruptedException e) {
            System.out.println("Ocorreu um erro ao conectar à API: " + e.getMessage());
            return; 
        }

        Gson gson = new Gson();
        ExchangeRateResponse taxasDeCambio = gson.fromJson(jsonResponse, ExchangeRateResponse.class);
        
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 7) {
            System.out.println("\n***************************************************");
            System.out.println("Seja bem-vindo(a) ao Conversor de Moeda :)");
            System.out.println("1) Dólar Americano (USD) >> Real Brasileiro (BRL)");
            System.out.println("2) Real Brasileiro (BRL) >> Dólar Americano (USD)");
            System.out.println("3) Dólar Americano (USD) >> Peso Argentino (ARS)");
            System.out.println("4) Peso Argentino (ARS) >> Dólar Americano (USD)");
            System.out.println("5) Dólar Americano (USD) >> Peso Colombiano (COP)");
            System.out.println("6) Peso Colombiano (COP) >> Dólar Americano (USD)");
            System.out.println("7) Sair");
            System.out.println("***************************************************");

            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                double valor;
                double taxa;
                double valorConvertido;

                switch (opcao) {
                    case 1:
                        System.out.print("Digite o valor em USD a ser convertido para BRL: ");
                        valor = scanner.nextDouble();
                        taxa = taxasDeCambio.getConversionRates().get("BRL");
                        valorConvertido = valor * taxa;
                        System.out.printf("O valor de %.2f USD corresponde a %.2f BRL\n", valor, valorConvertido);
                        break;
                    case 2:
                        System.out.print("Digite o valor em BRL a ser convertido para USD: ");
                        valor = scanner.nextDouble();
                        taxa = taxasDeCambio.getConversionRates().get("BRL");
                        valorConvertido = valor / taxa;
                        System.out.printf("O valor de %.2f BRL corresponde a %.2f USD\n", valor, valorConvertido);
                        break;
                    case 3:
                        System.out.print("Digite o valor em USD a ser convertido para ARS: ");
                        valor = scanner.nextDouble();
                        taxa = taxasDeCambio.getConversionRates().get("ARS");
                        valorConvertido = valor * taxa;
                        System.out.printf("O valor de %.2f USD corresponde a %.2f ARS\n", valor, valorConvertido);
                        break;
                    case 4:
                        System.out.print("Digite o valor em ARS a ser convertido para USD: ");
                        valor = scanner.nextDouble();
                        taxa = taxasDeCambio.getConversionRates().get("ARS");
                        valorConvertido = valor / taxa;
                        System.out.printf("O valor de %.2f ARS corresponde a %.2f USD\n", valor, valorConvertido);
                        break;
                    case 5:
                        System.out.print("Digite o valor em USD a ser convertido para COP: ");
                        valor = scanner.nextDouble();
                        taxa = taxasDeCambio.getConversionRates().get("COP");
                        valorConvertido = valor * taxa;
                        System.out.printf("O valor de %.2f USD corresponde a %.2f COP\n", valor, valorConvertido);
                        break;
                    case 6:
                        System.out.print("Digite o valor em COP a ser convertido para USD: ");
                        valor = scanner.nextDouble();
                        taxa = taxasDeCambio.getConversionRates().get("COP");
                        valorConvertido = valor / taxa;
                        System.out.printf("O valor de %.2f COP corresponde a %.2f USD\n", valor, valorConvertido);
                        break;
                    case 7:
                        System.out.println("Saindo do conversor. Até logo!");
                        break;
                    default:
                        System.out.println("Opção inválida. Por favor, escolha uma opção entre 1 e 7.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.next(); 
            }
        }
        scanner.close();
    }
}