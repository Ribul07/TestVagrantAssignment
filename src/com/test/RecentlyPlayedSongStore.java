package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RecentlyPlayedSongStore {
	   private final int capacity;
	    private Map<String, LinkedHashMap<String, Integer>> userSongsMap;

	    public RecentlyPlayedSongStore(int capacity) {
	        this.capacity = capacity;
	        this.userSongsMap = new HashMap<>();
	    }

	    public void addSong(String user, String song) {
	        LinkedHashMap<String, Integer> songsMap = userSongsMap.getOrDefault(user, new LinkedHashMap<>());

	        if (songsMap.containsKey(song)) {
	            // If the song is already in the user's playlist, update its timestamp
	            songsMap.remove(song);
	        } else if (songsMap.size() == capacity) {
	            // If the user's playlist is full, remove the least recently played song
	            Iterator<Map.Entry<String, Integer>> iterator = songsMap.entrySet().iterator();
	            iterator.next();
	            iterator.remove();
	        }

	        // Add the song to the user's list of recently played songs with the current timestamp
	        songsMap.put(song, (int) (System.currentTimeMillis() / 1000));

	        // Update the user's playlist in the main map
	        userSongsMap.put(user, songsMap);
	    }

	    public List<String> getRecentlyPlayedSongs(String user) {
	        LinkedHashMap<String, Integer> songsMap = userSongsMap.getOrDefault(user, new LinkedHashMap<>());
	        List<String> recentlyPlayedSongs = new ArrayList<>(songsMap.keySet());
	        //Collections.reverse(recentlyPlayedSongs); // Reverse the list to get the most recent songs first
	        return recentlyPlayedSongs;
	    }

}
