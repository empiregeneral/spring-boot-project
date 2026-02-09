package cn.edu.hdu.acm.problem1568;

import cn.edu.hdu.acm.problem1568.service.PrintFibonacciHeaderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Problem1568ApplicationTests {
    @Autowired
    private PrintFibonacciHeaderService printFibonacciHeaderService;

    @Test
    void contextLoads() {
    }
    @Test
   public void printFibonacciHeader() {
        System.out.println(printFibonacciHeaderService.printFibonacciHeader(20));
        System.out.printf(printFibonacciHeaderService.printFibonacciHeader(100000000));
    }

}
