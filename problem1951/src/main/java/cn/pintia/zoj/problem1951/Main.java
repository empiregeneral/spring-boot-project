package cn.pintia.zoj.problem1951;

import java.util.BitSet;

public class Main {
    public static void main(String[] args) {
        int n = 900000;
        long start = System.currentTimeMillis();
        BitSet b = new BitSet(n);
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
        long end = System.currentTimeMillis();
        System.out.println(count + " primes");
        System.out.println((end - start) + " milliseconds");
    }
}
