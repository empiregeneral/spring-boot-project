package cn.edu.hdu.acm.problem1629;

import cn.edu.hdu.acm.problem1629.model.strategy.CombinationStrategy;
import cn.edu.hdu.acm.problem1629.service.PsychicPokerPlayService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Problem1629ApplicationTests {
    @Autowired
    @Qualifier("bitmaskCombinationStrategy")
    private CombinationStrategy combinationStrategy;

    @Autowired
    private PsychicPokerPlayService psychicPokerPlayService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testGenerate() {
        for (int k = 0; k <= 5; k++) {
            System.out.println(  combinationStrategy.generate(5, k));
        }
    }

    @Test
    public void testPsychicPokerPlayService() {
        System.out.println(psychicPokerPlayService.evaluate("2H 2S 3H 3S 3C 2D 3D 6C 9C TH"));
    }

}
