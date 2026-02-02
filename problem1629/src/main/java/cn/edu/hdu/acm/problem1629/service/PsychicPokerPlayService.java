package cn.edu.hdu.acm.problem1629.service;


import cn.edu.hdu.acm.problem1629.model.PokerHand;
import cn.edu.hdu.acm.problem1629.model.factory.CombinateStrategyFactory;
import cn.edu.hdu.acm.problem1629.model.strategy.CombinationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Collections;

import static cn.edu.hdu.acm.problem1629.model.PokerHand.RANKING_TO_OUTPUT;

@Service
public class PsychicPokerPlayService {
    @Autowired
    private CombinationStrategy combinationStrategy;


    @Autowired
    private CombinateStrategyFactory combinateStrategyFactory;

    public String evaluate(String input ) {
        return solve(input);
    }

    private String solve(String line) {
        String[] cards = line.trim().split("\\s+");
        String[] hand = Arrays.copyOfRange(cards, 0, 5);
        String[] deck = Arrays.copyOfRange(cards, 5, 10);
        List<PokerHand.HandScore> pokerHands = new ArrayList<>();

        for (int keep = 0; keep < 5; keep++) {
            int take = 5 - keep;// 从 deck 取的数量
            List<Integer> masks = combinationStrategy.generate(5, keep);
            for (int mask : masks) {
                List<String> selected = new ArrayList<>();
                // 从 hand 中按 mask 选牌
                for (int i = 0; i < 5; i++) {
                    if ((mask & (1 << i)) != 0) {
                        selected.add(hand[i]);
                    }
                }
                for (int i = 0; i < take; i++) {
                    selected.add(deck[i]);
                }
                String newHandStr = String.join(" ", selected);
                int handValue = PokerHand.valueOf(newHandStr);
                PokerHand.HandScore score = new PokerHand.HandScore(handValue);
                pokerHands.add(score);
            }
        }
        Collections.sort(pokerHands);
        PokerHand.HandScore best = Collections.max(pokerHands);

        return RANKING_TO_OUTPUT.get(best.getRanking());
    }
}


