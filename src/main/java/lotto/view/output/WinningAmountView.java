package lotto.view.output;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import lotto.utils.constant.Ranking;

public class WinningAmountView {

    public static Map<Ranking, Long> getWinningAmount(List<Ranking> rankingList) {
        Map<Ranking, Long> rankingStats = countRanking(rankingList);
        String output = buildRankingStatsString(rankingStats);
        System.out.print(output);
        return rankingStats;
    }

    // 1. 랭킹별 개수 집계
    private static Map<Ranking, Long> countRanking(List<Ranking> rankingList) {
        return rankingList.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(r -> r, LinkedHashMap::new, Collectors.counting()));
    }

    // 2. 랭킹 통계 문자열 생성
    private static String buildRankingStatsString(Map<Ranking, Long> rankingStats) {
        StringBuilder sb = new StringBuilder("\n당첨 통계 \n---\n");
        Ranking[] displayOrder = {Ranking.FIFTH, Ranking.FOURTH, Ranking.THIRD, Ranking.SECOND, Ranking.FIRST};

        for (Ranking ranking : displayOrder) {
            long count = rankingStats.getOrDefault(ranking, 0L);
            sb.append(ranking.getMatchCount()).append("개 일치")
                    .append(ranking.isBonusMatch() ? ", 보너스 볼 일치" : "")
                    .append(" (").append(String.format("%,d", ranking.getPrize())).append("원) - ")
                    .append(count).append("개\n");
        }
        return sb.toString();
    }


}
