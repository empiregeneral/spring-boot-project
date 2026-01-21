package cn.pintia.zjo.problem1111.controller;

import cn.pintia.zjo.problem1111.dto.request.PokerCompareRequest;
import cn.pintia.zjo.problem1111.dto.response.PokerCompareResponse;
import cn.pintia.zjo.problem1111.service.PokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/poker")
public class PokerController {
    @Autowired
    private PokerService pokerService;

    @PostMapping("/compare")
    public ResponseEntity<PokerCompareResponse> compare(
                @Valid @RequestBody PokerCompareRequest request) {
        PokerCompareResponse response = pokerService.compareHands(
                request.getHand1().trim(),
                request.getHand2().trim()
        );
        return ResponseEntity.ok(response);
    }
}
