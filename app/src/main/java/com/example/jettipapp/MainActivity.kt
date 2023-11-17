package com.example.jettipapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jettipapp.components.InputField
import com.example.jettipapp.ui.theme.JetTipAppTheme

@OptIn(ExperimentalComposeUiApi::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

                MyApp {
                    Column() {
                        TopHeader()
                        RoundedBoderMainContent()
                    }
                }
        }
    }
}

@ExperimentalComposeUiApi
@Preview
@Composable
fun RoundedBoderMainContent(){

    val totalBillState = remember{
        mutableStateOf("")
    }

    val validTextState = remember(totalBillState) {
        totalBillState.value.trim().isNotEmpty()
    }

 //   val keyboardController = LocalSoftwareKeyboardController.current

    Surface(modifier = Modifier
        .fillMaxWidth()
        .height(250.dp)
        .padding(13.dp, 0.dp, 13.dp, 0.dp),
        shape = RoundedCornerShape(corner = CornerSize(12.dp)),
        border = BorderStroke(2.dp, Color.LightGray)
    ) {
        InputField(
            valueState = totalBillState,
            enabled = true, isSingleLine = true,
            labelId = "Total bill",
            onAction = KeyboardActions {
                if(!validTextState) return@KeyboardActions
                //TODO - onvaluechange

             //   keyboardController?.hide()
            }
        )
    }
}

@Preview
@Composable
fun TopHeader(totalPerPerson: Double = 0.0){
    Surface(modifier = Modifier
        .fillMaxWidth()
        .height(150.dp)
        .padding(18.dp, 20.dp, 18.dp, 13.dp)
        .clip(shape = RoundedCornerShape(corner = CornerSize(12.dp))),
        color = Color(0xFFE9D7F7)
    ){
        Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
            val total = "%.2f".format(totalPerPerson)
            Text(text = "Total Per Person", style = MaterialTheme.typography.h5)
            Text(text = "$$total", style = MaterialTheme.typography.h4, fontWeight = FontWeight.ExtraBold)

        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit){
    JetTipAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            content()
        }
    }
}


@OptIn(ExperimentalComposeUiApi::class)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetTipAppTheme {
        MyApp {
            Column() {
                TopHeader()
                RoundedBoderMainContent()
            }
        }

    }
}