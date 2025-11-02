package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import lotto.utils.constant.Ranking;

public interface LottoService {

    // 1. 구매한 만큼의 Lotto 인스턴스 생성 (생성과 동시에 오름차순 정렬)
    List<Lotto> generateRandomLottos(int purchasedLottoCount);

    // 2. 구매된 로또와 당첨번호, 보너스 번호를 비교 및 개수 정보 반환
    List<Ranking> getWinningRanks(List<Lotto> lottos, WinningNumber winningNumber);

}
