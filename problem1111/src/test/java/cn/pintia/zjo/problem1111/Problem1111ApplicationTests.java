package cn.pintia.zjo.problem1111;

import cn.pintia.zjo.problem1111.service.PokerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Problem1111ApplicationTests {
    @Autowired
    PokerService service;
    @Test
    void contextLoads() {
    }

    @Test
    public void PokerHandServiceTest() {
        service.compareHands("2H 3D 5S 9C KD", "2C 3H 4S 8C AH");
    }

}
