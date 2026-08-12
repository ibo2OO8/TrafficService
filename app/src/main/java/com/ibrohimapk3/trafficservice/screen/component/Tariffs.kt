package com.ibrohimapk3.trafficservice.screen.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ibrohimapk3.trafficservice.R
import com.ibrohimapk3.trafficservice.screen.GreySpace
import com.ibrohimapk3.trafficservice.ui.theme.Blue
import com.ibrohimapk3.trafficservice.ui.theme.Grey

@Composable
fun Tariffs() {
    var economy by remember { mutableStateOf(false) }
    var caravan by remember { mutableStateOf(false) }
    var comfort by remember { mutableStateOf(false) }
    var minivan by remember { mutableStateOf(false) }
    var express by remember { mutableStateOf(false) }
    var buyAndDeliver by remember { mutableStateOf(false) }
    var towing by remember { mutableStateOf(false) }
    var startTheEngine by remember { mutableStateOf(false) }
    var driver by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(7.dp))

        TariffsContent("Такси", R.drawable.icon_car)

        Switcher("Эконом", checked = economy, onCheckedChange = { economy = it })

        GreySpace()

        Switcher("Караван", checked = caravan, onCheckedChange = { caravan = it })

        GreySpace()

        Switcher(
            "Комфорт",
            checked = comfort,
            onCheckedChange = { comfort = it },
            description = "Недоступно для вас"
        )

        GreySpace()

        Switcher(
            title = "Минивэн",
            checked = minivan,
            onCheckedChange = { minivan = it },
            description = "Недоступно для вас"
        )

        TariffsContent("Доставка", R.drawable.icon_delivery)

        Switcher("Экспресс", express, onCheckedChange = {
            express = it
        })

        GreySpace()

        Switcher("Купис и привезем", buyAndDeliver, onCheckedChange = {
            buyAndDeliver = it
        })

        TariffsContent("Услуги", R.drawable.icon_service)

        Switcher("Буксировка", towing, onCheckedChange = {
            towing = it
        })

        GreySpace()

        Switcher("Запуск двигателя", startTheEngine, onCheckedChange = {
            startTheEngine = it
        })

        GreySpace()

        Switcher("Водитель", driver, onCheckedChange = {
            driver = it
        })

        GreySpace()
    }
}

@Composable
fun TariffsContent(text: String, id: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(44.dp)
            .background(Grey),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id),
            contentDescription = "car",
            tint = Color.Unspecified,
            modifier = Modifier
                .size(40.dp)
                .padding(start = 12.dp)
        )
        Text(text = text, modifier = Modifier.padding(start = 12.dp))
    }
}

@Composable
fun SegmentControl(selectedIndex: Int, onValueChange: (Int) -> Unit) {
    SingleChoiceSegmentedButtonRow(
        modifier = Modifier
            .padding(start = 12.dp, end = 12.dp, top = 10.dp)
            .fillMaxWidth()
            .height(39.dp)
            .background(color = Grey, shape = RoundedCornerShape(8.dp))
            .padding(horizontal = 2.dp),
    ) {
        SegmentedButton(
            modifier = Modifier.height(33.dp),
            selected = selectedIndex == 0,
            onClick = {
                onValueChange(0)
            },
            border = BorderStroke(
                width = 0.dp, color = Color.Transparent
            ),
            shape = RoundedCornerShape(8.dp),
            icon = {},
            colors = SegmentedButtonDefaults.colors(
                activeContainerColor = Color.White,
                inactiveContainerColor = Color.Transparent,
            ),

            ) {
            Text("Тарифы")
        }

        SegmentedButton(
            modifier = Modifier.height(33.dp),
            selected = selectedIndex == 1,
            onClick = {
                onValueChange(1)
            },
            border = BorderStroke(
                width = 0.dp, color = Color.Transparent
            ),
            shape = RoundedCornerShape(8.dp),
            icon = {},
            colors = SegmentedButtonDefaults.colors(
                activeContainerColor = Color.White,
                inactiveContainerColor = Color.Transparent,
            ),

            ) {
            Text("Автомобиль")
        }
    }
}

@Composable
fun Switcher(
    title: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit, description: String = ""
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {

            Text(
                text = title, fontSize = 16.sp,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )
            )
            if (description != "") {
                Text(
                    text = description,
                    fontSize = 13.sp,
                    color = Color.Gray,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    )
                )
            }

        }

        Spacer(Modifier.weight(1F))

        MySwitch(checked = checked, onCheckedChange)
    }
}

@Composable
fun MySwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Box(
        modifier = Modifier
            .width(52.dp)
            .height(32.dp)
            .clip(CircleShape)
            .background(
                if (checked) Blue
                else Grey
            )
            .clickable {
                onCheckedChange(!checked)
            }
            .padding(4.dp),
        contentAlignment = if (checked) {
            Alignment.CenterEnd
        } else {
            Alignment.CenterStart
        }
    ) {
        Box(
            modifier = Modifier
                .size(24.dp)
                .background(
                    color = Color.White,
                    shape = CircleShape
                )
        )
    }
}