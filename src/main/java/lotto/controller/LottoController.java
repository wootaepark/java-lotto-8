package lotto.controller;

import java.util.List;
import lotto.Lotto;
import lotto.domain.WinningNumber;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;
import lotto.service.WinningNumberService;
import lotto.service.WinningNumberServiceImpl;
import lotto.view.input.BonusNumberInputView;
import lotto.view.input.BudgetInputVIew;
import lotto.view.input.WinningNumberInputView;
import lotto.view.output.LottoPurchaseView;

public class LottoController {

    private final LottoService lottoService = new LottoServiceImpl();
    private final WinningNumberService winningNumberService = new WinningNumberServiceImpl();


    public void run() {

        // 초기 금액 입력
        int budget = BudgetInputVIew.inputBudget();

        // 로또 구매 장수 출력
        int purchasedLottoCount = LottoPurchaseView.displayLottoPurchaseCount(budget);

        // 로또 인스턴스 화 및 정보 출력
        List<Lotto> lottos = lottoService.generateRandomLottos(purchasedLottoCount);
        LottoPurchaseView.displayLottoInfo(lottos);

        // 당첨 번호 및 보너스 번호 입력
        WinningNumber winningNumber = winningNumberService.generateWinningNumber(
                WinningNumberInputView.inputWinningNumber(),
                BonusNumberInputView.inputBonusNumber()
        );

        // 당첨 통계 출력

        // 수익률 출력
    }
}
