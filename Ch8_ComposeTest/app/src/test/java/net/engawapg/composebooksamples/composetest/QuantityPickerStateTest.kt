package net.engawapg.composebooksamples.composetest

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class QuantityPickerStateTest {
    @Test
    fun quantity_can_be_increased() {
        // 準備
        val state = QuantityPickerState(
            minQuantity = 0,
            maxQuantity = 10,
            initialQuantity = 9
        )

        // 実行
        state.increase()

        // 確認
        assertThat(state.quantity).isEqualTo(10)
    }

    @Test
    fun quantity_cannot_be_increased_if_equals_to_maximum() {
        // 準備
        val state = QuantityPickerState(
            minQuantity = 0,
            maxQuantity = 10,
            initialQuantity = 10
        )

        // 実行
        state.increase()

        // 確認
        assertThat(state.quantity).isEqualTo(10)
    }
}
