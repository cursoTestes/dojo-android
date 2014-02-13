package br.com.k21.vendas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import br.com.k21.vendas.ws.TokenWebService;

public class LoginActivity extends Activity {

	private TokenWebService tokenWebService;
	
	private EditText loginTxt;
	private EditText passTxt;
	private Button loginBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		final SharedPreferences prefs = this.getSharedPreferences("prefs", Context.MODE_PRIVATE);
		
		loginBtn = (Button) findViewById(R.id.btn_logar);
		loginTxt = (EditText) findViewById(R.id.txt_login);
		passTxt = (EditText) findViewById(R.id.txt_senha);
		
		loginBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				String token = tokenWebService.login(loginTxt.getText().toString(), passTxt.getText().toString());
				
				if (token != null && !token.equals("")) {
					Intent intent = new Intent(LoginActivity.this, MainActivity.class);
					intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

					startActivity(intent);
					
					Editor editor = prefs.edit();
					editor.putString("token", token);
					editor.commit();
				}
			}
		});
	}

	public void setTokenWebService(TokenWebService tokenWebService) {
		this.tokenWebService = tokenWebService;
	}
	
}
