package com.music.database.artists.DaoImpl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.support.PageableExecutionUtils;

import com.music.database.artists.Dao.AlbumDao;
import com.music.database.artists.Model.AlbumEntity;
import com.music.database.artists.Model.ArtistEntity;

public class AlbumDaoImpl implements AlbumDao {

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public AlbumEntity saveAlbum(AlbumEntity album) {
		AlbumEntity alb = mongoTemplate.save(album);
		return alb;
	}

	@Override
	public AlbumEntity updateAlbum(AlbumEntity album, String albumId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AlbumEntity> getAllAlbum() {
		Query query = new Query();
		query.with(Sort.by(Sort.Direction.ASC, "albumName"));
		
		Pageable pageable = PageRequest.of(0, 25);
		query.with(pageable );
		
		List<AlbumEntity> listAlbum = mongoTemplate.find(query, AlbumEntity.class);
		
		Page<AlbumEntity> album = PageableExecutionUtils.getPage(listAlbum, pageable, ()-> mongoTemplate.count(query, AlbumEntity.class));
		return album.getContent();
	}

}
