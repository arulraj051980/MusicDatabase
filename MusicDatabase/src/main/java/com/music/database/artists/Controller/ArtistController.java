package com.music.database.artists.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.music.database.artists.Model.AlbumEntity;
import com.music.database.artists.Model.ArtistEntity;
import com.music.database.artists.Service.AlbumService;
import com.music.database.artists.Service.ArtistService;

@RestController
public class ArtistController {
	
	@Autowired
	private ArtistService artistService;
	
	@Autowired
	private AlbumService albumService;
	
	@ExceptionHandler(Exception.class)
	@PostMapping(value = "/", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ArtistEntity> saveArtist(@RequestBody ArtistEntity artist) {
		ArtistEntity artis = artistService.saveArtist(artist);
		
		return new ResponseEntity<ArtistEntity>(artis, HttpStatus.OK);
	}
	
	@ExceptionHandler(Exception.class)
	@PutMapping(value = "/{artistId}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ArtistEntity> updateArtist(@RequestBody ArtistEntity artist, @PathVariable String artistId) {
		ArtistEntity artist1 = artistService.updateArtist(artist, artistId);
		
		return new ResponseEntity<ArtistEntity>(artist1, HttpStatus.OK);
	}
	
	@ExceptionHandler(Exception.class)
	@GetMapping(value = "/", consumes = "application/json", produces = "application/json")
	public ResponseEntity<List<ArtistEntity>> getAll () {
		
		List<ArtistEntity> allArtist = artistService.getAllArtist();
		
		return new ResponseEntity<List<ArtistEntity>>(allArtist, HttpStatus.OK);
	}
	
	@ExceptionHandler(Exception.class)
	@PostMapping(value = "{artistId}/albums", consumes = "application/json", produces = "application/json")
	public ResponseEntity<AlbumEntity> saveAlbum(@RequestBody AlbumEntity album, @PathVariable String artistId) {
		AlbumEntity album1 = albumService.saveAlbum(album);
		
		return new ResponseEntity<AlbumEntity>(album1, HttpStatus.OK);
	}
	
	@ExceptionHandler(Exception.class)
	@PutMapping(value = "{artistId}/albums/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<AlbumEntity> updateAlbum(@RequestBody AlbumEntity album, @PathVariable String artistId, @PathVariable String id) {
		AlbumEntity album1 = albumService.updateAlbum(album, id);
		
		return new ResponseEntity<AlbumEntity>(album1, HttpStatus.OK);
	}
	
	@ExceptionHandler(Exception.class)
	@GetMapping(value = "{artistId}/albums", consumes = "application/json", produces = "application/json")
	public ResponseEntity<List<AlbumEntity>> getAllAlbum() {
		List<AlbumEntity> albumRecords = albumService.getAllAlbum();
		
		return new ResponseEntity<List<AlbumEntity>>(albumRecords, HttpStatus.OK);
	}

}
