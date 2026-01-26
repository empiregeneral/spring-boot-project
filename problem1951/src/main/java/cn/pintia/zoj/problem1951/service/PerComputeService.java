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
    public volatile BitSet betset;
    @Getter
    public volatile int[] primes;
    private final int n = 900001;


    @PostConstruct
    @LogExecutionTime
    public void init() {
        betset = new BitSet(n);
        int count = 0;
        int i;
        for(i = 2; i <= n; i++) {
            betset.set(i);
        }
        i = 2;
        while(i  <= Math.sqrt(n)) {
            if (betset.get(i)) {
                count++;
                int k = 2 * i;
                while ( k <= n) {
                    betset.clear(k);
                    k += i;
                }
            }
            i++;
        }
        while (i <= n) {
            if (betset.get(i)) {
                count++;
            }
            i++;
        }
        primes = primes(betset);
    }

    private int[] primes(BitSet b) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if (b.get(i)) {
                primes.add(i);
            }
        }
        Collections.unmodifiableCollection(primes);
        return primes.stream().mapToInt(i -> i).toArray();
    }

}
