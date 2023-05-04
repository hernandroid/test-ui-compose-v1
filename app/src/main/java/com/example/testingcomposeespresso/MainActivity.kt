package com.example.testingcomposeespresso

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testingcomposeespresso.ui.theme.TestingComposeEspressoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestingComposeEspressoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Calculator()
                }
            }
        }
    }
}

@Composable
fun Calculator(modifier: Modifier = Modifier) {
    var number1 by rememberSaveable { mutableStateOf("") }
    var number2 by rememberSaveable { mutableStateOf("") }
    var result by rememberSaveable { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        NumberField(
            label = "Number 1",
            testTag = "number1",
            value = number1,
            onValueChanged = { number1 = it }
        )
        Spacer(modifier = Modifier.height(8.dp))
        NumberField(
            label = "Number 2",
            testTag = "number2",
            value = number2,
            onValueChanged = { number2 = it }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            OperationButton(label = "+", testTag = "plus") {
                result = (number1.toInt() + number2.toInt()).toString()
            }
            Spacer(modifier = Modifier.width(8.dp))
            OperationButton(label = "-", testTag = "minus") {
                result = (number1.toInt() - number2.toInt()).toString()
            }
            Spacer(modifier = Modifier.width(8.dp))
            OperationButton(label = "×", testTag = "multiplication") {
                result = (number1.toInt() * number2.toInt()).toString()
            }
            Spacer(modifier = Modifier.width(8.dp))
            OperationButton(label = "÷", testTag = "division") {
                result = try {
                    (number1.toInt() / number2.toInt()).toString()
                } catch (e: ArithmeticException) {
                    "Cannot be divided by zero"
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            modifier = Modifier
                .testTag("display")
                .padding(horizontal = 16.dp),
            text = result,
            style = TextStyle(
                fontSize = 36.sp
            )
        )
    }
}

@Composable
fun OperationButton(
    modifier: Modifier = Modifier,
    label: String,
    testTag: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier.testTag(testTag)
    ) {
        Text(text = label)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NumberField(
    modifier: Modifier = Modifier,
    label: String,
    testTag: String,
    value: String,
    onValueChanged: (String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .testTag(testTag),
        value = value,
        onValueChange = onValueChanged,
        label = {
            Text(label)
        },
        textStyle = TextStyle(
            fontSize = 18.sp,
            textAlign = TextAlign.Start,
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        )
    )
}

@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    TestingComposeEspressoTheme {
        Calculator()
    }
}