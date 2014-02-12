package br.com.k21.vendas;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivityUnitTest extends ActivityUnitTestCase<MainActivity> {

	private MainActivity activity;
	
	public MainActivityUnitTest() {
		super(MainActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		Intent intent = new Intent(getInstrumentation().getTargetContext(), MainActivity.class);
		startActivity(intent, null, null);
		activity = getActivity();
	}
	
	public void testDeveComecarComNaoCalculado() {
		TextView comissaoCalculadaLbl = (TextView) activity.findViewById(R.id.lbl_comissaoCalculada);
		assertEquals(getInstrumentation().getTargetContext().getResources().getString(R.string.nao_calculada), comissaoCalculadaLbl.getText());
	}
	
	public void testInserirTotalVendas100ECalcular() {
		EditText totalVendasTxt = (EditText) activity.findViewById(R.id.txt_totalVendas);
		totalVendasTxt.setText("100.00");
		
		Button calcularBtn = (Button) activity.findViewById(R.id.btn_calcular);
		calcularBtn.performClick();
		
		TextView comissaoCalculadaLbl = (TextView) activity.findViewById(R.id.lbl_comissaoCalculada);
		assertEquals("5.00", comissaoCalculadaLbl.getText());
	}
	
	public void testClicarEmConfigurarDeveAbrirConfiguracao() {
		Button configBtn = (Button) activity.findViewById(R.id.btn_config);
		configBtn.performClick();
		
		Intent intent = getStartedActivityIntent();
		assertEquals(".ConfigActivity", intent.getComponent().getShortClassName());
	}
	
	public void testFoo() {
		assertFalse(true);
	}

}
