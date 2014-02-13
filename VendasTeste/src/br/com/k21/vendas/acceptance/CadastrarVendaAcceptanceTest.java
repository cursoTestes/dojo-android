package br.com.k21.vendas.acceptance;

import static br.com.k21.vendas.framework.SharedPreferenceUtils.limparSharedPreference;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import android.widget.EditText;
import br.com.k21.vendas.LoginActivity;
import br.com.k21.vendas.MainActivity;
import br.com.k21.vendas.R;
import br.com.k21.vendas.StartActivity;
import br.com.k21.vendas.framework.RobotiumTestCase;
import br.com.k21.vendas.ws.TokenWebService;

public class CadastrarVendaAcceptanceTest extends RobotiumTestCase<StartActivity> {

	public CadastrarVendaAcceptanceTest() {
		super(StartActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		limparSharedPreference(prefs);
	}
	
	public void testVendedorNaoEstavaLogadoPreviamente() {
		getActivity();
		
		TokenWebService tws = mock(TokenWebService.class);
		when(tws.login("123", "123")).thenReturn("123abc");
		
		solo.assertCurrentActivity("Nao abriu a LoginActivity", LoginActivity.class);
		
		LoginActivity loginActivity = (LoginActivity) solo.getCurrentActivity();
		loginActivity.setTokenWebService(tws);
		
		EditText loginTxt = (EditText) solo.getView(R.id.txt_login);
		EditText passTxt = (EditText) solo.getView(R.id.txt_senha);
		
		solo.enterText(loginTxt, "123");
		solo.enterText(passTxt, "123");
		
		solo.clickOnButton("Login");
		
		solo.assertCurrentActivity("Nao consegui efetuar logins", MainActivity.class);
		
		assertTrue(solo.searchText("Total de vendas"));
	}

}
