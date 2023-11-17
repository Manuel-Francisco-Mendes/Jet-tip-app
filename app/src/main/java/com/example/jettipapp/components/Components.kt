package com.example.jettipapp.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp


@Composable
fun InputField(
    modifier: Modifier = Modifier,
    valueState: MutableState<String>,
    enabled: Boolean,
    isSingleLine: Boolean,
    labelId: String,
    keyboardType: KeyboardType = KeyboardType.Number,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default
    ){
    OutlinedTextField(
        value = valueState.value, onValueChange = {valueState.value = it},
       label = { Text(text = labelId)},
        enabled = enabled,
        singleLine = isSingleLine,
        leadingIcon = { Icon(imageVector = Icons.Rounded.AttachMoney, contentDescription = "Money icon")},
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
        keyboardActions = onAction,
        modifier = modifier.padding(start = 10.dp, bottom = 10.dp, end = 10.dp
        )

    )

}