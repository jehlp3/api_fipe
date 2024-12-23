package br.com.TabelaFipe.principal;

import br.com.TabelaFipe.model.Dados;
import br.com.TabelaFipe.model.Modelos;
import br.com.TabelaFipe.service.ConsumoApi;
import br.com.TabelaFipe.service.ConverteDados;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {

    private Scanner sc = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
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
        //System.out.println(json);
        var marcas  = conversor.obterLista(json, Dados.class);
        marcas.stream()
                .sorted(Comparator.comparing(Dados::nome)) //ordena pelo nome
                //.sorted(Comparator.comparing(d -> Integer.parseInt(d.codigo())))
                //.sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        System.out.println("Digite o código da marca para consulta: ");
        var codMarca = sc.nextLine();
        endereco = endereco+"/"+codMarca+"/modelos";
        json = consumo.obterDados(endereco);
        //System.out.println(json);
        var modeloLista  = conversor.obterDados(json, Modelos.class);
        System.out.println("Modelos desta marca");
        modeloLista.modelos().stream()
                .sorted(Comparator.comparing(Dados::nome))
                .forEach(System.out::println);

        System.out.println("Digite um trecho do veículo a ser buscado");
        var nomeVeiculo = sc.nextLine();

        List<Dados> modelosFiltrados = modeloLista.modelos().stream()
                .filter(m -> m.nome().toLowerCase().contains(nomeVeiculo.toLowerCase()))
                .collect(Collectors.toList());
        System.out.println("Modelos filtrados: ");
        modelosFiltrados.forEach(System.out::println);

        System.out.println("Digite o código do modelo para buscar os valores por avaliação");

    }
}
