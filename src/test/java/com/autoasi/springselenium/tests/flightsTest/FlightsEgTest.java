package com.autoasi.springselenium.tests.flightsTest;

import org.springframework.test.context.TestPropertySource;

@TestPropertySource(properties = "app.language=en") // runs the flightsTest with eg language
public class FlightsEgTest extends FlightsTest{
}
