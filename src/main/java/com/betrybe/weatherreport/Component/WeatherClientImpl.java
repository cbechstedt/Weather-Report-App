package com.betrybe.weatherreport.Component;

import com.betrybe.weatherreport.interfaces.WeatherClient;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;

/**
 * Javadoc.
 */
@RestController
public class WeatherClientImpl implements WeatherClient {

  @Override
  public String getWeather(String city) {
    RestTemplate restTemplate = new RestTemplate();

    String apiKey = "9305e1bd07d14a3e824195523232610";
    String url = String.format("http://api.weatherapi.com/v1/current.json?key=%s&q=%s&aqi=no",
        apiKey, city);

    ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
    String jsonResponse = response.getBody();

    return extractWeatherDescription(jsonResponse);
  }

  private String extractWeatherDescription(String jsonResponse) {
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      JsonNode jsonNode = objectMapper.readTree(jsonResponse);
      return jsonNode.at("/current/condition/text").asText();
    } catch (IOException e) {
      e.printStackTrace();
      return "Erro ao obter o clima";
    }
  }
}
