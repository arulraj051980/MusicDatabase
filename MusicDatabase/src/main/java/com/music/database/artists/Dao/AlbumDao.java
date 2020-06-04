package com.music.database.artists.Dao;

import java.util.List;

import com.music.database.artists.Model.AlbumEntity;

public interface AlbumDao {
	
	public AlbumEntity saveAlbum(AlbumEntity album);
	
	public AlbumEntity updateAlbum(AlbumEntity album, String albumId);
	
	public List<AlbumEntity> getAllAlbum();

}
