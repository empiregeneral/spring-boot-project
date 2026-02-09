package cn.pintia.zjo.problem1111.service;

import cn.pintia.zjo.problem1111.entity.CardUtils;
import cn.pintia.zjo.problem1111.enumeration.Judgement;
import cn.pintia.zjo.problem1111.factory.PokerHandFactory;
import cn.pintia.zjo.problem1111.enumeration.PokerHandType;
import cn.pintia.zjo.problem1111.model.PokerHand;
import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokerService  {
    @Autowired
    private PokerHand pokerHand;

    public Triplet<Judgement, String, String> compareHands(String player1Hands, String player2Hands) {

        PokerHandType player1HandsType = pokerHand.pokerHandType(player1Hands);
        PokerHandType player2HandsType = pokerHand.pokerHandType(player2Hands);

        int cmp = player1HandsType.compareTo(player2HandsType);
        PokerHandType pokerHandType = player1HandsType.getHandType();
        Judgement judgement = PokerHandFactory.showHandJudgement(CardUtils.toCards(player1Hands),
                CardUtils.toCards(player2Hands), pokerHandType);
        if (cmp == 0) {
            return new Triplet<>(judgement, " Same PokerHandType, base on poker faces or kickers", judgement.getDescription());
        } else if (cmp < 0) {
            return new Triplet<>(judgement, " Based on poker hand ranking", judgement.getDescription());
        } else {
            return new Triplet<>(judgement, " Based on poker hand ranking", judgement.getDescription());
        }
    }
}
