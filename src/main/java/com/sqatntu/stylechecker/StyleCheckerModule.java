package com.sqatntu.stylechecker;

import com.sqatntu.stylechecker.configuration.Configuration;
import com.sqatntu.stylechecker.configuration.ConfigurationLoader;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Created by andyccs on 6/9/15.
 */
@Module(
        injects = {
                MethodListener.class,
        }
)
public class StyleCheckerModule {

    @Provides
    @Singleton
    ConfigurationLoader provideConfigurationLoader() {
        return new ConfigurationLoader();
    }

    @Provides
    @Singleton
    Configuration provideConfiguration(ConfigurationLoader configurationLoader) {
        return configurationLoader.loadConfiguration();
    }
}
