package com.ibrohimapk3.trafficservice.screen

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
import androidx.compose.runtime.collectAsState
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ibrohimapk3.trafficservice.R
import com.ibrohimapk3.trafficservice.screen.component.AutomobileScreen
import com.ibrohimapk3.trafficservice.screen.component.EditAutomobile
import com.ibrohimapk3.trafficservice.screen.component.SegmentControl
import com.ibrohimapk3.trafficservice.screen.component.Tariffs
import com.ibrohimapk3.trafficservice.ui.theme.Blue
import com.ibrohimapk3.trafficservice.ui.theme.Grey

@Composable
fun ServiceScreen(
    modifier: Modifier,
    navigate: () -> Unit,
    viewModel: ServiceViewModel = viewModel()
) {
    val selectedIndex by viewModel.selectedIndex.collectAsState()

    var checkValueForTopbar by remember { mutableIntStateOf(0) }
    var editState by remember { mutableStateOf(false) }

    checkValueForTopbar = if (selectedIndex == 1) R.drawable.icon_edit else 0

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
            }
        )
        SegmentControl(selectedIndex, onValueChange = {
            viewModel.changeIndex(it)
        })
        when (selectedIndex) {
            0 -> Tariffs()
            else -> {
                when (editState) {
                    true -> EditAutomobile(modifier, true, navigate)
                    else -> AutomobileScreen(modifier, false, navigate)
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