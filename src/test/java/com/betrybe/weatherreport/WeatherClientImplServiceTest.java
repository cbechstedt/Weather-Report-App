package com.betrybe.weatherreport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

import com.betrybe.weatherreport.interfaces.WeatherClient;
import com.betrybe.weatherreport.interfaces.WeatherService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class WeatherClientImplServiceTest {

  @MockBean
  WeatherClient WeatherClientMock;

  @Autowired
  WeatherService WeatherService;

  @Test
  @DisplayName("2 - Bean para WeatherService implementado corretamente")
  void testWeahterServiceBean() {
    testWeatherServiceBeanIsLoaded();
    testWeatherServiceReturnsCorrectReport();
    testWeatherServiceCallsWeatherClient();
  }

  void testWeatherServiceBeanIsLoaded() {
    assertNotNull(WeatherService);
  }

  void testWeatherServiceReturnsCorrectReport() {
    Mockito.when(WeatherClientMock.getWeather(any())).thenReturn("good weather");

    String weather = WeatherService.getWeatherReport("my city");
    assertEquals("O clima é: good weather", weather);
  }

  void testWeatherServiceCallsWeatherClient() {
    WeatherService.getWeatherReport("another city");
    Mockito.verify(WeatherClientMock).getWeather("another city");
  }
}
