package com.music.database.artists.DaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;


import com.music.database.artists.Dao.ArtistDao;
import com.music.database.artists.Model.ArtistEntity;

@Repository
public class ArtistDaoImpl implements ArtistDao {
	
	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public ArtistEntity saveArtist(ArtistEntity artist) {
		return mongoTemplate.save(artist);
	}

	

	@Override
	public List<ArtistEntity> getAllArtist() {
		Query query = new Query();
		query.with(Sort.by(Sort.Direction.ASC, "artistName"));
		Pageable pageable = PageRequest.of(0, 25);
		query.with(pageable );
		List<ArtistEntity> AllArtist = mongoTemplate.find(query, ArtistEntity.class);
		
		Page<ArtistEntity> artist = PageableExecutionUtils.getPage(AllArtist, pageable, ()-> mongoTemplate.count(query, ArtistEntity.class));
		return artist.getContent();
	}

	@Override
	public ArtistEntity getById(String id) {
		return mongoTemplate.findById(id, ArtistEntity.class);
	}

}
