package com.betrybe.weatherreport.Component;

import com.betrybe.weatherreport.interfaces.WeatherClient;
import com.betrybe.weatherreport.interfaces.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WeatherServiceImpl implements WeatherService {

  private final WeatherClient weatherClient;

  @Autowired
  public WeatherServiceImpl(WeatherClient weatherClient) {
    this.weatherClient = weatherClient;
  }

  /**
   * Javadoc.
   */
  @Override
  public String getWeatherReport(String city) {
    return "O clima é: " + weatherClient.getWeather(city);
  }
}
