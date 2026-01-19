package cn.edu.hdu.acm.problem3795.controller;

import cn.edu.hdu.acm.problem3795.dto.response.PokerHandsGenerateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.edu.hdu.acm.problem3795.service.PerComputeService;

import static cn.edu.hdu.acm.problem3795.dto.response.PokerHandsGenerateResponse.success;


@RestController
@RequestMapping("/poker")
public class PokerController {
    @Autowired
    private PerComputeService perComputeService;

    @PostMapping("/generate")
    public ResponseEntity<PokerHandsGenerateResponse> generateAllPokerHands() {
        try {
            long start = System.currentTimeMillis();

            // 执行生成逻辑（建议异步或限流）
            perComputeService.generateAll();

            long elapsed = System.currentTimeMillis() - start;
            int total = 7462;

            return ResponseEntity.ok(success(total, elapsed));

        } catch (Exception e) {
            PokerHandsGenerateResponse response = PokerHandsGenerateResponse.failure(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}


