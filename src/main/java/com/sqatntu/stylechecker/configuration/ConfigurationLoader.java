package com.sqatntu.stylechecker.configuration;

/**
 * Created by andyccs on 6/9/15.
 */
public class ConfigurationLoader {

    DefaultConfiguration configuration;

    public ConfigurationLoader() {
        configuration = new DefaultConfiguration("Default");
        configuration.addAttribute("methodName", "camelCase");
    }

    public Configuration loadConfiguration() {
        return configuration;
    }
}
