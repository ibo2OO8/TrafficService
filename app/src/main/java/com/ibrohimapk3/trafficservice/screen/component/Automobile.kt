package com.ibrohimapk3.trafficservice.screen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ibrohimapk3.trafficservice.R
import com.ibrohimapk3.trafficservice.screen.GreySpace
import com.ibrohimapk3.trafficservice.ui.theme.Blue
import com.ibrohimapk3.trafficservice.ui.theme.GreyIconColor
import com.ibrohimapk3.trafficservice.ui.theme.IconPlusColor

var listCar = mutableListOf(
    Car(model = "bmw m3", color = "серый", number = "5595MU17", yearOfManufacture = 2008)
)

data class Car(var model: String, var color: String, var number: String, var yearOfManufacture: Int)

@Composable
fun AutomobileScreen(
    modifier: Modifier = Modifier,
    deleteOrEditIcon: Boolean,
    navigate: () -> Unit
) {
    Column(
        modifier
            .fillMaxSize()
            .padding(vertical = 2.dp)
    ) {
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(listCar) {
                CarItem(
                    model = it.model,
                    color = it.color,
                    number = it.number,
                    yearOfManufacture = it.yearOfManufacture,
                    deleteOrEditIcon
                )
                GreySpace()
            }
        }
        AddCarItem(navigate)
        GreySpace()
    }
}

@Composable
fun CarItem(
    model: String, color: String, number: String, yearOfManufacture: Int, deleteOrEditIcon: Boolean
) {
    var selected by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .width(30.dp)
                .height(30.dp)
                .background(GreyIconColor, shape = RoundedCornerShape(100))
        ) {
            Icon(
                painter = painterResource(R.drawable.icon_white_car),
                contentDescription = "edit",
                tint = Color.Unspecified,
                modifier = Modifier
                    .width(27.dp)
                    .height(27.dp)
                    .align(Alignment.Center)
            )
        }
        Column(
            modifier = Modifier
                .weight(1F)
                .padding(start = 10.dp)
        ) {
            Text(text = "$model $color", fontSize = 16.sp)
            Text(text = "$number $yearOfManufacture", fontSize = 16.sp)
        }
        if (!deleteOrEditIcon) {
            RadioButton(
                selected = selected, colors = RadioButtonDefaults.colors(
                    selectedColor = Blue
                ), onClick = {
                    selected = !selected
                }, modifier = Modifier.size(14.dp)
            )
        } else {
            IconButton(
                onClick = {
                }, modifier = Modifier
                    .size(18.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.icon_delete),
                    contentDescription = "delete",
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .width(20.dp)
                        .height(28.dp)
                )
            }
        }
    }
}

@Composable
fun AddCarItem(navigate: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(horizontal = 12.dp)
            .clickable {
                navigate()
            },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .padding(start = 2.dp)
                .width(24.dp)
                .height(24.dp)
                .background(IconPlusColor, shape = RoundedCornerShape(100))
        ) {
            Icon(
                painter = painterResource(R.drawable.icon_plus),
                contentDescription = "edit",
                tint = Color.Unspecified,
                modifier = Modifier
                    .width(12.dp)
                    .height(12.dp)
                    .align(Alignment.Center)
            )
        }
        Text(
            text = "Добавить авто",
            fontSize = 16.sp,
            modifier = Modifier
                .weight(1F)
                .padding(start = 10.dp)
        )

        Icon(
            painter = painterResource(R.drawable.icon_arrow),
            contentDescription = "edit",
            modifier = Modifier
                .width(6.dp)
                .height(11.dp)
        )
    }
}