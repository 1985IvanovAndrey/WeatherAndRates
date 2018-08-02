package com.weather.dao.exchangeRates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Repository
public class ExchangeDaoImpl implements ExchangeDao{

    private String nameBank;
    private Double buy;
    private Double sale;
    private String currency;

    @Override
    public ExchangeDaoImpl getRates(String bank) throws IOException {
        ExchangeDaoImpl exchange = new ExchangeDaoImpl();
        URL url = new URL("https://commerc.herokuapp.com/rest/rate/usd/");
        System.out.println("Proverka=" + url);
        System.out.println(bank);
        Scanner in = new Scanner((InputStream) url.getContent());
        String result = "";
        while (in.hasNext()) {
            result += in.nextLine();
        }
        System.out.println(result);

//        JSONObject object = new JSONObject(result);
//        exchange.setNameBank(object.getString("nameBank"));
//        exchange.setBuy(object.getDouble("buy"));
//        exchange.setSale(object.getDouble("sale"));
//        exchange.setCurrency(object.getString("currency"));

//        JSONObject main = object.getJSONObject("main");
//        weather.setTemp(main.getDouble("temp"));
//        weather.setHumidity(main.getDouble("humidity"));
        JSONArray getArray = new JSONArray(result);
        for (int i = 0; i < getArray.length(); i++) {
            JSONObject obj = getArray.getJSONObject(i);
            if (obj.get("nameBank").equals(bank)) {
                exchange.setNameBank((String) obj.get("nameBank"));
                exchange.setBuy((Double) obj.get("buy"));
                exchange.setSale((Double) obj.get("sale"));
                exchange.setCurrency((String) obj.get("currency"));
            }
        }
        return exchange;
//                exchange.getNameBank()+
//                "???????: " + exchange.getBuy() + "\n" +
//                "???????: " + exchange.getSale()+"\n"+
//                "??????: "+ exchange.getCurrency();
//                "Main: "+getMain()+"\n"+
//                "http://openweathermap.org/img/w/" + getIcon() + ".png";
//        return weather;
    }
}
