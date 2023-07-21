# SongStore - A Java LRU Cache Implementation

 

## Overview
`SongStore` is a simple in-memory Java application designed to store the songs recently played by a user. It uses a Least Recently Used (LRU) caching strategy, meaning that when its capacity is reached, it will remove the least recently played song to make room for a new one.

 

## Implementation
The application uses Java's built-in `HashMap` and `LinkedList` to create an LRU cache. The key for the `HashMap` is the user, and the value is a `LinkedList` (a `Deque`, or double-ended queue) that contains the songs played by that user. The `LinkedList` allows us to easily remove songs from the beginning of the list (the least recently played songs) and add songs to the end of the list (the most recently played songs).

 

## How to Use
```java
SongStore store = new SongStore(3);  // Initialize a store with a capacity of 3 songs per user.
store.addSong("User1", "S1");  // User1 plays song S1.
store.addSong("User1", "S2");  // User1 plays song S2.
System.out.println(store.getUserSongs("User1"));  // Prints [S1, S2].
```

 

## Testing
Unit tests are written using JUnit 5. They validate the `addSong()` and `getUserSongs()` methods of the `SongStore` class. To run the tests, you'll need JUnit 5 set up in your environment.

 

To run the tests, navigate to the directory containing `SongStoreTest.java`, and execute the following command:

 

```bash
$ javac -cp .:junit-5.7.0.jar:apiguardian-api-1.1.0.jar SongStoreTest.java
$ java -cp .:junit-5.7.0.jar:apiguardian-api-1.1.0.jar org.junit.jupiter.api.Test
```

 

Please replace `junit-5.7.0.jar` and `apiguardian-api-1.1.0.jar` with the paths to the JUnit and API Guardian JARs in your local environment.


 

