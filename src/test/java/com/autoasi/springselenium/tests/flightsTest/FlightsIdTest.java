package com.autoasi.springselenium.tests.flightsTest;

import org.springframework.test.context.TestPropertySource;

@TestPropertySource(properties = "app.language=id") // runs the flightsTest with id language
public class FlightsIdTest extends FlightsTest{
}
