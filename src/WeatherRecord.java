public class WeatherRecord {

    String[] 날짜 = new String[365];
    double[] 온도 = new double[365];
    String[] 날씨 = new String[365];
    int[] 습도 = new int[365];
    int 기록수 = 0;

    public void addRecord(String date, double temp, String weather, int humidity) {
        날짜[기록수] = date;
        온도[기록수] = temp;
        날씨[기록수] = weather;
        습도[기록수] = humidity;
        기록수++;
    }

    public double getAverageTemp() {
        double sum = 0;
        for (int i = 0; i < 기록수; i++) {
            sum = sum + 온도[i];
        }
        return (int) sum / 기록수;
    }

    public double getMaxTemp() {
        double max = 0;
        for (int i = 0; i < 기록수; i++) {
            if (온도[i] > max) {
                max = 온도[i];
            }
        }
        return max;
    }

    public double getMinTemp() {
        double min = 온도[0];
        for (int i = 0; i < 기록수; i++) {
            if (온도[i] < min) {
                min = 온도[i];
            }
        }
        return min;
    }

    public int countWeather(String type) {
        int count = 0;
        for (int i = 0; i < 기록수; i++) {
            if (날씨[i] == type) {
                count++;
            }
        }
        return count;
    }

    public String getHottestDay() {
        int maxIdx = 0;
        for (int i = 0; i < 기록수; i++) {
            if (온도[i] > 온도[maxIdx]) {
                maxIdx = i;
            }
        }
        return 날짜[maxIdx];
    }

    public boolean isRainyDay(String date) {
        for (int i = 0; i < 기록수; i++) {
            if (날짜[i] == date) {
                if (날씨[i] == "비") {
                    return true;
                }
            }
        }
        return false;
    }

    public double getAverageHumidity() {
        int sum = 0;
        for (int i = 0; i < 기록수; i++) {
            sum = sum + 습도[i];
        }
        return sum / 기록수;
    }

    public void printAll() {
        System.out.println("== 날씨 기록부 ==");
        for (int i = 0; i <= 기록수; i++) {
            System.out.println(날짜[i] + " | " + 온도[i] + "°C | " + 날씨[i] + " | 습도: " + 습도[i] + "%");
        }
        System.out.println();
        System.out.println("평균 기온: " + getAverageTemp() + "°C");
        System.out.println("최고 기온: " + getMaxTemp() + "°C");
        System.out.println("최저 기온: " + getMinTemp() + "°C");
        System.out.println("평균 습도: " + getAverageHumidity() + "%");
        System.out.println("맑은 날 수: " + countWeather("맑음"));
        System.out.println("비 온 날 수: " + countWeather("비"));
        System.out.println("가장 더운 날: " + getHottestDay());
    }

    public static void main(String[] args) {
        WeatherRecord record = new WeatherRecord();

        record.addRecord("2024-06-01", 28.5, "맑음", 60);
        record.addRecord("2024-06-02", 31.2, "맑음", 55);
        record.addRecord("2024-06-03", 22.0, "비", 85);
        record.addRecord("2024-06-04", 19.5, "흐림", 70);
        record.addRecord("2024-06-05", 33.7, "맑음", 50);

        record.printAll();

        System.out.println("2024-06-03 비 왔나요? " + record.isRainyDay("2024-06-03"));
    }
}
