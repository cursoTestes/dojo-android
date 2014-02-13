package br.com.k21.vendas;

import br.com.k21.vendas.ws.VendasWebService;
import retrofit.RestAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class VendasActivity extends Activity {

	private Button calcularBtn;
	private EditText anoTxt;
	private EditText mesTxt;	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendas);
        
        calcularBtn = (Button) findViewById(R.id.btn_calcular);
        anoTxt = (EditText) findViewById(R.id.txt_ano);
        mesTxt = (EditText) findViewById(R.id.txt_mes);

        final VendasWebService webService = inicializarWebService();
        
        calcularBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				int ano = Integer.parseInt(anoTxt.getText().toString());
				int mes = Integer.parseInt(mesTxt.getText().toString());
				
				webService.obterVendasPorMesEAno(ano, mes);
			}
		});
	}

	private VendasWebService inicializarWebService() {
		final RestAdapter restAdapter = new RestAdapter.Builder()
										.setEndpoint("https://api.github.com")
										.build();

		return restAdapter.create(VendasWebService.class);
	}
}
