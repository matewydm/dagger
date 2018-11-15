package pl.darenie.mobiletech;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public class MyApp extends Application {

    private MyComponent myComponent;
    private static MyApp app;

    public static MyApp app() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        myComponent = DaggerMyComponent
                .builder()
                .counterModule(new CounterModule())
                .contextModule(new ContextModule(getApplicationContext()))
                .sharedPreferencesModule(new SharedPreferencesModule())
                .build();
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("PrefName",Context.MODE_PRIVATE);
        sharedPreferences.edit().putLong("max",10L).apply();
        sharedPreferences.edit().putLong("min",-10L).apply();
    }

    public MyComponent getMyComponent() {
        return myComponent;
    }
}
