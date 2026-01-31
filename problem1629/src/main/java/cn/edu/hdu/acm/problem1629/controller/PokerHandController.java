package cn.edu.hdu.acm.problem1629.controller;

import cn.edu.hdu.acm.problem1629.controller.request.PokerHandRequest;
import cn.edu.hdu.acm.problem1629.controller.response.PokerHandResponse;
import cn.edu.hdu.acm.problem1629.service.PsychicPokerPlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Arrays;
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
        String[] cards = input.trim().split("\\s+");
        String[] hand = Arrays.copyOfRange(cards, 0, 5);
        String[] deck = Arrays.copyOfRange(cards, 5, 10);
        String result = psychicPokerPlayService.evaluate(input);


        return PokerHandResponse.of(input, Arrays.toString(hand), Arrays.toString(deck), result);
    }

    // 可选：支持多行批量处理
    @PostMapping("/evaluate-batch")
    public List<PokerHandResponse> evaluateBatch(@Valid @RequestBody List<PokerHandRequest> requests) {
        return requests.stream()
                .map(req -> {
                    String input = req.getInputLine();
                    String[] cards = input.trim().split("\\s+");
                    String[] hand = Arrays.copyOfRange(cards, 0, 5);
                    String[] deck = Arrays.copyOfRange(cards, 5, 10);
                    String result = psychicPokerPlayService.evaluate(req.getInputLine());
                    return PokerHandResponse.of(input, Arrays.toString(hand), Arrays.toString(deck), result);
                }).collect(Collectors.toList());
    }
}
