package lotto.view.output;


import java.util.Map;
import lotto.utils.constant.Ranking;

// ROI (Return of Investment) : 투자 대비 수익률
public class RoiVIew {

    public static void displayRoiInfo(Map<Ranking, Long> rankingCount, int budget) {
        double roi = getTotalRoi(rankingCount, budget);
        System.out.println("총 수익률은 " + String.format("%.1f", roi * 100) + "%입니다.");
    }

    private static double getTotalRoi(Map<Ranking, Long> rankingCount, int budget) {
        return rankingCount.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue()).sum() / (double) budget;
    }
}
