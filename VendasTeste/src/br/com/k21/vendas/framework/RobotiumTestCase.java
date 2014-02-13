package br.com.k21.vendas.framework;

import com.robotium.solo.Solo;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.test.ActivityInstrumentationTestCase2;

public abstract class RobotiumTestCase<T extends Activity> extends ActivityInstrumentationTestCase2<T> {

	protected Solo solo;
	protected SharedPreferences prefs;
	
	public RobotiumTestCase(Class<T> activityClass) {
		super(activityClass);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		solo = new Solo(getInstrumentation());
		prefs = getInstrumentation().getTargetContext().getSharedPreferences("prefs", Context.MODE_PRIVATE);
		System.setProperty( "dexmaker.dexcache", getInstrumentation().getTargetContext().getCacheDir().getPath() );
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		
		solo.finishOpenedActivities();
	}
}
