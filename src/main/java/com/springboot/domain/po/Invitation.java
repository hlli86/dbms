package com.springboot.domain.po;

import javax.persistence.*;

@Entity
@Table(name = "invitation")
public class Invitation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "code", nullable = false)
	private String code;
	
	public Invitation() {
		
	}
	
	public Invitation(String code) {
		this.code = code;
	}
	
	public Invitation(int id, String code) {
		this.id = id;
		this.code = code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
