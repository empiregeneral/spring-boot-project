package cn.edu.hdu.acm.problem1629.model.factory;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "app.combination")
public class StrategyConfig {
    private String type;
}
