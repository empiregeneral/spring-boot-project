package cn.edu.hdu.acm.problem3795.service;

import cn.edu.hdu.acm.problem3795.dto.response.PokerHandsGenerateResponse;
import cn.edu.hdu.acm.problem3795.model.PokerHand;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PerComputeService {
    private volatile List<PokerHand.HandScore> handScores = null;
    private final Object lock = new Object();
    private static final int CAPACITY = 7462;

    @PostConstruct
    public void init() {
        generateAllInternal();
    }

    public List<PokerHand.HandScore> getPerComputedHandScore() {
        if (handScores == null) {
            synchronized (this) {
                if (handScores == null) {
                    generateAllInternal();
                }
            }
        }
        return handScores;
    }

    public PokerHandsGenerateResponse generateAll() {
        if (handScores != null) {
            if (handScores != null) {
                // 0ms 表示已存在
                return PokerHandsGenerateResponse.success(CAPACITY, 0);
            }
        }
        synchronized (lock) {
            // 双重检查：防止多个线程同时进入并重复计算
            if (handScores != null) {
                return PokerHandsGenerateResponse.success(CAPACITY, 0);
            }

            long start = System.currentTimeMillis();
            List<PokerHand.HandScore> handScores = new ArrayList<>(CAPACITY);
            generate(0, PokerHand.C1, PokerHand.ACE, 0, true, handScores);
            Collections.sort(handScores);
            assert handScores.size() == CAPACITY : "Expected " + CAPACITY + ", got " + handScores.size();

            this.handScores = Collections.unmodifiableList(handScores);
            long end = System.currentTimeMillis();

            return PokerHandsGenerateResponse.success(CAPACITY, end - start);
        }
    }

    private  void generateAllInternal(){
        long start = System.currentTimeMillis();
        handScores = new ArrayList<>();
        generate(0, PokerHand.C1, PokerHand.ACE, 0, true, handScores);
        Collections.sort(handScores);
        assert handScores.size() == CAPACITY;
        this.handScores = Collections.unmodifiableList(handScores);
        long end = System.currentTimeMillis();
        System.out.println("Create PokerHand.Scores completed in " + (end - start) + " ms");
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

    public List<PokerHand.HandScore> getHandScores() {
        return handScores;
    }
}
