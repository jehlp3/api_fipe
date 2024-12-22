package br.com.TabelaFipe.principal;

import br.com.TabelaFipe.service.ConsumoApi;

import java.util.Scanner;

public class Principal {

    private Scanner sc = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";

    public void exibeMenu(){
       var menu = """
                ***OPÇÕES***
                Carro
                Moto
                Caminhão
                
                Digite uma das opções para consultar:
                """;
        System.out.println(menu);

        var opcao = sc.nextLine().toLowerCase();
        String endereco;
        if (opcao.contains("carr")) {
            endereco = URL_BASE + "carros/marcas";
        } else if (opcao.contains("mot")) {
            endereco = URL_BASE + "motos/marcas";
        } else {
            endereco = URL_BASE + "caminhos/marcas";
        }

        var json = consumo.obterDados(endereco);
        System.out.println(json);
    }
}
