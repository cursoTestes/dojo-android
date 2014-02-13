package br.com.k21.vendas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.test.ActivityUnitTestCase;

public class StartActivityUnitTest extends ActivityUnitTestCase<StartActivity> {
	
	private SharedPreferences prefs;

	public StartActivityUnitTest() {
		super(StartActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		prefs = getInstrumentation().getTargetContext().getSharedPreferences("prefs", Context.MODE_PRIVATE);
		
		Editor editor = prefs.edit();
		editor.clear();
		editor.commit();
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
