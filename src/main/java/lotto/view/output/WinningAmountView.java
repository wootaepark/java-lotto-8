package lotto.view.output;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import lotto.utils.constant.Ranking;

public class WinningAmountView {

    public static void displayWinningAmount(List<Ranking> rankingList) {
        System.out.println("\n당첨 통계 \n---");

        Map<Ranking, Long> rankingCount = countRanking(rankingList);

        // 모든 랭킹 순회하며 출력
        for (Ranking ranking : Ranking.values()) {
            long count = rankingCount.getOrDefault(ranking, 0L);
            System.out.println(
                    ranking.getMatchCount() + "개 일치 " + String.format("(%,d", ranking.getPrize()) + "원) - " + count
                            + "개");
        }
    }

    private static Map<Ranking, Long> countRanking(List<Ranking> rankingList) {
        return rankingList.stream()
                .filter(Objects::nonNull) // null 제거
                .collect(Collectors.groupingBy(r -> r, LinkedHashMap::new, Collectors.counting()));
    }


}
