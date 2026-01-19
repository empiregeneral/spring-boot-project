package cn.edu.hdu.acm.problem3795.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PokerHandsGenerateResponse {

    /**
     * 任务是否成功启动/完成
     */
    private boolean success;

    /**
     * 总共生成的手牌组合数（应为 7462）
     */
    private int totalHandsGenerated;

    /**
     * 生成过程耗时（毫秒）
     */
    private long processingTimeMillis;

    /**
     * 时间戳（任务完成时间）
     */
    private LocalDateTime completedAt;

    /**
     * 可选：生成结果的访问方式（如缓存 key、文件路径、API 分页入口）
     */
    private String accessHint;

    /**
     * 可选：错误信息（当 success = false 时）
     */
    private String errorMessage;

    // ---------------- 构造函数 & Getter/Setter ----------------

    public static PokerHandsGenerateResponse success(int total, long timeMillis) {
        PokerHandsGenerateResponse res = new PokerHandsGenerateResponse();
        res.success = true;
        res.totalHandsGenerated = total;
        res.processingTimeMillis = timeMillis;
        res.completedAt = LocalDateTime.now();
        res.accessHint = "Results stored in cache (key: poker_hand_eval_map)";
        return res;
    }

    public static PokerHandsGenerateResponse failure(String error) {
        PokerHandsGenerateResponse res = new PokerHandsGenerateResponse();
        res.success = false;
        res.errorMessage = error;
        res.completedAt = LocalDateTime.now();
        return res;
    }

    // Setters（如需）
    public void setAccessHint(String accessHint) { this.accessHint = accessHint; }
}
