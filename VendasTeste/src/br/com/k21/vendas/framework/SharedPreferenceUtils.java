package br.com.k21.vendas.framework;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharedPreferenceUtils {
	
	public static void limparSharedPreference(SharedPreferences prefs) {
		Editor editor = prefs.edit();
		editor.clear();
		editor.commit();
	}
}
