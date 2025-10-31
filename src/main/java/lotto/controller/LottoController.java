package lotto.controller;

import lotto.view.input.BudgetInputVIew;
import lotto.view.output.LottoPurchaseCountView;

public class LottoController {

    public void run() {
        int budget = BudgetInputVIew.inputBudget();
        int purchasedLottoCount = LottoPurchaseCountView.displayLottoPurchaseCount(budget);


    }
}
