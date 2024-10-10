//①パッケージとインポート
package work;

import java.io.IOException;
import java.time.LocalTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//②サーブレットの定義
@WebServlet("/checkTemperature")
public class TemperatureServlet extends HttpServlet {

//③doメソッド定義
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String city = request.getParameter("city");

//④WeatherServiceを利用して天気情報を取得
        WeatherService weatherApi = new WeatherService();
        String apiResponse = weatherApi.getWeatherData(city);

//⑤現在の時間を取得
        LocalTime currentTime = LocalTime.now();
        int currentHour = currentTime.getHour();
           
        
        if (apiResponse != null) {
            try {
                // 天気情報を解析してオブジェクト化
                WeatherData wd = weatherApi.parseWeatherData(apiResponse);
                
                // 路面温度を計算
                int surfaceTemperature = weatherApi.calculateSurfaceTemperature(wd.getTemperature(), currentHour);
                
                // DogIconServiceを利用してアイコンを取得
                DogIconService dogIcon = new DogIconService();
                String dogIconFeel = dogIcon.getDogIcon(surfaceTemperature);
// JSPへデータを送信 
                // 現在温度から３時間おきの温度をJSPへ渡す
                request.setAttribute("weatherDescription", wd.getDescription());
                request.setAttribute("temperature", wd.getTemperature());
                request.setAttribute("afterThreeHoursTem", wd.getAfterThreeHoursTem());
                request.setAttribute("afterSixHoursTem", wd.getAfterSixHoursTem());
                
                request.setAttribute("iconUrl", wd.getWeatherIconUrl());
                request.setAttribute("dogIcon", dogIconFeel);
                // 路面温度と天気情報をリクエストに設定
                request.setAttribute("surfaceTemperature", surfaceTemperature);
                request.setAttribute("weatherData", wd);
                
            } catch (Exception e) {
            	request.setAttribute("message", "天気情報の処理中にエラーが発生しました。");
            	e.printStackTrace(); // ログとしては出力
            }
        } else {
            request.setAttribute("message", "天気情報を取得できませんでした。");
        }
        // JSPにフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
        dispatcher.forward(request, response);
    }
}

