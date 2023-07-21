import org.example.Playlist;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class PlaylistTest {

    @Test
    public void testAddAndGetSongs() {
        Playlist store = new Playlist(3);
        store.addSong("User1", "S1");
        store.addSong("User1", "S2");
        store.addSong("User1", "S3");
        assertEquals(Arrays.asList("S1", "S2", "S3"), store.getUserSongs("User1"));
        store.addSong("User1", "S4");
        assertEquals(Arrays.asList("S2", "S3", "S4"), store.getUserSongs("User1"));
        store.addSong("User1", "S2");
        assertEquals(Arrays.asList("S3", "S4", "S2"), store.getUserSongs("User1"));
        store.addSong("User1", "S1");
        assertEquals(Arrays.asList("S4", "S2", "S1"), store.getUserSongs("User1"));
    }

    @Test
    public void testMultipleUsers() {
        Playlist store = new Playlist(3);
        store.addSong("User1", "S1");
        store.addSong("User1", "S2");
        store.addSong("User2", "S3");
        assertEquals(Arrays.asList("S1", "S2"), store.getUserSongs("User1"));
        assertEquals(Arrays.asList("S3"), store.getUserSongs("User2"));
    }
}
