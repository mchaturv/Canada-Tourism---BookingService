package com.tourism.canada.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="role")
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="roleid")
	private int roleId;
	
	@Column(name="rolename")
	private String roleName;

	
	public Role() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	


	/**
	 * @param roleId
	 */
	public Role(int roleId) {
		super();
		this.roleId = roleId;
	}






	/**
	 * @param roleId
	 * @param roleName
	 */
	public Role(int roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return roleId;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.roleId = id;
	}


	/**
	 * @return the role
	 */
	public String getRole() {
		return roleName;
	}


	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.roleName = role;
	}


	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + "]";
	}
	
	
	
	

}
