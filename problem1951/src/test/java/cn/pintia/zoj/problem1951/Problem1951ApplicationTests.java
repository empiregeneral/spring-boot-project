package cn.pintia.zoj.problem1951;

import cn.pintia.zoj.problem1951.service.GoldBachService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Problem1951ApplicationTests {

    @Autowired
    private GoldBachService goldBachService;

    @Test
    public void testLoad() {
        String equation = goldBachService.equationFirst(900000);
        System.out.println(equation);
    }

}
