package com.weather.dao.weather;

import java.io.IOException;

public interface WeatherDao {

    WeatherDaoImpl getWeather(String city) throws IOException;

}
