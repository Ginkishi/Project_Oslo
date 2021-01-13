package edu.uha.miage.config;

import org.springframework.stereotype.Component;

/**
 *
 * @author Psyrkoz
 */
@Component
public class StorageProperties {

	private String location = "upload";

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
