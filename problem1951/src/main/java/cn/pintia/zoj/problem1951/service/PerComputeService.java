package cn.pintia.zoj.problem1951.service;

import cn.pintia.zoj.problem1951.model.annonation.LogExecutionTime;
import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;

@Service
@Data
public class PerComputeService {
    @Getter
    public volatile BitSet betSet;
    @Getter
    public volatile int[] primes;
    private final int n = 900_001;


    @PostConstruct
    @LogExecutionTime
    public void init() {
        betSet = new BitSet(n);
        int count = 0;
        int i;
        for(i = 2; i <= n; i++) {
            betSet.set(i);
        }
        i = 2;
        while(i  <= Math.sqrt(n)) {
            if (betSet.get(i)) {
                count++;
                int k = 2 * i;
                while ( k <= n) {
                    betSet.clear(k);
                    k += i;
                }
            }
            i++;
        }
        while (i <= n) {
            if (betSet.get(i)) {
                count++;
            }
            i++;
        }
        primes = extractPrimes(betSet);
    }

    private int[] extractPrimes(BitSet b) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if (b.get(i)) {
                primes.add(i);
            }
        }
        Collections.unmodifiableCollection(primes);
        return primes.stream().mapToInt(i -> i).toArray();
    }

    public BitSet getBitset() {
        return betSet;
    }
}
