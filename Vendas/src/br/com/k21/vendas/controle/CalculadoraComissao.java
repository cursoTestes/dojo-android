package br.com.k21.vendas.controle;

public class CalculadoraComissao {

	public double calculaComissao(double totalVendas) {
		double calculado = 0.0;
		
		if (totalVendas <= 10000) {
			calculado = totalVendas * 5 / 100;
		} else {
			calculado = totalVendas * 6 / 100;
		}
		
		return Math.floor(calculado * 100) / 100;
	}
	
}
