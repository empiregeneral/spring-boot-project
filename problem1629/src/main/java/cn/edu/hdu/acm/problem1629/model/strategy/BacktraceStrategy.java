package cn.edu.hdu.acm.problem1629.model.strategy;

import cn.edu.hdu.acm.problem1629.model.annotation.CombinationType;
import org.springframework.stereotype.Component;

@Component
@CombinationType("backtrace")
public class BacktraceStrategy implements CombinationStrategy{
    @Override
    public int combination(int n, int k) {
        return 0;
    }
}
