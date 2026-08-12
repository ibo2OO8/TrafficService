package com.ibrohimapk3.trafficservice.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ibrohimapk3.trafficservice.R
import com.ibrohimapk3.trafficservice.ui.theme.Blue
import com.ibrohimapk3.trafficservice.ui.theme.Grey

val list = listOf("bmw", "mers")

@Composable
fun AddAutomobileScreen(modifier: Modifier, onBack: () -> Unit) {
    var yearState by remember { mutableStateOf("") }
    var numberState by remember { mutableStateOf("") }
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Grey)
    ) {
        ActionBarForAddAutomobile(onBack)
        Column(
            modifier = Modifier
                .imePadding()
                .padding(top = 7.dp)
                .fillMaxSize()
                .background(Color.White, RoundedCornerShape(topStart = 17.dp, topEnd = 17.dp))
                .verticalScroll(rememberScrollState())
        ) {
            DropdownMenuBox(list = list, text = "Категория")
            DropdownMenuBox(list = list, text = "Марка")
            DropdownMenuBox(list = list, text = "Модель")
            DropdownMenuBox(list = list, text = "Тип кузова")
            DropdownMenuBox(list = list, text = "Цвет")
            OutlinedTextField(
                modifier = Modifier
                    .padding(top = 12.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth()
                    .border(1.5.dp, color = Grey, RoundedCornerShape(16.dp)),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,

                    ),
                value = yearState,
                onValueChange = {
                    yearState = it
                },
                placeholder = { Text(text = "Год выпуска") },
            )
            Row(
                modifier = Modifier
                    .padding(top = 12.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .border(width = 1.5.dp, color = Grey, shape = RoundedCornerShape(16.dp)),
                ) {
                    Icon(
                        painter = painterResource(R.drawable.icon_tj),
                        contentDescription = "",
                        tint = Color.Unspecified,
                        modifier = Modifier.align(alignment = Alignment.Center)
                    )
                }
                OutlinedTextField(
                    modifier = Modifier
                        .padding(start = 12.dp)
                        .fillMaxWidth()
                        .border(1.5.dp, color = Grey, RoundedCornerShape(16.dp)),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                    ),
                    value = numberState,
                    onValueChange = {
                        numberState = it
                    },

                    placeholder = { Text(text = "Госномер") },
                )
            }
            Text(
                text = "Формат: 0000XX00",
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 16.5.dp)
            )
            Spacer(Modifier.weight(1f))
            Button(
                modifier = Modifier
                    .padding(bottom = 42.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Blue),
                shape = RoundedCornerShape(16.dp),
                onClick = {}
            ) {
                Text(color = Color.White, text = "Продолжить")
            }
        }
    }
}

@Composable
fun ActionBarForAddAutomobile(
    onBack: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
            .background(Color.White, RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp))
            .padding(top = 8.dp),
    ) {
        IconButton(
            onClick = {
                onBack()
            }, modifier = Modifier
                .size(44.dp)
                .align(Alignment.CenterStart)
        ) {
            Icon(
                painter = painterResource(R.drawable.icon_back),
                contentDescription = "back",
                tint = Color.Unspecified,
                modifier = Modifier
                    .width(11.dp)
                    .height(20.dp)
            )
        }
        Text(
            text = "Добавить автомобиль",
            fontWeight = FontWeight(500),
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownMenuBox(text: String, list: List<String>) {
    var expanded by remember { mutableStateOf(false) }
    var selected by remember { mutableStateOf("") }
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = Modifier
            .padding(top = 12.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .background(color = Color.White, shape = RoundedCornerShape(16.dp))

    ) {
        OutlinedTextField(
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
                .border(1.5.dp, color = Grey, RoundedCornerShape(16.dp)),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            value = selected,
            onValueChange = {},
            readOnly = true,
            placeholder = { Text(text = text) },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded)
            })
        ExposedDropdownMenu(
            expanded = expanded, onDismissRequest = { expanded = false }) {
            list.forEach { brand ->
                DropdownMenuItem(
                    text = { Text(brand) },
                    onClick = {
                        selected = brand
                        expanded = false
                    }
                )
            }
        }
    }
}