package cn.edu.hdu.acm.problem1629.model.strategy;

import cn.edu.hdu.acm.problem1629.model.annotation.CombinationType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@CombinationType("Bitmask")
@Component
public class BitmaskCombinationStrategy implements CombinationStrategy{

    @Override
    public List<Integer> generate(int n, int k) {
        if (k < 0 || k > n) {
            return Collections.emptyList();
        }
        if (k == 0) {
            return Arrays.asList(0); // 只有空集
        }

        List<Integer> masks = new ArrayList<>();
        int max = 1 << n;

        for (int mask = 0; mask < max; mask++) {
            if (Integer.bitCount(mask) == k) {
                masks.add(mask);
            }
        }
        return masks;
    }
}
