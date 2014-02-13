package br.com.k21.vendas.framework;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.test.ActivityUnitTestCase;

public abstract class SharedResourceActivityUnitTest<T extends Activity> extends ActivityUnitTestCase<T> {

	protected SharedPreferences prefs;

	public SharedResourceActivityUnitTest(Class<T> activityClass) {
		super(activityClass);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		prefs = getInstrumentation().getTargetContext().getSharedPreferences("prefs", Context.MODE_PRIVATE);
	}

}
