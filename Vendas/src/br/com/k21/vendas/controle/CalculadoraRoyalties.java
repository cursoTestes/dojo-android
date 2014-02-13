package br.com.k21.vendas.controle;

import java.util.List;

import br.com.k21.vendas.ws.VendasWebService;

public class CalculadoraRoyalties {

	private CalculadoraComissao calculadoraComissao;
    private VendasWebService vendasWS;

	public CalculadoraRoyalties(VendasWebService vendasWS, CalculadoraComissao calculadoraComissao) {
		this.vendasWS = vendasWS;
		this.calculadoraComissao = calculadoraComissao;
	}

	public double calcularRoyalties(int ano, int mes) {
		List<Double> vendas = vendasWS.obterVendasPorMesEAno(ano, mes);
		double faturamento = 0d;
		
		for(Double venda : vendas) {
			faturamento += (venda - calculadoraComissao.calculaComissao(venda));			
		}
		
		return faturamento * 0.2;
	}
}
