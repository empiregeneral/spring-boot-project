package cn.edu.hdu.acm.problem1629.warmup;

import cn.edu.hdu.acm.problem1629.service.PsychicPokerPlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PsychicPokerPlayServiceWarmUp implements CommandLineRunner {
    @Autowired
    private PsychicPokerPlayService service;


    @Override
    public void run(String... args) throws Exception {
        // 使用典型输入预热
        String[] samples = {
                "TH JH QC QD QS QH KH AH 2S 6S",
                "2H 2S 3H 3S 3C 2D 3D 6C 9C TH"
        };

        // 预热 100 次（触发 JIT 编译）
        for (int i = 0; i < 100; i++) {
            for (String sample : samples) {
                service.evaluate(sample);
            }
        }
    }
}
