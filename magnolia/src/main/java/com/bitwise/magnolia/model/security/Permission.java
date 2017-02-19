package com.bitwise.magnolia.model.security;

/**
 *  
 * @author Sika Kay
 * @date 17/02/17
 *
 */

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="PERMISSIONS")
@NamedQuery(name="Permission.findAll", query="SELECT p from Permission p")
public class Permission implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Permission() {
		
	}
	
	public Permission(String permission) {
		this.permissions = permission;
	}
	
	private Long id;
	
	private String permissions;

	@Id
	@Column(name="PERMISSION_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="PERMISSIONS")
	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}
}
