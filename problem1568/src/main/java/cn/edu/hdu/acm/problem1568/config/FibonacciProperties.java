package cn.edu.hdu.acm.problem1568.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import javax.validation.constraints.Min;

@Component
@ConfigurationProperties(prefix = "fibonacci")
public class FibonacciProperties {

    @Min(0)
    private int cutoff = 20;
    public int getCutoff() {
        return cutoff;
    }

    public void setCutoff(int cutoff) {this.cutoff = cutoff;}
}
