package br.com.k21.vendas.ws;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;

public interface VendasWebService {

	@GET("/vendas/{ano}/{mes}")
	public List<Double> obterVendasPorMesEAno(@Path("ano") int ano, @Path("mes") int mes);
	
}
