package lotto.controller;

import java.util.List;
import lotto.Lotto;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;
import lotto.view.input.BonusNumberInputView;
import lotto.view.input.BudgetInputVIew;
import lotto.view.input.WinningNumberInputView;
import lotto.view.output.LottoPurchaseView;

public class LottoController {

    private final LottoService lottoService = new LottoServiceImpl();


    public void run() {
        int budget = BudgetInputVIew.inputBudget();
        int purchasedLottoCount = LottoPurchaseView.displayLottoPurchaseCount(budget);
        List<Lotto> lottos = lottoService.generateRandomLottos(purchasedLottoCount);
        LottoPurchaseView.displayLottoInfo(lottos);

        // for test
        System.out.println("WinningNumbers = " + WinningNumberInputView.inputWinningNumber());
        System.out.println("BonusNumbers = " + BonusNumberInputView.inputBonusNumber());
    }
}
