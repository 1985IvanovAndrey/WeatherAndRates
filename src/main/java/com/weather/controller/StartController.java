package com.weather.controller;

//import com.weather.dao.Weather;
import com.weather.dao.weather.WeatherDao;
import com.weather.dao.weather.WeatherDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@RequestMapping("/")
public class StartController {

    @Autowired
    private WeatherDao weather;

    private WeatherDaoImpl weat=null;

    @GetMapping
    public String getWeather(Model model) {
        model.addAttribute("weat", weat);
        return "start";
    }

    @GetMapping("getWeather")
    public String getStudentById(@RequestParam(value = "city") String city) throws IOException {
        weat = weather.getWeather(city);
        return "redirect:/";
    }
}
