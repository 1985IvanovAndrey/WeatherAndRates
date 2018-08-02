package com.weather.dao;

import com.weather.dao.exchangeRates.ExchangeDaoImpl;

import java.io.IOException;

public class Re {
    public static void main(String[] args) throws IOException {
        ExchangeDaoImpl exchange = new ExchangeDaoImpl();
        String text = "Ощадбанк";
        System.out.println(exchange.getRates(text));
    }
}
