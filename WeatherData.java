package work;

public class WeatherData {
    private String description;
    private int temperature;
    private int afterThreeHoursTem;
    private int afterSixHoursTem;
    private String weatherIconUrl;

    public WeatherData(String description, int temperature, int afterThreeHoursTem, int afterSixHoursTem, String weatherIconUrl) {
        this.description = description;
        this.temperature = temperature;
        this.afterThreeHoursTem = afterThreeHoursTem;
        this.afterSixHoursTem = afterSixHoursTem;
        this.weatherIconUrl = weatherIconUrl;
    }

    public String getDescription() {
        return description;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getAfterThreeHoursTem() {
        return afterThreeHoursTem;
    }

    public int getAfterSixHoursTem() {
        return afterSixHoursTem;
    }

    public String getWeatherIconUrl() {
        return weatherIconUrl;
    }
}


