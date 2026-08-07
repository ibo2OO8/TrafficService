package com.ibrohimapk3.trafficservice

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ibrohimapk3.trafficservice.ui.theme.Blue
import com.ibrohimapk3.trafficservice.ui.theme.Grey

@Composable
fun ServiceScreen(modifier: Modifier = Modifier) {
    var selectedIndex by remember { mutableIntStateOf(0) }
    var checkValueForTopbar by remember { mutableIntStateOf(0) }
    var editState by remember { mutableStateOf(false) }
    LaunchedEffect(selectedIndex) {
        if (selectedIndex == 1) checkValueForTopbar = R.drawable.icon_edit
        else checkValueForTopbar = 0
    }
    Column(
        modifier
            .fillMaxSize()
            .padding(vertical = 2.dp)
    ) {
        ActionBar(
            text = "Сервисы",
            iconId = R.drawable.icon_back,
            iconId2 = checkValueForTopbar,
            onValueChange = {
                editState = it
            })
        SegmentControl(selectedIndex, onValueChange = {
            selectedIndex = it
        })
        when (selectedIndex) {
            0 -> Tariffs()
            else ->{
                when (editState) {
                    true -> EditAutomobile()
                    else -> AutomobileScreen(modifier)
                }
            }
        }
    }
}

@Composable
fun ActionBar(text: String, iconId: Int = 0, iconId2: Int = 0, onValueChange: (Boolean) -> Unit) {
    var cancelState by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
            .padding(top = 8.dp),
    ) {
        IconButton(
            onClick = {}, modifier = Modifier
                .size(44.dp)
                .align(Alignment.CenterStart)
        ) {
            Icon(
                painter = painterResource(iconId),
                contentDescription = "back",
                tint = Color.Unspecified,
                modifier = Modifier
                    .width(20.dp)
                    .height(28.dp)
            )
        }
        Text(
            text = text, fontWeight = FontWeight(500), modifier = Modifier.align(Alignment.Center)
        )
        if (iconId2 != 0) {
            if (!cancelState) {
                IconButton(
                    onClick = {
                        onValueChange(true)
                        cancelState = true
                    }, modifier = Modifier
                        .size(44.dp)
                        .align(Alignment.CenterEnd)
                ) {
                    Icon(
                        painter = painterResource(iconId2),
                        contentDescription = "edit",
                        tint = Color.Unspecified,
                        modifier = Modifier
                            .width(20.dp)
                            .height(28.dp)
                    )
                }
            } else {
                Text(
                    text = "Отменить", modifier = Modifier
                        .padding(end = 12.dp)
                        .align(Alignment.CenterEnd)
                        .clickable {
                            onValueChange(false)
                            cancelState = false
                        },
                    color = Blue
                )
            }
        }
    }
}


@Composable
fun GreySpace() {
    Box(
        modifier = Modifier
            .padding(horizontal = 12.dp)
            .fillMaxWidth()
            .height(2.dp)
            .background(Grey)
    )
}