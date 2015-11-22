package br.com.igrejadapaz.fortaleza.mapasdascelulas;

import br.com.igrejadapaz.fortaleza.mapasdascelulas.Bean.CelulaBean;

/**
 * Created by Samuel Santiago on 21/11/2015.
 */
public class CarregarCelulas {

    private int quantidadeCelulas = 0;

    public CarregarCelulas() {
        celulasCadastros();
    }

    public void celulasCadastros() {
        /** Cadastrar Celulas aqui!
         *  Não esquecer de implementar a quantidade de celulas
         *  Criar celulaBean obdecendo a ordem numerica
         *  TODO: parametros do construtor (String nome, String endereco, String liderNome,
         *  TODO: String telefoneInformacao, String diaHora, Double latitude, Double longitude,
         *  TODO: int semanaID, int tipoID, int redeID)
         */


        CelulaBean celula1 = new CelulaBean("Célula MDA", "Av A, nº20 - José Walter", "Samuel", "99150-5007", "Sábados as 16h", -3.82568256, -38.55116218, 7, 3, 1);
        CelulaBean celula2 = new CelulaBean("Geração Eleita", "Av Desembargador Praxedes, nº1441 - Montese", "Renata Granjeiro", "98821-7272", "Quintas as 20h", -3.7633416, -38.54193, 5, 3, 1);
        CelulaBean celula3 = new CelulaBean("Eleitos por Cristo", "Rua Prof Isaías Gomes, nº157 - Edson Queiroz", "Cezar Peixoto", "99922-3309", "Quartas as 20h", -3.7588539, -38.4808816, 4, 4, 2);
        CelulaBean celula4 = new CelulaBean("Crianças pra Cristo", "Av Desembargador Praxedes, nº1441 - Montese", "Rosemary", "98821-7272", "Quartas as 20h", -3.7633416, -38.54193, 5, 3, 1);
        quantidadeCelulas = 4;

    }
}
