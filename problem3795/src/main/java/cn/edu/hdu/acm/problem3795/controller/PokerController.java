package cn.edu.hdu.acm.problem3795.controller;

import cn.edu.hdu.acm.problem3795.dto.request.PokerHandsCompareRequest;
import cn.edu.hdu.acm.problem3795.dto.request.PokerHandsQueryRequest;
import cn.edu.hdu.acm.problem3795.dto.response.PokerHandsCompareResponse;
import cn.edu.hdu.acm.problem3795.dto.response.PokerHandsGenerateResponse;
import cn.edu.hdu.acm.problem3795.dto.response.PokerHandsQueryResponse;
import cn.edu.hdu.acm.problem3795.service.PokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import cn.edu.hdu.acm.problem3795.service.PerComputeService;

import javax.validation.Valid;

import static cn.edu.hdu.acm.problem3795.dto.response.PokerHandsGenerateResponse.success;


@RestController
@RequestMapping("/api/poker")
public class PokerController {
    @Autowired
    private PerComputeService perComputeService;

    @Autowired
    private PokerService pokerService;

    @PostMapping("/generate")
    public ResponseEntity<PokerHandsGenerateResponse> generateAllPokerHands() {
        try {
            long start = System.currentTimeMillis();

            // 执行生成逻辑（建议异步或限流）,Bean加载前就计算所有score
            perComputeService.generateAll();

            long elapsed = System.currentTimeMillis() - start;

            return ResponseEntity.ok(success(perComputeService.handScores.size(), elapsed));

        } catch (Exception e) {
            PokerHandsGenerateResponse response = PokerHandsGenerateResponse.failure(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/query")
    public  ResponseEntity<PokerHandsQueryResponse> queryPokerHandScore(@Valid @RequestBody PokerHandsQueryRequest request) {
        PokerHandsQueryResponse response = pokerService.queryHandScoreResult(request.getHand().trim());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/compare")
    public ResponseEntity<PokerHandsCompareResponse> compare(@Valid @RequestBody PokerHandsCompareRequest request) {
        PokerHandsCompareResponse response = pokerService.compareHandScoreResult(request.getHand1(),  request.getHand2());
        return ResponseEntity.ok(response);

    }
}


