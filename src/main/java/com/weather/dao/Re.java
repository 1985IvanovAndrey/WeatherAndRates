package com.weather.dao;

import com.weather.dao.exchangeRates.Exchange;

import java.io.IOException;
import java.nio.charset.Charset;

public class Re {
    public static void main(String[] args) throws IOException {
        Exchange exchange=new Exchange();
        System.setProperty("file.encoding", "UTF-8");
        String text="Ощадбанк";
        System.out.println(exchange.getRates(text));
    }
}
