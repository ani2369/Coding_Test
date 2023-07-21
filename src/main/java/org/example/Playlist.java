package org.example;

import java.util.*;

public class Playlist {
    private final int capacity;
    private final Map<String, Deque<String>> songStore;

    public Playlist(int capacity) {
        this.capacity = capacity;
        this.songStore = new HashMap<>();
    }

    public void addSong(String user, String song) {
        Deque<String> userSongs = songStore.getOrDefault(user, new LinkedList<>());
        if (userSongs.contains(song)) {
            userSongs.remove(song);
        } else if (userSongs.size() == capacity) {
            userSongs.removeFirst();
        }
        userSongs.add(song);
        songStore.put(user, userSongs);
    }

    public List<String> getUserSongs(String user) {
        if (!songStore.containsKey(user)) {
            return Collections.emptyList();
        }
        return new ArrayList<>(songStore.get(user));
    }

    public static void main(String[] args) {
        Playlist store = new Playlist(3);
        store.addSong("User1", "S1");
        store.addSong("User1", "S2");
        store.addSong("User1", "S3");
        System.out.println(store.getUserSongs("User1"));  // prints [S1, S2, S3]
        store.addSong("User1", "S4");
        System.out.println(store.getUserSongs("User1"));  // prints [S2, S3, S4]
        store.addSong("User1", "S2");
        System.out.println(store.getUserSongs("User1"));  // prints [S3, S4, S2]
        store.addSong("User1", "S1");
        System.out.println(store.getUserSongs("User1"));  // prints [S4, S2, S1]
    }
}
