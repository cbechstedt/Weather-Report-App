package com.betrybe.weatherreport;

import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Spring Boot application class.
 */
@SpringBootApplication
public class WeatherReportApplication {

  /**
   * Main method.
   */
  public static void main(String[] args) {
    final ConfigurableApplicationContext context;
    context = new SpringApplicationBuilder(WeatherReportApplication.class)
        .web(WebApplicationType.NONE)
        .logStartupInfo(false)
        .bannerMode(Banner.Mode.OFF)
        .run(args);

    final WeatherReportMain main = context.getBean(WeatherReportMain.class);
    main.run(args);
  }
}
