package com.ibrohimapk3.trafficservice.screen.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ibrohimapk3.trafficservice.screen.GreySpace
import com.ibrohimapk3.trafficservice.ui.theme.Blue

@Composable
fun EditAutomobile(modifier: Modifier = Modifier, deleteOrEditIcon: Boolean, navigate: () -> Unit) {
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
        Spacer(Modifier.weight(1f))
        Button(
            modifier = Modifier
                .padding(bottom = 42.dp, start = 16.dp, end = 16.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Blue),
            shape = RoundedCornerShape(16.dp),
            onClick = {}
        ) {
            Text(color = Color.White, text = "Сохранить")
        }
    }
}