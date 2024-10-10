package work;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

public class WeatherService {
  private SurfaceTemperature calculation;
    // 天気情報を取得するメソッド
    public String getWeatherData(String city) throws IOException {
        String apiKey 	 = "23c3719b855315973ca5e2057a352ef6"; // APIキー
        String urlString = "http://api.openweathermap.org/data/2.5/forecast?q=" + city + "&appid=" + apiKey + "&units=metric&lang=ja";
        
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        int responseCode = conn.getResponseCode();
        if (responseCode == 200) {
            StringBuilder inline = new StringBuilder();
            try (Scanner scanner = new Scanner(url.openStream())) {
            
	            while (scanner.hasNext()) {
	                inline.append(scanner.nextLine());
	            }
	            scanner.close();
            }
            return inline.toString();
        } else {
            return null;
        }
    }
    

    // 1時間後や2時間後の温度も解析
    public WeatherData parseWeatherData(String apiResponse) throws Exception {
        JSONObject json = new JSONObject(apiResponse);

        // 現在の天気
        JSONObject currentWeather = json.getJSONArray("list").getJSONObject(0);
        String description = currentWeather.getJSONArray("weather").getJSONObject(0).getString("description");
        int temperature = currentWeather.getJSONObject("main").getInt("temp");
        String icon = currentWeather.getJSONArray("weather").getJSONObject(0).getString("icon");

        // 3時間後の天気
        JSONObject afterThreeHours = json.getJSONArray("list").getJSONObject(1); //3時間後
        int afterThreeHoursTem = afterThreeHours.getJSONObject("main").getInt("temp");
        JSONObject afterSixHours = json.getJSONArray("list").getJSONObject(2); //6時間後
        int afterSixHoursTem = afterSixHours.getJSONObject("main").getInt("temp");
       
        String weatherIconUrl = "http://openweathermap.org/img/wn/" + icon + "@2x.png";

        System.out.println("API Response: " + apiResponse);
        
        // WeatherDataに３時間おきの温度も追加
        return new WeatherData(description, temperature, afterThreeHoursTem, afterSixHoursTem, weatherIconUrl);
    }
    
    
    
    public WeatherService() {
    	calculation = new SurfaceTemperature(); // 新しいクラスをインスタンス化
    }

    /// 気温に基づいて路面温度を計算
    public int calculateSurfaceTemperature(int temperature, int hour) {
        int correction = calculation.surfaceTemperatureEachTimeAndSeason(hour); // 新しいクラスを使って補正値を取得
        return temperature + correction;
    }
    
}
