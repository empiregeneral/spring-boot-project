package cn.pintia.zoj.problem1951.service;

import cn.pintia.zoj.problem1951.model.annonation.LogExecutionTime;
import lombok.Getter;
import org.springframework.stereotype.Service;
import java.io.*;
import java.util.BitSet;
import java.util.Scanner;

@Service
public class GoldBachService {
    @Getter
    private final PerComputeService preComputeService;
    @Getter
    private  final BitSet bitSet;
    @Getter
    private  final int[] primes;

    // 构造器注入
    public GoldBachService(PerComputeService preComputeService) {
        this.preComputeService = preComputeService;
        this.bitSet = preComputeService.getBitSet();
        this.primes = preComputeService.getPrimes();
    }

    public String equationFirst(int evenNumber) {
        return equation(bitSet, primes, evenNumber);
    }

    @LogExecutionTime
    public void listEquationsInFile() throws IOException {
        OutputStream outputStream = new BufferedOutputStream(System.out);
        equationAll(bitSet, primes, outputStream);
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

    private void  equationAll(BitSet bitSet, int[] primes, OutputStream outputStream) throws IOException {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("goldbach.in");
        FileWriter fileWriter = new FileWriter("goldbach.out", true);
        if (inputStream == null) {
            throw new RuntimeException("There is no input.");
        }

        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNext()) {
            int evenNum = scanner.nextInt();
            if (evenNum == 0) {
                break;
            }
            fileWriter.write(equation(bitSet, primes, evenNum));
        }
        fileWriter.close();
        scanner.close();
    }

}
