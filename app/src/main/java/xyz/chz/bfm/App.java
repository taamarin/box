package xyz.chz.bfm;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.SharedPreferences;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import xyz.chz.bfm.util.theme.ThemeUtil;
import rikka.material.app.DayNightDelegate;

public class App extends Application {
    @SuppressLint("StaticFieldLeak")
    public static final String TAG = "BoxForMagiskManager";

    private static App instance = null;
    private SharedPreferences pref;

    public static App getInstance() {
        return instance;
    }

    public static SharedPreferences getPreferences() {
        return instance.pref;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy =
                    new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        instance = this;
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        DayNightDelegate.setApplicationContext(this);
        DayNightDelegate.setDefaultNightMode(ThemeUtil.getDarkTheme());
    }
}
