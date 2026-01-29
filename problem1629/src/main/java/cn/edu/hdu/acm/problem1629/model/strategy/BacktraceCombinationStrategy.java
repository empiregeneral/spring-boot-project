package cn.edu.hdu.acm.problem1629.model.strategy;

import cn.edu.hdu.acm.problem1629.model.annotation.CombinationType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@CombinationType("backtrace")
public class BacktraceCombinationStrategy implements CombinationStrategy{
    @Override
    public List<Integer> generate(int n, int k) {
        return Collections.EMPTY_LIST;
    }
}
