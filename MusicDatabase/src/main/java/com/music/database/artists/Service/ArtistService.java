package com.music.database.artists.Service;

import java.util.List;

import com.music.database.artists.Model.ArtistEntity;

public interface ArtistService {
	
	public ArtistEntity saveArtist(ArtistEntity artist);
	
	public ArtistEntity updateArtist(ArtistEntity artist, String artistId);	
	
	public List<ArtistEntity> getAllArtist();

}
