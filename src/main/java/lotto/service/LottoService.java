package lotto.service;

import java.util.List;
import lotto.domain.Lotto;

public interface LottoService {

    // 1. 구매한 만큼의 Lotto 인스턴스 생성 (생성과 동시에 오름차순 정렬)
    List<Lotto> generateRandomLottos(int purchasedLottoCount);


}
