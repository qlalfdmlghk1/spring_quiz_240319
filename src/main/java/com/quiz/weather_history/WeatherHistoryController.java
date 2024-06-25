package com.quiz.weather_history;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/lesson05")
@Controller
public class WeatherHistoryController {
	
	@GetMapping("/quiz04")
	public String quiz04() {
		return "weather_history/weatherList";
	}
	
	@RequestMapping(path="/add-weather-view", method = RequestMethod.GET)
	public String addWeatherView() {
		return "weather_history/addWeather";
	}
	
	@RequestMapping(path="/weather-list-view", method = RequestMethod.GET)
	public String weatherListView() {
		return "weather_history/weatherList";
	}
}
