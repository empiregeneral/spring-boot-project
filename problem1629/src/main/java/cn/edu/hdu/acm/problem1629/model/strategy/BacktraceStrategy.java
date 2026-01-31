package cn.edu.hdu.acm.problem1629.model.strategy;

import cn.edu.hdu.acm.problem1629.model.annotation.CombinationType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
@CombinationType("backtrace")
public class BacktraceStrategy implements CombinationStrategy{
    @Override
    public List<Integer> generate(int n, int k) {
        if (k < 0 || k > n) {
            return Collections.emptyList();
        }
        if (k == 0) {
            return Arrays.asList(0); // 空组合 → mask=0
        }

        List<Integer> masks = new ArrayList<>();
        backtrack(0, n, k, 0, masks);
        return masks;
    }

    /**
     * 回溯生成位掩码
     * @param start 当前考虑的位索引（0 ~ n-1）
     * @param n 总位数
     * @param k 需要设置的 1 的数量
     * @param currentMask 当前掩码
     * @param masks 结果列表
     */
    private void backtrack(int start, int n, int k, int currentMask, List<Integer> masks) {
        // 终止条件：已设置 k 个 1
        if (k == 0) {
            masks.add(currentMask);
            return;
        }

        // 剪枝：剩余位数不足
        if (start > n - k) {
            return;
        }

        // 选择当前位（设为 1）
        for (int i = start; i < n; i++) {
            // 设置第 i 位为 1
            int newMask = currentMask | (1 << i);
            backtrack(i + 1, n, k - 1, newMask, masks);
        }
    }
}
