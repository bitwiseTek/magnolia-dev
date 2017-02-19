package com.bitwise.magnolia.model.security;

/**
 *  
 * @author Sika Kay
 * @date 17/02/17
 *
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="ROLES")
@NamedQuery(name="Role.findAll", query="SELECT r from Role r")
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Role() {
		
	}
	
	public Role(String role) {
		this.roles = role;
	}
	
	private Long id;
	
	private String roles;
	
	private List<Permission> permissions = new ArrayList<Permission>();

	@Id
	@Column(name="ROLE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="ROLES")
	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="LINK_ROLES_PERMISSIONS", joinColumns={@JoinColumn(name="ROLE_ID")}, inverseJoinColumns={@JoinColumn(name="PERMISSION_ID")})
	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
}
