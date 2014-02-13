package br.com.k21.vendas;

import br.com.k21.vendas.framework.SharedResourceActivityUnitTest;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences.Editor;

public class StartActivityUnitTest extends SharedResourceActivityUnitTest<StartActivity> {
	
	public StartActivityUnitTest() {
		super(StartActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		limparSharedPreference();
	}

	private Activity iniciarActivity() {
		Intent intent = new Intent(getInstrumentation().getTargetContext(), MainActivity.class);
		startActivity(intent, null, null);
		return getActivity();
	}
	
	public void testExisteToken_RedirecionarParaMain() {
		Editor editor = prefs.edit();
		editor.putString("token", "123abc");
		editor.commit();
		
		iniciarActivity();
		
		Intent intent = getStartedActivityIntent();
		assertEquals(".MainActivity", intent.getComponent().getShortClassName());
	}
	
	public void testNaoExisteToken_RedirecionarParaLogin() {
		iniciarActivity();
		
		Intent intent = getStartedActivityIntent();
		assertEquals(".LoginActivity", intent.getComponent().getShortClassName());
	}
}
