package cn.edu.hdu.acm.problem3795;

import cn.edu.hdu.acm.problem3795.service.PerComputeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Problem3795ApplicationTests {

    @Autowired
    private PerComputeService service;

    @Test
    void contextLoads() {
        service.generateAll();
    }



}
