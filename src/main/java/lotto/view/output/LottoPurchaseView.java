package lotto.view.output;

import static lotto.utils.constant.LottoConstants.LOTTO_PRICE;

import java.util.List;
import lotto.Lotto;

public class LottoPurchaseView {

    public static int displayLottoPurchaseCount(int budget) {
        int purchaseCount = budget / LOTTO_PRICE;
        System.out.println("\n" + purchaseCount + "개를 구매했습니다."); // 기능이 많아지면 service (비즈니스로직) 로 분리 가능
        return purchaseCount;
    }

    public static void displayLottoInfo(List<Lotto> lottos) {
        lottos.stream()
                .map(Lotto::getLottoNumbers)
                .forEach(System.out::println);
    }
}
