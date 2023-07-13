Install TestNG pluglin to IDE(Eclipse)

**Description** :-Able to fetch recently played songs based on the user and eliminate the least recently played songs when the store becomes full.
**GetRecentPlayedSong.java** :- This returns the recently played songs.
**RecentlyPlayedSongStore.java** :- This will storesongs based on the capacity and will return song deatils.

**Test case for validation:**
When user played songs more than the capacity, it will delete the least recent played songs and store recent played songs.(Positive case)
When user played songs more than the capacity, It will not store random songs in the list.(Negative case)
When user played same songs from the list it will sorted recently played songs even though same songs are in track.
When user played single song, it will store only single song.

