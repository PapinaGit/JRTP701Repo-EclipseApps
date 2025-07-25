package com.nt.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@ConfigurationProperties(prefix="plan.module")
@EnableConfigurationProperties
public class AppConfigProperties {
	
	Map<String, String> messages;
	
}
