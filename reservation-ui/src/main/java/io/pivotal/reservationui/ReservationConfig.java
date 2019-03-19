package io.pivotal.reservationui;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@ConfigurationProperties(prefix = "reservation")
@RefreshScope
public class ReservationConfig {

	private String fallbackName = "No Config Server";
	public String getFallbackName() {
		return fallbackName;
	}

	public void setFallbackName(String fallbackName) {
		this.fallbackName = fallbackName;
	}
}
