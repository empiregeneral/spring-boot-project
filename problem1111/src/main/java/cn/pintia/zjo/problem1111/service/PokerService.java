package cn.pintia.zjo.problem1111.service;

import cn.pintia.zjo.problem1111.dto.response.PokerCompareResponse;
import cn.pintia.zjo.problem1111.entity.CardUtils;
import cn.pintia.zjo.problem1111.enumeration.Judgement;
import cn.pintia.zjo.problem1111.factory.PokerHandFactory;
import cn.pintia.zjo.problem1111.enumeration.PokerHandType;
import cn.pintia.zjo.problem1111.model.PokerHand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokerService  {
    private String player1Hands;
    private String player2Hands;
    private PokerHandType player1HandsType;
    private PokerHandType player2HandsType;

    @Autowired
    private PokerHand pokerHand;

    public PokerCompareResponse compareHands(String player1Hands, String player2Hands) {
        this.player1Hands = player1Hands;
        this.player2Hands = player2Hands;
        this.player1HandsType = pokerHand.pokerHandType(this.player1Hands);
        this.player2HandsType = pokerHand.pokerHandType(this.player2Hands);

        int cmp = player1HandsType.compareTo(player2HandsType);
        if (cmp == 0) {
            PokerHandType pokerHandType = player1HandsType.getHandType();
            Judgement judgement = PokerHandFactory.showHandJudgement(CardUtils.toCards(this.player1Hands),
                                                                     CardUtils.toCards(this.player2Hands), pokerHandType);
            return new PokerCompareResponse(judgement.getDescription(), "Same PokerHandType, base on poker faces or kickers", judgement.getDescription().replaceAll("(?i)\\s+wins\\b.*", ""));
        } else if (cmp < 0) {
            return new PokerCompareResponse("Player 2 wins", "Based on poker hand ranking", "player2");
        } else {
            return new PokerCompareResponse("Player 1 wins", "Based on poker hand ranking", "player1");
        }
    }
}
