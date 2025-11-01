package lotto.service;

import java.util.Set;
import lotto.domain.WinningNumber;

public class WinningNumberServiceImpl implements WinningNumberService {

    @Override
    public WinningNumber generateWinningNumber(Set<Integer> winningNumbers, int bonusNumber) {
        return new WinningNumber(winningNumbers, bonusNumber);
    }
}
