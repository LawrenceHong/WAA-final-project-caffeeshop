package edu.mum.coffee.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.validation.constraints.NotNull;
import javax.persistence.JoinColumn;;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	@Id
	@GeneratedValue
	//@NotNull
	private String username;
	private String password;
	private String role;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
