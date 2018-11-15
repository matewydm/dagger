package pl.darenie.mobiletech;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {CounterModule.class, ContextModule.class, SharedPreferencesModule.class})
public interface MyComponent {

    void inject(MainActivity mainActivity);

}
