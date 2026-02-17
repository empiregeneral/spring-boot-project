package cn.edu.hdu.acm.problem1568.service;

import cn.edu.hdu.acm.problem1568.config.FibonacciProperties;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor; // 使用 Lombok 简化构造注入，或手动写构造器


@Service
@RequiredArgsConstructor
public class PrintFibonacciHeaderService{

    private final FibonacciProperties fibonacciProperties;

    public String printFibonacciHeader(int n) {
        StringBuilder sb = new StringBuilder();
        if (n <= fibonacciProperties.getCutoff()) {
            sb.append(GoldenRatioForFib.solution(n));
        }
        else {
            sb.append(calFibNumberHead(n));
        }
        return sb.toString();
    }

    private int calFibNumberHead(int n){
        double log = (-0.5*Math.log10(5) + (double)n*Math.log10(((1+Math.sqrt(5))*1.0)/2));
        double tmp = (log - (int)log + 3);
        return (int)Math.pow(10, tmp);
    }
}

final class GoldenRatioForFib {
    private static final double goldenRatio1 = (1 + Math.sqrt(5)) / 2;
    private static final double goldenRatio2 = (1 - Math.sqrt(5)) / 2;

    public static int solution(int N) {
        assert N >= 0;
        int result = 0;
        if (N <= 20) {
            result = (int) Math.round(Math.pow(goldenRatio1, N) / Math.sqrt(5) - Math.pow(goldenRatio2, N) / Math.sqrt(5));
        } else {
            result = (int) Math.round(Math.pow(goldenRatio1, N) / Math.sqrt(5));
        }
        return result;
    }
}
