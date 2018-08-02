package com.weather.dao.exchangeRates;

import java.io.IOException;

public interface ExchangeDao {

    ExchangeDaoImpl getRates(String bank) throws IOException;;

}
