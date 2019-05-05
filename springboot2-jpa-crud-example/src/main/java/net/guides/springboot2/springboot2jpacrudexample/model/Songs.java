
package net.guides.springboot2.springboot2jpacrudexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "songs")
public class Songs {
	private long id; 
	private String song_name, song_data;
	
	
	public Songs() {
		
	}
	
	public Songs(String song_name, String song_data) {
		this.song_name = song_name;
		this.song_data = song_data;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(name = "song_name", nullable = false)
	public String getSong_name() {
		return song_name;
	}

	public void setSong_name(String song_name) {
		this.song_name = song_name;
	}
	@Column(name = "song_data", nullable = false)
	public String getSong_data() {
		return song_data;
	}

	public void setSong_data(String song_data) {
		this.song_data = song_data;
	}
	
	
	/*
	@Column(name = "song_name", nullable = false)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "username", nullable = false)
	public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ "]";
	}
	*/
}
