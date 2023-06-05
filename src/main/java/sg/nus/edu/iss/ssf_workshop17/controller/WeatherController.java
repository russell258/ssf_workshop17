package sg.nus.edu.iss.ssf_workshop17.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.nus.edu.iss.ssf_workshop17.service.WeatherService;

@Controller
@RequestMapping(path="/weather")
public class WeatherController {
    // @Autowired
    // private WeatherService wSvc;

}
