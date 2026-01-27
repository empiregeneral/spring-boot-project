package cn.pintia.zoj.problem1951;

import cn.pintia.zoj.problem1951.service.GoldBachService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class Problem1951ApplicationTests {

    @Autowired
    private GoldBachService goldBachService;

    @Test
    public void testLoad() {
        String equation = goldBachService.equationFirst(900000);
        System.out.println(equation);
    }

    @Test
    public void testAllEquation() throws IOException {
        goldBachService.equationListInFile();
    }

    @Test
    public void testEquations() {
        String result = goldBachService.equationsAll(190);
        System.out.println(result);
    }
}