package br.com.k21.vendas.controle;

public class CalculadoraComissao {

	public double calculaComissao(double totalVendas){
		if(totalVendas > 10000)
			return totalVendas*0.06;
		else
			return totalVendas*0.05;
	}
	
}
