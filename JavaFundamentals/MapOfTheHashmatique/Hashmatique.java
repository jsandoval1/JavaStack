import java.util.HashMap;

public class Hashmatique {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Black or white", "doesn't matter if your black or white");
        map.put("Billie jean", "billie not my lover");
        map.put("Thriller", "Thrill the night");
        map.put("ABC", "easy 1 2 3...");

        for (String key : map.keySet()) {
            System.out.println(String.format("Track: %s - Lyrics: %s", key, map.get(key)));
        }
    }
}