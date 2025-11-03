package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import lotto.utils.constant.Ranking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoServiceImplTest {

    private LottoServiceImpl lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoServiceImpl();
    }

    @Test
    void 랜덤_로또_생성_개수_확인() {

        // given
        int purchaseCount = 5;

        // when
        List<Lotto> lottos = lottoService.generateRandomLottos(purchaseCount);

        // then
        assertThat(lottos).hasSize(purchaseCount);
        assertThat(lottos)
                .allSatisfy(lotto ->
                        assertThat(lotto.getLottoNumbers())
                                .hasSize(6)
                                .doesNotHaveDuplicates()
                                .allMatch(num -> num >= 1 && num <= 45));
    }

    @Test
    void 모든_당첨_번호와_로또번호가_모두_일치하면_1등() {

        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(Set.of(1, 2, 3, 4, 5, 6), 7);

        // when
        List<Ranking> result = lottoService.getWinningRanks(List.of(lotto), winningNumber);

        // then
        assertThat(result).containsExactly(Ranking.FIRST);
    }

    @Test
    void 당첨_번호5개와_보너스_번호가_일치하면_2등() {

        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        WinningNumber winningNumber = new WinningNumber(Set.of(1, 2, 3, 4, 5, 6), 7);

        // when
        List<Ranking> result = lottoService.getWinningRanks(List.of(lotto), winningNumber);

        // then
        assertThat(result).containsExactly(Ranking.SECOND);
    }


    @Test
    void 당첨_번호3개만_일치하면_5등() {

        // given
        Lotto lotto = new Lotto(List.of(1, 3, 5, 7, 9, 11));
        WinningNumber winningNumber = new WinningNumber(Set.of(1, 3, 5, 20, 30, 40), 7);

        // when
        List<Ranking> result = lottoService.getWinningRanks(List.of(lotto), winningNumber);

        // then
        assertThat(result).containsExactly(Ranking.FIFTH);
    }


    @Test
    void 당첨_번호3개이하_일치하면_Null() {

        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(Set.of(10, 11, 12, 13, 14, 15), 7);

        // when
        List<Ranking> result = lottoService.getWinningRanks(List.of(lotto), winningNumber);

        // then
        assertThat(result).containsExactly((Ranking) null);
    }


}
