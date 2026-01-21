package cn.edu.hdu.acm.problem3795.service;

import cn.edu.hdu.acm.problem3795.dto.response.PokerHandsQueryResponse;
import cn.edu.hdu.acm.problem3795.model.IHandScoreFromLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class PokerService {
    @Autowired
    private IHandScoreFromLine hand;

    @Autowired PerComputeService perComputeService;

    private int found = -1;

    public ResponseEntity<PokerHandsQueryResponse> queryHandScoreResult(String input) {
        int key = hand.hand(input);
        Collections.binarySearch(perComputeService.handScores, key)；


    }




}
