/**
 * 
 */
package com.tourism.canada.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourism.canada.entities.Role;

/**
 * @author Mayank
 *
 */
public interface RoleDao extends JpaRepository<Role, Integer> {

}
