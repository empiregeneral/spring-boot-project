package cn.edu.hdu.acm.problem1629.controller;

import cn.edu.hdu.acm.problem1629.controller.request.PokerHandRequest;
import cn.edu.hdu.acm.problem1629.controller.response.PokerHandResponse;
import cn.edu.hdu.acm.problem1629.service.PsychicPokerPlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/poker")
public class PokerHandController {
    @Autowired
    private PsychicPokerPlayService psychicPokerPlayService; // 注入你的业务逻辑

    @PostMapping("/evaluate")
    public PokerHandResponse evaluateHand(@Valid @RequestBody PokerHandRequest request) {
        String input = request.getInputLine();
        return ResponseEntity.of(psychicPokerPlayService.evaluate(input));
    }

    // 可选：支持多行批量处理
    @PostMapping("/evaluate-batch")
    public List<PokerHandResponse> evaluateBatch(@Valid @RequestBody List<PokerHandRequest> requests) {
        return requests.stream()
                .map(req -> psychicPokerPlayService.evaluate(req.getInputLine()))
                .collect(Collectors.toList());
    }
}
