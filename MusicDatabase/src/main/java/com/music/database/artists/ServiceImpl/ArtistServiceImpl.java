package com.music.database.artists.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.database.artists.Dao.ArtistDao;
import com.music.database.artists.Model.ArtistEntity;
import com.music.database.artists.Service.ArtistService;

@Service
public class ArtistServiceImpl implements ArtistService {

	@Autowired
	ArtistDao dao;
	
	@Override
	public ArtistEntity saveArtist(ArtistEntity artist) {
	 return	dao.saveArtist(artist);	
	}

	@Override
	public ArtistEntity updateArtist(ArtistEntity artist, String artistId) {
		
		ArtistEntity artist1 = dao.getById(artistId);
		
		artist1.setArtistName(artist.getArtistName());
		artist1.setAid(artist.getAid());
		artist1.setData_quality(artist.getData_quality());
		artist1.setImagesEntity(artist.getImagesEntity());
		artist1.setMember(artist.getMember());
		artist1.setProfile(artist.getProfile());
		artist1.setRelease_url(artist.getRelease_url());
		artist1.setResource_url(artist.getResource_url());
		artist1.setUri(artist.getUri());
		artist1.setUrls(artist.getUrls());
		
		return dao.saveArtist(artist);				
	}

	@Override
	public List<ArtistEntity> getAllArtist() {
		return dao.getAllArtist();
	}

}
