package com.weather.controller;

//import com.weather.dao.Weather;
import com.weather.dao.exchangeRates.ExchangeDao;
import com.weather.dao.exchangeRates.ExchangeDaoImpl;
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

    @Autowired
    private ExchangeDao exchange;

    private WeatherDaoImpl weat=null;
   // private Exchange exc=null;

    @GetMapping
    public String Start(Model model) {
        model.addAttribute("weat", weat);
        model.addAttribute("exchange",exchange);
        return "start";
    }

    @GetMapping("getWeather")
    public String getWeather(@RequestParam(value = "city") String city) throws IOException {
        weat = weather.getWeather(city);
        return "redirect:/";
    }
    @GetMapping("getRates")
    public String getRates(@RequestParam(value = "bank")String bank) throws IOException {
        exchange=exchange.getRates(bank);
        System.out.println(exchange);
        return "redirect:/";

    }
}
