package cn.edu.hdu.acm.problem3795.service;

import cn.edu.hdu.acm.problem3795.dto.response.PokerHandsQueryResponse;
import cn.edu.hdu.acm.problem3795.model.HandScoreFromLine;
import cn.edu.hdu.acm.problem3795.model.PokerHand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class PokerService {
    @Autowired
    private HandScoreFromLine handScoreAdapt;

    @Autowired
    private PerComputeService perComputeService;

    public ResponseEntity<PokerHandsQueryResponse> queryHandScoreResult(String input) {
        int found = -1;
        PokerHand.HandScore handScore = handScoreAdapt.translate(input);
        found = Collections.binarySearch(perComputeService.handScores, handScore);
        return ResponseEntity.ok(new PokerHandsQueryResponse("PokerHand value:", found));
    }




}
