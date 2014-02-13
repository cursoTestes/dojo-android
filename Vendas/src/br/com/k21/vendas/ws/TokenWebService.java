package br.com.k21.vendas.ws;

import retrofit.http.POST;
import retrofit.http.Path;

public interface TokenWebService {

	@POST("/login/{login}/{password}")
	public void login(@Path("login") String login, @Path("password") String password);
}
