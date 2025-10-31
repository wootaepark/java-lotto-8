package lotto.controller;

import lotto.view.BudgetInputVIew;
import lotto.view.LottoPurchaseCountView;

public class LottoController {

    public void run() {
        int budget = BudgetInputVIew.inputBudget();
        int purchasedLottoCount = LottoPurchaseCountView.displayLottoPurchaseCount(budget);
        

    }
}
