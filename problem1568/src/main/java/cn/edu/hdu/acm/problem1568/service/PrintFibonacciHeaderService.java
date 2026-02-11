package cn.edu.hdu.acm.problem1568.service;

import org.springframework.stereotype.Service;

@Service
public class PrintFibonacciHeaderService{

    public String printFibonacciHeader(int n) {
        StringBuilder sb = new StringBuilder();
        if (n <= 20) {
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
        if (N <= 20) {
            int result = (int)Math.round(Math.pow(goldenRatio1, N)/Math.sqrt(5) - Math.pow(goldenRatio2, N)/Math.sqrt(5));
            return result;
        } else {
            return (int)Math.round(Math.pow(goldenRatio1, N)/ Math.sqrt(5));
        }
    }
}
