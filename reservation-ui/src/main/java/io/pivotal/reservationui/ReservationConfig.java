package io.pivotal.reservationui;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "reservation")
public class ReservationConfig {

	private String fallbackName = "No Config Server";
	public String getFallbackName() {
		return fallbackName;
	}

	public void setFallbackName(String fallbackName) {
		this.fallbackName = fallbackName;
	}
}
