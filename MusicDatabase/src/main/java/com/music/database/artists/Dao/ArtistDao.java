package com.music.database.artists.Dao;

import java.util.List;

import com.music.database.artists.Model.ArtistEntity;

public interface ArtistDao {
	
	public ArtistEntity saveArtist(ArtistEntity artist);
	
		
	public List<ArtistEntity> getAllArtist();
	
	public ArtistEntity getById(String id);

}
