package br.com.k21.vendas.framework;

import android.test.InstrumentationTestCase;

public class BaseTestCase extends InstrumentationTestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		System.setProperty( "dexmaker.dexcache", getInstrumentation().getTargetContext().getCacheDir().getPath() );
	}
}
