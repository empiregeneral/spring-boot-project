package cn.edu.hdu.acm.problem1568.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import javax.validation.constraints.Min;

@Component
@ConfigurationProperties(prefix = "fibonacci")
public class FibonacciProperties {

    @Min(0)
    @Getter
    @Setter
    private int cutoff = 20;
}
