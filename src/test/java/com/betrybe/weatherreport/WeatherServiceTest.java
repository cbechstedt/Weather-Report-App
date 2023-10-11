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
class WeatherServiceTest {

  @MockBean
  WeatherClient weatherClientMock;

  @Autowired
  WeatherService weatherService;

  @Test
  @DisplayName("2 - Bean para WeatherService implementado corretamente")
  void testWeahterServiceBean() {
    testWeatherServiceBeanIsLoaded();
    testWeatherServiceReturnsCorrectReport();
    testWeatherServiceCallsWeatherClient();
  }

  void testWeatherServiceBeanIsLoaded() {
    assertNotNull(weatherService);
  }
 
  void testWeatherServiceReturnsCorrectReport() {
    Mockito.when(weatherClientMock.getWeather(any())).thenReturn("good weather");
    
    String weather = weatherService.getWeatherReport("my city");
    assertEquals("O clima é: good weather", weather);   
  }
 
  void testWeatherServiceCallsWeatherClient() {
    weatherService.getWeatherReport("another city");
    Mockito.verify(weatherClientMock).getWeather("another city");    
  }
}
