package lotto.service;

import java.util.Set;
import lotto.domain.WinningNumber;

public interface WinningNumberService {
    WinningNumber generateWinningNumber(Set<Integer> mainNumbers, int bonusNumber);

}
