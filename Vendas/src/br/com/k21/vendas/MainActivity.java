package br.com.k21.vendas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import br.com.k21.vendas.controle.CalculadoraComissao;

public class MainActivity extends Activity {

	private CalculadoraComissao calculadoraComissao = new CalculadoraComissao(); 
	
	private Button calcularBtn;
	private Button configurarBtn;
	private TextView comissaoCalculadaLbl;
	private EditText totalVendasTxt;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        calcularBtn = (Button) findViewById(R.id.btn_calcular);
        configurarBtn = (Button) findViewById(R.id.btn_config);
        comissaoCalculadaLbl = (TextView) findViewById(R.id.lbl_comissaoCalculada);
        totalVendasTxt = (EditText) findViewById(R.id.txt_totalVendas);
        
        calcularBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String totalStr = totalVendasTxt.getText().toString();
				
				Double total = Double.parseDouble(totalStr);
				Double comissao = calculadoraComissao.calculaComissao(total);
				
				String comissaoFormatada = String.format("%.2f", comissao);
				
				comissaoCalculadaLbl.setText(comissaoFormatada);
			}
		});
        
        configurarBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, ConfigActivity.class));
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
