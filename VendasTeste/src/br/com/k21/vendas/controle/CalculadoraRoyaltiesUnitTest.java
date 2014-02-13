package br.com.k21.vendas.controle;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import br.com.k21.vendas.ws.VendasWebService;

// TODO nao está correto, somente exemplo
public class CalculadoraRoyaltiesUnitTest extends TestCase {

	private VendasWebService vendasWS;
	private CalculadoraComissao calculadoraComissao;

	@Override
	protected void setUp() throws Exception {
		vendasWS = mock(VendasWebService.class);
		calculadoraComissao = mock(CalculadoraComissao.class);
	}
	
	public void testParaUmMesSemVendas() {
		int mes = 1;
		int ano = 2014;
		double esperado = 0;
		
		double resultado = new CalculadoraRoyalties(vendasWS, calculadoraComissao).calcularRoyalties(mes,ano);
		
		assertEquals(esperado, resultado);
	}
	
	public void testParaUmMesComUmaVendaDe100() {
		int mes = 1;
		int ano = 2014;
		double esperado = 19;

		List<Double> vendas = new ArrayList<Double>();
		vendas.add(100d);
		when(vendasWS.obterVendasPorMesEAno(mes, ano)).thenReturn(vendas);
		
		double resultado = new CalculadoraRoyalties(vendasWS, calculadoraComissao).calcularRoyalties(mes,ano);
		
		assertEquals(esperado, resultado);
	}
}