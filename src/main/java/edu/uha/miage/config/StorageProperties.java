/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.config;

import org.springframework.stereotype.Component;

/**
 *
 * @author Psyrkoz
 */
@Component
public class StorageProperties {

	/**
	 * Folder location for storing files
	 */
	private String location = "upload";

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
