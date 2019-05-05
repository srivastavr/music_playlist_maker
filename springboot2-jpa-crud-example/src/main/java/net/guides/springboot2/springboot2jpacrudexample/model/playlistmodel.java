package net.guides.springboot2.springboot2jpacrudexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "playlist_data")
public class playlistmodel {
	public int id, user_id;
	public String plylist_name;
	
	@Column(name = "plylist_name", nullable = false)
public String getPlylist_name() {
		return plylist_name;
	}

	public void setPlylist_name(String plylist_name) {
		this.plylist_name = plylist_name;
	}

public playlistmodel() {
		
	}
	
	public playlistmodel(int id, int user_id) {
		this.id = id;
		this.user_id = user_id;
	}
	@Id
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "user_id", nullable = false)
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
}
