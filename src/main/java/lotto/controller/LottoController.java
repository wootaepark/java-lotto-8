package lotto.controller;

import lotto.view.InputVIew;

public class LottoController {

    public void run() {
        int budget = InputVIew.inputBudget();
        System.out.println(budget);
    }
}
