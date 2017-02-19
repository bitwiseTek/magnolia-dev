package com.bitwise.magnolia.model.common;
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
import javax.persistence.Table;

@Entity
@Table(name="web_magnolia_states")
public class State implements Serializable {

private static final long serialVersionUID = 1L;
	
	private long id;
	
	private String name;
	
	public State() {
		
	}
	
	public State(long id) {
		this.id = id;
	}
	
	@Id
	@Column(name="STATE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name="NAME", nullable=false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
