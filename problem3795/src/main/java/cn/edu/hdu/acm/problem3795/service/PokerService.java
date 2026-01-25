package cn.edu.hdu.acm.problem3795.service;

import cn.edu.hdu.acm.problem3795.dto.response.PokerHandsCompareResponse;
import cn.edu.hdu.acm.problem3795.dto.response.PokerHandsQueryResponse;
import cn.edu.hdu.acm.problem3795.model.IHandScoreFromLine;
import cn.edu.hdu.acm.problem3795.model.PokerHand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class PokerService {
    @Autowired
    private IHandScoreFromLine handScoreAdapt;

    @Autowired
    private PerComputeService perComputeService;

    public PokerHandsQueryResponse queryHandScoreResult(String input) {
        int found = -1;
        PokerHand.HandScore handScore = handScoreAdapt.translate(input);
        if (found != -1) {
            found = Collections.binarySearch(perComputeService.getHandScores(), handScore);
        }

        return new PokerHandsQueryResponse("PokerHand value:", found);
    }

    public PokerHandsCompareResponse compareHandScoreResult(String hand1, String hand2) {
        PokerHand.HandScore handScore1 = handScoreAdapt.translate(hand1);
        PokerHand.HandScore handScore2 = handScoreAdapt.translate(hand2);

        if (handScore1.compareTo(handScore2) == 0) {
            return new PokerHandsCompareResponse("Hand value is equal.","Tie.", "hand1 or hand2");
        }  else if (handScore1.compareTo(handScore2) < 0) {
            return new PokerHandsCompareResponse("Hand1 value is less than Hand2.","Player2.", "hand2");
        } else {
            return new PokerHandsCompareResponse("Hand1 value is more than Hand2.","Player1.", "hand1");
        }
    }




}
