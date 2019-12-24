package com.electric.instructions.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "instructions")
public class InstructionsProperties {
    private boolean openAopLog = true;

}
