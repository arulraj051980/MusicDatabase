package com.music.database.artists.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.OrderBy;

import org.springframework.batch.item.database.Order;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("artist")
public class ArtistEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	
	@OrderBy
	private String artistName;
	
	private String profile;
	
	private String release_url;
	
	private String resource_url;
	
	private String uri;
	
	private List<String> urls;
	
	private String data_quality;
	
	private int aid;
	
	private List<ImagesEntity> imagesEntity;
	
	private List<MembersEntity> member;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public List<ImagesEntity> getImagesEntity() {
		return imagesEntity;
	}

	public void setImagesEntity(List<ImagesEntity> imagesEntity) {
		this.imagesEntity = imagesEntity;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getRelease_url() {
		return release_url;
	}

	public void setRelease_url(String release_url) {
		this.release_url = release_url;
	}

	public String getResource_url() {
		return resource_url;
	}

	public void setResource_url(String resource_url) {
		this.resource_url = resource_url;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public List<String> getUrls() {
		return urls;
	}

	public void setUrls(List<String> urls) {
		this.urls = urls;
	}

	public String getData_quality() {
		return data_quality;
	}

	public void setData_quality(String data_quality) {
		this.data_quality = data_quality;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public List<MembersEntity> getMember() {
		return member;
	}

	public void setMember(List<MembersEntity> member) {
		this.member = member;
	}
	
		

}
