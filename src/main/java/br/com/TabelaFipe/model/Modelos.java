package br.com.TabelaFipe.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true) //Estou mexendo apenas com os modelos nesse ponto, ainda não cheguei no "anos"
public record Modelos(List<Dados> modelos) { //Se o nome fosse diferente seria necessário o uso do Alias

}
