package SourceCodes;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class weather {

    @SuppressWarnings("unchecked")
	public static JSONObject getWeatherData(String locationName) throws Exception {

        JSONArray locationData = getLocationData(locationName);

        JSONObject location = (JSONObject) locationData.get(0);

        double latitude = (double) location.get("latitude");
        double longitude = (double) location.get("longitude");

        String urlString = "https://api.open-meteo.com/v1/forecast?" +
                "latitude=" + latitude + "&longitude=" + longitude +
                "&hourly=temperature_2m,relativehumidity_2m,weathercode,windspeed_10m&timezone=Asia%2FSingapore";
        HttpURLConnection conn = fetchApiResponse(urlString);

        if (conn.getResponseCode() != 200) {
            JOptionPane.showMessageDialog(null, "Error: could not connect to API", "ERROR", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        StringBuilder resultJson = new StringBuilder();
        Scanner scanner = new Scanner(conn.getInputStream());
        while (scanner.hasNext()) {
            // read and store into the string builder
            resultJson.append(scanner.nextLine());
        }

        scanner.close();

        conn.disconnect();

        JSONParser parser = new JSONParser();
        JSONObject resultJsonObj = (JSONObject) parser.parse(String.valueOf(resultJson));

        JSONObject hourly = (JSONObject) resultJsonObj.get("hourly");

        JSONArray time = (JSONArray) hourly.get("time");
        int index = findIndexOfCurrentTime(time);

        JSONArray temperatureData = (JSONArray) hourly.get("temperature_2m");
        double temperature = (double) temperatureData.get(index);

        JSONArray weathercode = (JSONArray) hourly.get("weathercode");
        String weatherCondition = convertWeatherCode((long) weathercode.get(index));

        JSONArray relativeHumidity = (JSONArray) hourly.get("relativehumidity_2m");
        long humidity = (long) relativeHumidity.get(index);

        // get windspeed
        JSONArray windspeedData = (JSONArray) hourly.get("windspeed_10m");
        double windspeed = (double) windspeedData.get(index);

        // build the weather json data object that we are going to access in our
        // frontend
        JSONObject weatherData = new JSONObject();
        weatherData.put("temperature", temperature);
        weatherData.put("weather_condition", weatherCondition);
        weatherData.put("humidity", humidity);
        weatherData.put("windspeed", windspeed);

        return weatherData;

    }

    // retrieves geographic coordinates for given location name
    public static JSONArray getLocationData(String locationName) throws Exception {
        // replace any whitespace in location name to + to adhere to API's request
        // format
        locationName = locationName.replaceAll(" ", "+");

        // build API url with location parameter
        String urlString = "https://geocoding-api.open-meteo.com/v1/search?name=" +
                locationName + "&count=10&language=en&format=json";

        // call api and get a response
        HttpURLConnection conn = fetchApiResponse(urlString);

        // check response status
        // 200 means successful connection
        if (conn.getResponseCode() != 200) {
            JOptionPane.showMessageDialog(null, "Error: could not connect to API", "ERROR", JOptionPane.ERROR_MESSAGE);
            return null;
        } else {
            // store the API results
            StringBuilder resultJson = new StringBuilder();
            Scanner scanner = new Scanner(conn.getInputStream());

            // read and store the resulting json data into our string builder
            while (scanner.hasNext()) {
                resultJson.append(scanner.nextLine());
            }

            scanner.close();

            conn.disconnect();

            JSONParser parser = new JSONParser();
            JSONObject resultsJsonObj = (JSONObject) parser.parse(String.valueOf(resultJson));

            JSONArray locationData = (JSONArray) resultsJsonObj.get("results");
            return locationData;
        }

        // couldn't find location

    }

    private static HttpURLConnection fetchApiResponse(String urlString) throws IOException {

        // attempt to create connection
        @SuppressWarnings("deprecation")
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        // set request method to get
        conn.setRequestMethod("GET");

        // connect to our API
        conn.connect();
        return conn;

        // could not make connection
    }

    private static int findIndexOfCurrentTime(JSONArray timeList) {
        String currentTime = getCurrentTime();
        for (int i = 0; i < timeList.size(); i++) {

            String time = (String) timeList.get(i);
            if (time.equalsIgnoreCase(currentTime)) {
                return i;
            }
        }

        return 0;
    }

    private static String getCurrentTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH':00'");

        String formattedDateTime = currentDateTime.format(formatter);

        return formattedDateTime;
    }

    // convert the weather code to something more readable
    private static String convertWeatherCode(long weathercode) {
        String weatherCondition = "";
      
        if (weathercode == 0L) {
            // clear
            weatherCondition = "Clear";
        } else if (weathercode > 0L && weathercode <= 3L) {
            // cloudy
            weatherCondition = "Cloudy";
        } else if ((weathercode >= 51L && weathercode <= 67L)
                || (weathercode >= 80L && weathercode <= 99L)) {
            // rain
            weatherCondition = "Rain";
        } else if (weathercode >= 71L && weathercode <= 77L) {
            // snow
            weatherCondition = "Snow";
        }

        return weatherCondition;
    }
}
