package lotto.domain;

import java.util.Set;

public class WinningNumber {

    // 메인 6개의 당첨 번호와 1개의 보너스 번호를 관리하는 클래스

    private final Set<Integer> mainNumbers; // 당첨 번호 6개
    private final int bonusNumber; // 보너스 번호

    public WinningNumber(Set<Integer> mainNumbers, int bonusNumber) {
        validate(mainNumbers, bonusNumber);
        this.mainNumbers = mainNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Set<Integer> mainNumbers, int bonusNumber) {

        if (mainNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호와 당첨 번호는 중복 될 수 없습니다.");
        }
    }

    public Set<Integer> getMainNumbers() {
        return mainNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }


}
