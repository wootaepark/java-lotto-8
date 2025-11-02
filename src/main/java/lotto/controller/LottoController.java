package lotto.controller;

import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;
import lotto.service.WinningNumberService;
import lotto.service.WinningNumberServiceImpl;
import lotto.utils.constant.ErrorPrefix;
import lotto.view.input.BonusNumberInputView;
import lotto.view.input.BudgetInputVIew;
import lotto.view.input.MainNumberInputView;
import lotto.view.output.LottoPurchaseView;
import lotto.view.output.WinningAmountView;

public class LottoController {

    private final LottoService lottoService = new LottoServiceImpl();
    private final WinningNumberService winningNumberService = new WinningNumberServiceImpl();
    private static final String ERROR_PREFIX = ErrorPrefix.ERROR.getPrefix();


    public void run() {

        // 초기 금액 입력
        int budget = getBudgetWithRetry();

        // 로또 구매 장수 출력
        int purchasedLottoCount = LottoPurchaseView.displayLottoPurchaseCount(budget);

        // 로또 인스턴스 화 및 정보 출력
        List<Lotto> lottos = lottoService.generateRandomLottos(purchasedLottoCount);
        LottoPurchaseView.displayLottoInfo(lottos);

        // 당첨 번호 및 보너스 번호 입력
        WinningNumber winningNumber = getWinningNumberWithRetry();

        // 당첨 통계 출력

        WinningAmountView.displayWinningAmount(lottoService.getWinningRanks(lottos, winningNumber));

        // 수익률 출력
    }

    // 예산 입력 재시도 메서드
    private int getBudgetWithRetry() {
        while (true) {
            try {
                return BudgetInputVIew.inputBudget();
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_PREFIX + e.getMessage());
            }
        }
    }

    // 6개 당첨 번호 입력 재시도 메서드
    private Set<Integer> getMainNumbersWithRetry() {
        while (true) {
            try {
                return MainNumberInputView.inputWinningNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_PREFIX + e.getMessage());
            }
        }
    }

    // 보너스 번호 입력 재시도 메서드
    private int getBonusNumberWithRetry() {
        while (true) {
            try {
                return BonusNumberInputView.inputBonusNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_PREFIX + e.getMessage());
            }
        }
    }

    // 객체 생성시 생성자 예외 발생에 대한 재시도 메서드
    private WinningNumber getWinningNumberWithRetry() {
        while (true) {
            try {
                Set<Integer> mainNumbers = getMainNumbersWithRetry();
                int bonusNumber = getBonusNumberWithRetry();
                return winningNumberService.generateWinningNumber(mainNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_PREFIX + e.getMessage());
            }
        }
    }
}
