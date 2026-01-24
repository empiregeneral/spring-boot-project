package cn.pintia.zoj.problem1951.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;

@Service
public class PerComputeService {
    public volatile BitSet b;
    public volatile int[] primes;
    private final int n = 900001;


    @PostConstruct
    public void init() {
        long start = System.currentTimeMillis();
        b = new BitSet(n);
        int count = 0;
        int i;
        for(i = 2; i <= n; i++) {
            b.set(i);
        }
        i = 2;
        while(i  <= Math.sqrt(n)) {
            if (b.get(i)) {
                count++;
                int k = 2 * i;
                while ( k <= n) {
                    b.clear(k);
                    k += i;
                }
            }
            i++;
        }
        while (i <= n) {
            if (b.get(i)) {
                count++;
            }
            i++;
        }
        primes = primes(b);
        long end = System.currentTimeMillis();
        System.out.println("Create all primes in 9000001, elapsed time: " + (end - start) +" ms.");
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

    public int[] getPrimes() {
        return primes;
    }

    public BitSet getBitSet() {
        return b;
    }
}
