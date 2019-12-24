package com.electric.manual.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "manual")
public class ManualProperties {
    private boolean openAopLog = true;

}
