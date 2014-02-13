package br.com.k21.vendas;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import br.com.k21.vendas.framework.SharedPreferenceUtils;
import br.com.k21.vendas.framework.SharedResourceActivityUnitTest;

public class StartActivityUnitTest extends SharedResourceActivityUnitTest<StartActivity> {
	
	public StartActivityUnitTest() {
		super(StartActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	private Activity iniciarActivity() {
		Intent intent = new Intent(getInstrumentation().getTargetContext(), StartActivity.class);
		startActivity(intent, null, null);
		return getActivity();
	}
	
	public void testVendedorNaoLogadoDeveExibirTelaDeLogin() {
		SharedPreferenceUtils.limparSharedPreference(prefs);
		String esperado = LoginActivity.class.getName();
		
		iniciarActivity();
		String resultado = getStartedActivityIntent().getComponent().getClassName();
		assertEquals("Wrong activity started", esperado, resultado);
	}
	
	public void testVendedorLogadoNaoDeveExibirTelaDeLogin() {
		SharedPreferenceUtils.limparSharedPreference(prefs);
		Editor editor = prefs.edit();
		editor.putString("token", "teste");
		editor.commit();
		
		String esperado = MainActivity.class.getName();
		
		iniciarActivity();
		String resultado = getStartedActivityIntent().getComponent().getClassName();
		assertEquals("Wrong activity started", esperado, resultado);
	}
	
	
}
