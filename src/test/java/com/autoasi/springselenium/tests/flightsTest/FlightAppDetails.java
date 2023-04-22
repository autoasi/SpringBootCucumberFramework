package com.autoasi.springselenium.tests.flightsTest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@PropertySource("language/${app.language:en}.properties") // it tells spring to read the @Value from the en.properties file
public class FlightAppDetails {

    @Value("${flight.app.url}")
    private String url;

    @Value("${flight.app.labels}")
    private List<String> labels;

    public String getUrl() {
        return url;
    }

    public List<String> getLabels() {
        return labels;
    }
}
