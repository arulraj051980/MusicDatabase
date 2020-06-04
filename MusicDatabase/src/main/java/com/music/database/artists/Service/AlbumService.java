package com.music.database.artists.Service;

import java.util.List;

import com.music.database.artists.Model.AlbumEntity;

public interface AlbumService {

	public AlbumEntity saveAlbum(AlbumEntity album);
	
	public AlbumEntity updateAlbum(AlbumEntity album, String albumId);
	
	public List<AlbumEntity> getAllAlbum();
}
