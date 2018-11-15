package pl.darenie.mobiletech;

import dagger.Module;
import dagger.Provides;

@Module
public class CounterModule {

    @Provides
    public CounterService provideCounterService(){
        return new CounterService();
    }

}
