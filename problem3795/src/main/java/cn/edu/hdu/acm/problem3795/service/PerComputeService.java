package cn.edu.hdu.acm.problem3795.service;

import cn.edu.hdu.acm.problem3795.dto.response.PokerHandsGenerateResponse;
import cn.edu.hdu.acm.problem3795.model.PokerHand;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PerComputeService {
    public static List<PokerHand.HandScore> handScores = new ArrayList<>();
    private final int capacity = 7462;

    public PokerHandsGenerateResponse generateAll(){
        long start = System.currentTimeMillis();
        generate(0, PokerHand.C1, PokerHand.ACE, 0, true, handScores);
        Collections.sort(handScores);
        assert handScores.size() == capacity;
        long end = System.currentTimeMillis();
        return PokerHandsGenerateResponse.success(capacity, start - end);
    }

    private void generate(int hand, int pos, int rankOfHigh, int hc, boolean canflush, List<PokerHand.HandScore> handScores) {
        if (hc > 1) {
            canflush = false;
        }
        if (pos == -1) {
            generate(hand, -2, rankOfHigh, hc, canflush, handScores);
            if (canflush) {
                generate(PokerHand.setFlush(hand), -2, rankOfHigh, hc, true, handScores);
            }
        } else if (pos == -2) {
            handScores.add(new PokerHand.HandScore(hand));
        } else {
            for (int rank = rankOfHigh; rank >= 0; rank--){
                if (rank < rankOfHigh || hc < PokerHand.S.length()) {
                    generate(PokerHand.setCard(hand, pos, rank), pos - 1, rank, rank < rankOfHigh ? 1 : (hc + 1), canflush, handScores);
                }
            }
        }
    }
}
