package cn.pintia.zoj.problem1951.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.BitSet;

@Service
public class GoldBachService {
    @Autowired
    private PerComputeService preComputeService;

    public String equationFirst(int evenNumber) {
        BitSet bitSet = preComputeService.getBitSet();
        int[] primes = preComputeService.getPrimes();
        return equation(bitSet, primes, evenNumber);
    }

    private String equation(BitSet bitSet, int[] primes, int evenNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            for (int p : primes) {
                if (p > evenNumber >> 1) {
                    break;
                }
                int q = evenNumber - p;
                if (q < bitSet.length() && bitSet.get(q)) {
                    stringBuilder.append(String.format("%d = %d + %d\n", new Object[]{evenNumber, p, q}));
                    break;
                }
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            throw new AssertionError("So The limit ≤ 4e18. Said to Goldbach: There is no Equation");
        }
    }
}
