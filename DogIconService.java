package work;

public class DogIconService {

    // 犬のアイコンを決定するメソッド
    public String getDogIcon(int surfaceTemperature) {
        if (surfaceTemperature <= 22) {
            return "images/happy_dog_icon.png";  // 犬が元気な時のアイコンURL
        } else if(surfaceTemperature >= 23 && surfaceTemperature <= 25 ) {
            return "images/nomal_dog_icon";  // 犬が元気のない時のアイコンURL
        } else {
        	return "images/sad_dog_icon.png";  // 犬が元気のない時のアイコンURL
        }
    }
}

