package com.weather.dao.exchangeRates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
public class Exchange {

    private String nameBank;
    private Double buy;
    private Double sale;
    private String currency;

    public String getRates(String bank) throws IOException {
       Exchange exchange=new Exchange();
        URL url = new URL("https://commerc.herokuapp.com/rest/rate/usd/"+bank);
        System.out.println("Proverka="+url);
        Scanner in = new Scanner((InputStream) url.getContent());
        String result = "";
        while (in.hasNext()) {
            result += in.nextLine();
        }

        JSONObject object = new JSONObject(result);
//        exchange.setNameBank(object.getString("nameBank"));
        exchange.setBuy(object.getDouble("buy"));
        exchange.setSale(object.getDouble("sale"));
//        exchange.setCurrency(object.getString("currency"));

//        JSONObject main = object.getJSONObject("main");
//        weather.setTemp(main.getDouble("temp"));
//        weather.setHumidity(main.getDouble("humidity"));
//        JSONArray getArray = object.getJSONArray("weather");
//        for (int i = 0; i < getArray.length(); i++) {
//            JSONObject obj = getArray.getJSONObject(i);
//            weather.setIcon((String) obj.get("icon"));
//            weather.setMain((String) obj.get("main"));

        return "Покупка: " + exchange.getBuy() + "\n" +
                "Продажа: " + exchange.getSale();
//                "Main: "+getMain()+"\n"+
//                "http://openweathermap.org/img/w/" + getIcon() + ".png";
//        return weather;
    }
}
