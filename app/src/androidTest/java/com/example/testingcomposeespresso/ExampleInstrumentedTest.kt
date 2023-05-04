package com.example.testingcomposeespresso

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.testingcomposeespresso.ui.theme.TestingComposeEspressoTheme
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get: Rule
    val composeTestRule = createComposeRule()

    @Test
    fun whenScreenIsLaunched_thenVerifyAllViewsExists() {
        composeTestRule.setContent {
            TestingComposeEspressoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Calculator()
                }
            }
        }

        composeTestRule.onNodeWithTag("number1").assertExists()
        composeTestRule.onNodeWithTag("number2").assertExists()
        composeTestRule.onNodeWithTag("plus").assertExists()
        composeTestRule.onNodeWithTag("minus").assertExists()
        composeTestRule.onNodeWithTag("multiplication").assertExists()
        composeTestRule.onNodeWithTag("division").assertExists()
        composeTestRule.onNodeWithTag("display").assertExists()
    }

    @Test
    fun whenPerformPlusWithPositiveNumbers_thenVerifyTheResult() {
        composeTestRule.setContent {
            TestingComposeEspressoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Calculator()
                }
            }
        }

        composeTestRule.onNodeWithTag("number1").performTextInput("27")
        composeTestRule.onNodeWithTag("number2").performTextInput("3")
        composeTestRule.onNodeWithTag("plus").performClick()
        composeTestRule.onNodeWithTag("display").assertTextContains("30")
    }

    @Test
    fun whenPerformMinusWithPositiveNumbers_thenVerifyTheResult() {
        composeTestRule.setContent {
            TestingComposeEspressoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Calculator()
                }
            }
        }

        composeTestRule.onNodeWithTag("number1").performTextInput("27")
        composeTestRule.onNodeWithTag("number2").performTextInput("3")
        composeTestRule.onNodeWithTag("minus").performClick()
        composeTestRule.onNodeWithTag("display").assertTextContains("24")
    }

    @Test
    fun whenPerformMultiplicationWithPositiveNumbers_thenVerifyTheResult() {
        composeTestRule.setContent {
            TestingComposeEspressoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Calculator()
                }
            }
        }

        composeTestRule.onNodeWithTag("number1").performTextInput("27")
        composeTestRule.onNodeWithTag("number2").performTextInput("3")
        composeTestRule.onNodeWithTag("multiplication").performClick()
        composeTestRule.onNodeWithTag("display").assertTextContains("81")
    }

    @Test
    fun whenPerformDivisionWithPositiveNumbers_thenVerifyTheResult() {
        composeTestRule.setContent {
            TestingComposeEspressoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Calculator()
                }
            }
        }

        composeTestRule.onNodeWithTag("number1").performTextInput("27")
        composeTestRule.onNodeWithTag("number2").performTextInput("3")
        composeTestRule.onNodeWithTag("division").performClick()
        composeTestRule.onNodeWithTag("display").assertTextContains("9")
    }

    @Test
    fun whenPerformDivisionByZero_thenVerifyTheResult() {
        composeTestRule.setContent {
            TestingComposeEspressoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Calculator()
                }
            }
        }

        composeTestRule.onNodeWithTag("number1").performTextInput("27")
        composeTestRule.onNodeWithTag("number2").performTextInput("0")
        composeTestRule.onNodeWithTag("division").performClick()
        composeTestRule.onNodeWithTag("display").assertTextContains("Cannot be divided by zero")
    }

}