package com.betrybe.weatherreport;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.betrybe.weatherreport.interfaces.WeatherClient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WeatherClientTest {

  @Autowired
  WeatherClient weatherClient;

  @Test
  @DisplayName("1 - Bean para WeatherClient implementado corretamente")
  void testWeatherClientBeanIsLoaded() {
    assertNotNull(weatherClient);
  }

}
