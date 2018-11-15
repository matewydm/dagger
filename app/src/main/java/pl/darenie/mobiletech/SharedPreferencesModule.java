package pl.darenie.mobiletech;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class SharedPreferencesModule {

    @Singleton
    @Provides
    @Inject
    public SharedPreferences provideSharedPreferences(Context context) {
        return context.getSharedPreferences("PrefName",Context.MODE_PRIVATE);
    }

}
