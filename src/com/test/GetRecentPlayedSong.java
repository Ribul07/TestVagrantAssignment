package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetRecentPlayedSong {
	
	RecentlyPlayedSongStore store = new RecentlyPlayedSongStore(3); // 3 - maximum Storing Capacity
	List<String> expectedUser1PlayedSongs = new ArrayList<String>(Arrays.asList("song2", "song4", "song5"));
	List<String> notExpectedUser2PlayedSongs = new ArrayList<String>(Arrays.asList("song3", "song7", "song8"));
	List<String> expectedUser3PlayedSongs = new ArrayList<String>(Arrays.asList("songA", "songC", "songB"));
	List<String> expectedUser4PlayedSongs = new ArrayList<String>(Arrays.asList("songE"));
	List<String> notExpectedUser4PlayedSongs = new ArrayList<String>(Arrays.asList("songE","songE","songE"));
	
	@BeforeTest
	public void test() {
	
	
	/*
	 * Scanner scanner = new Scanner(System.in);
	 * System.out.println("Enter user name:"); String user=scanner.nextLine();
	 * Scanner scanner1 = new Scanner(System.in);
	 * System.out.println("Enter user name:"); String song=scanner.nextLine();
	 */
	

    store.addSong("user1", "song1");
    store.addSong("user1", "song2");
    store.addSong("user2", "song3");
    store.addSong("user1", "song4");
    store.addSong("user1", "song5");
    store.addSong("user3", "songA");
    store.addSong("user3", "songB");
    store.addSong("user2", "song7");
    store.addSong("user2", "song8");
    store.addSong("user2", "song9");
    store.addSong("user3", "songC");
    store.addSong("user3", "songB");
    store.addSong("user4", "songE");
    store.addSong("user4", "songE");
    store.addSong("user4", "songE");
    store.addSong("user4", "songE");


	}
	
	@Test
	public void user1() {
	    List<String> recentlyPlayedSongsUser1 = store.getRecentlyPlayedSongs("user1");
	    System.out.println("Recently played songs for user1: " + recentlyPlayedSongsUser1);
	    Assert.assertEquals(recentlyPlayedSongsUser1, expectedUser1PlayedSongs);
	}
	@Test
	public void user2() {


	    List<String> recentlyPlayedSongsUser2 = store.getRecentlyPlayedSongs("user2");
	    System.out.println("Recently played songs for user2: " + recentlyPlayedSongsUser2);
	    Assert.assertNotEquals(recentlyPlayedSongsUser2, notExpectedUser2PlayedSongs);
	}
	
	@Test
	public void user3() {


	    List<String> recentlyPlayedSongsUser3 = store.getRecentlyPlayedSongs("user3");
	    System.out.println("Recently played songs for user3: " + recentlyPlayedSongsUser3);
	    Assert.assertEquals(recentlyPlayedSongsUser3, expectedUser3PlayedSongs);
	}
	
	@Test
	public void user4() {


	    List<String> recentlyPlayedSongsUser4 = store.getRecentlyPlayedSongs("user4");
	    System.out.println("Recently played songs for user4: " + recentlyPlayedSongsUser4);
	    Assert.assertEquals(recentlyPlayedSongsUser4, expectedUser4PlayedSongs);
	}
	
	@Test
	public void user4Negative() {


	    List<String> recentlyPlayedSongsUser4Neg = store.getRecentlyPlayedSongs("user4");
	    System.out.println("Recently played songs for user4: " + recentlyPlayedSongsUser4Neg);
	    Assert.assertNotEquals(recentlyPlayedSongsUser4Neg, notExpectedUser4PlayedSongs);
	}
	
	

}
