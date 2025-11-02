package lotto.service;

import static lotto.utils.constant.LottoConstants.LOTTO_NUMBER_COUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import lotto.utils.constant.Ranking;

public class LottoServiceImpl implements LottoService {


    @Override
    public List<Lotto> generateRandomLottos(int purchasedLottoCount) {
        return IntStream.range(0, purchasedLottoCount)
                .mapToObj(i -> new Lotto(
                        Randoms.pickUniqueNumbersInRange(1, 45, LOTTO_NUMBER_COUNT)
                                .stream()
                                .sorted()
                                .toList())
                ).toList();
    }

    @Override
    public List<Ranking> getWinningRanks(List<Lotto> lottos, WinningNumber winningNumber) {
        return lottos.stream()
                .map(lotto -> {
                    int matchCount = countMatchingNumbers(lotto, winningNumber);
                    boolean bonusMatch = isBonusMatched(lotto, winningNumber);
                    return determineRanking(matchCount, bonusMatch);
                })
                .toList();
    }

    // 당첨 번호와 비교하고 개수 반환
    private int countMatchingNumbers(Lotto lotto, WinningNumber winningNumber) {
        return (int) lotto.getLottoNumbers().stream()
                .filter(num -> winningNumber.getMainNumbers().contains(num))
                .count();
    }

    // 보너스 번호 매치 여부
    private boolean isBonusMatched(Lotto lotto, WinningNumber winningNumber) {
        return lotto.getLottoNumbers().contains(winningNumber.getBonusNumber());
    }

    // 랭킹 결정

    private Ranking determineRanking(int matchCount, boolean isBonusMatched) {
        for (Ranking ranking : Ranking.values()) {
            if (ranking.getMatchCount() == matchCount && (!ranking.isBonusMatch() || isBonusMatched)) {
                return ranking;
            }
        }
        return null; // 나중에 null 은 없는 것 처럼 처리 예정
    }


}
