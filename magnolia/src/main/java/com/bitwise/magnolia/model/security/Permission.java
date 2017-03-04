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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="PERMISSIONS", uniqueConstraints = @UniqueConstraint(columnNames = {
"permissions" }))
@NamedQueries({
	@NamedQuery(name="Permission.findById", query="select distinct p from Permission p where p.id=:id"),
	@NamedQuery(name="Permission.findByName", query="select distinct p from Permission p where p.permissions=:permission"),
	@NamedQuery(name="Permission.findAll", query="select p from Permission p")
})
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
