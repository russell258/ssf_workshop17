package sg.nus.edu.iss.ssf_workshop17.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import sg.nus.edu.iss.ssf_workshop17.model.Weather;

@Service
public class WeatherService {
    
    @Value("${ssf_workshop17.open.weather.url}")
    private String openWeatherUrl;

    @Value("${ssf_workshop17.open.weather.api.key}")
    private String openWeatherApiKey;

    public Optional<Weather> getWeather(String city, String unitMeasurement) throws IOException{
        System.out.println("openWeatherUrl: "+ openWeatherUrl);
        System.out.println("openWeatherApiKey: " + openWeatherApiKey);

        //why replace the city thing??
        String weatherUrl = UriComponentsBuilder.fromUriString(openWeatherUrl)
                                                .queryParam("q", city.replaceAll(" ","+"))
                                                .queryParam("units", unitMeasurement)
                                                .queryParam("appId", openWeatherApiKey)
                                                .toUriString();
        
        //below method vs day 17 slide 6?
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> r = template.getForEntity(weatherUrl, String.class);
        Weather w = Weather.create(r.getBody());
        if (w!=null){
            return Optional.of(w);
        }
        return Optional.empty();
        
    }

}
