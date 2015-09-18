package lt.segfoltas.crashrepro;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

public class ReproApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }
}
