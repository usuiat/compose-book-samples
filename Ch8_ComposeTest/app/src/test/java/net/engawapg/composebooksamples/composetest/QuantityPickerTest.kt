package net.engawapg.composebooksamples.composetest

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class QuantityPickerTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun quantity_should_be_increased_when_button_is_tapped() {
        // 準備
        composeTestRule.setContent {
            QuantityPickerTestContent(1)
        }

        // 実行
        composeTestRule
            .onNodeWithContentDescription("Increase quantity")
            .performClick()

        // 確認
        composeTestRule
            .onNodeWithText("2")
            .assertExists()
    }

    @Test
    fun quantity_should_be_decreased_when_button_is_tapped() {
        composeTestRule.setContent {
            QuantityPickerTestContent(1)
        }

        composeTestRule
            .onNodeWithContentDescription("Decrease quantity")
            .performClick()

        composeTestRule
            .onNodeWithText("0")
            .assertExists()
    }

    @Composable
    fun QuantityPickerTestContent(initialQuantity: Int) {
        val state = remember {
            QuantityPickerState(
                minQuantity = 0,
                maxQuantity = 3,
                initialQuantity = initialQuantity
            )
        }
        QuantityPicker(state = state)
    }
}
