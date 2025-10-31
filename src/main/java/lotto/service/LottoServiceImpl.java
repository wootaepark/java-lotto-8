package lotto.service;

import static lotto.utils.constant.LottoConstants.LOTTO_NUMBER_COUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.Lotto;

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
}
