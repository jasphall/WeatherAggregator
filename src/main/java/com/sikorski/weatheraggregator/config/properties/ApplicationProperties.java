package com.sikorski.weatheraggregator.config.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ApplicationProperties implements ConfigurationProperties {

    @Autowired
    private Environment environment;

    public String getOwmApiKey() {
        return environment.getProperty("owm_api_key");
    }

    public String getOwmLocation() {
        return environment.getProperty("current_location");
    }

    public String getCsvExportFilename() {
        return environment.getProperty("export_csv_filename");
    }
}
