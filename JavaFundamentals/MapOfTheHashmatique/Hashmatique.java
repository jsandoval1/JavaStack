import java.util.HashMap;

public class Hashmatique { // Class named Hashmatique.
    public static void main(String[] args) { 
        // Create a HashMap to store the song titles and lyrics 
        // which will store song titles as keys (of type String) and their corresponding lyrics as values (also of type String)
        HashMap<String, String> trackList = new HashMap<String, String>();
        
        // Add songs to the trackList hashmap
        trackList.put("Black or white", "doesn't matter if your black or white");
        trackList.put("Billie jean", "billie not my lover");
        trackList.put("Thriller", "Thrill the night");
        trackList.put("ABC", "easy 1 2 3...");

        // Retrieves the lyrics by providing the song title as the key to the get method of the trackList HashMap.
        String songTitle = "Black or white";
        System.out.println("Lyrics for '" + songTitle + "': " + trackList.get(songTitle));

        // Print all track names and lyrics
        for (String key : trackList.keySet()) { // Iterates over the keys (song titles) in the trackList HashMap. String specifies that key will be string type.
            System.out.println(String.format("Track: %s - Lyrics: %s", key, trackList.get(key))); 
                // Prints each track's title and lyrics 
                    // Uses the key to access the lyrics associated with that song title using trackList.get(key). 
                        // This retrieves the lyrics from the HashMap based on the current song title (key).
        }
    }
}
