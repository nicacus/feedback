package net.redirectme.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@Getter
@Setter
@ConfigurationProperties(prefix = "info.build")
@ConfigurationPropertiesScan
public class ApplicationInfoProperties {
    private String artifact;
    private String version;
}
