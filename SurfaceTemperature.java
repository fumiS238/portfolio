package work;

import java.time.LocalDate;

public class SurfaceTemperature {

	// 季節を取得するメソッド
    public String getSeason() {
        int month = LocalDate.now().getMonthValue();
        if (month >= 3 && month <= 5) {
            return "春";  // 3月～5月
        } else if (month >= 6 && month <= 9) {
            return "夏";  // 6月～8月
        } else if (month >= 10 && month <= 11) {
            return "秋";  // 9月～11月
        } else {
            return "冬";  // 12月～2月
        }
    }
        
     // 季節と時間帯に応じた補正温度を返すメソッド
        public int surfaceTemperatureEachTimeAndSeason(int hour) {
            String season = getSeason();

            switch (season) {
                case "春":
                case "秋":
                    if (hour >= 12 && hour < 15) {
                        return 5;
                    } else {
                        return 0;
                    }

                case "夏":
                    if (hour >= 9 && hour < 12) {
                        return 10;
                    } else if (hour >= 12 && hour < 15) {
                        return 20;
                    } else if (hour >= 15 && hour < 18) {
                        return 10;
                    } else {
                        return 5;
                    }


                case "冬":
                    if (hour >= 12 && hour < 15) {
                        return 0;
                    } else {
                        return -5;
                    }

                default:
                    return 0;
            }
        
    }
	
}
