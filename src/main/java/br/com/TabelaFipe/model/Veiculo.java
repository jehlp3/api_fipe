package br.com.TabelaFipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Veiculo(
        //https://parallelum.com.br/fipe/api/v1/carros/marcas/59/modelos/5940/anos/2014-3
//{
//    "TipoVeiculo": 1,
//            "Valor": "R$ 97.703,00",
//            "Marca": "VW - VolksWagen",
//            "Modelo": "AMAROK High.CD 2.0 16V TDI 4x4 Dies. Aut",
//            "AnoModelo": 2014,
//            "Combustivel": "Diesel",
//            "CodigoFipe": "005340-6",
//            "MesReferencia": "dezembro de 2024",
//            "SiglaCombustivel": "D"
//}
        @JsonAlias("Valor") String valor, //Necessário o Alias pois os nomes são diferentes
        @JsonAlias("Marca") String marca,
        @JsonAlias("Modelo") String modelo,
        @JsonAlias("AnoModelo") Integer ano,
        @JsonAlias("Combustivel") String tipoCombustivel


) {
}
