import java.util.HashMap;
import java.util.Map;

public class LinkShortener {
    private static final String BASE_URL = "http://short.ly/";  // Base URL for shortened links
    private static final String CHAR_SET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int SHORT_URL_LENGTH = 6;

    // Data structure to store long URLs with their short URLs
    private Map<String, String> shortToLongMap = new HashMap<>();
    private Map<String, String> longToShortMap = new HashMap<>();

    // Method to generate a short URL from a long URL
    public String shortenURL(String longURL) {
        if (longToShortMap.containsKey(longURL)) {
            return BASE_URL + longToShortMap.get(longURL);  // Return existing short URL if it exists
        }

        String shortURL = generateShortCode();
        while (shortToLongMap.containsKey(shortURL)) {
            shortURL = generateShortCode();  // Ensure uniqueness of short URL
        }

        // Save mappings in both directions
        shortToLongMap.put(shortURL, longURL);
        longToShortMap.put(longURL, shortURL);

        return BASE_URL + shortURL;
    }

    // Method to retrieve the original long URL from a short URL
    public String expandURL(String shortURL) {
        String shortCode = shortURL.replace(BASE_URL, "");
        return shortToLongMap.getOrDefault(shortCode, "URL not found");
    }

    // Method to generate a unique short code using random characters
    private String generateShortCode() {
        StringBuilder sb = new StringBuilder(SHORT_URL_LENGTH);
        for (int i = 0; i < SHORT_URL_LENGTH; i++) {
            int index = (int) (Math.random() * CHAR_SET.length());
            sb.append(CHAR_SET.charAt(index));
        }
        return sb.toString();
    }
}
