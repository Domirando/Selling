package com.example.selling

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.selling.ui.theme.SellingTheme
import kotlinx.serialization.json.Json

@Composable
fun HomeScreen(navController: NavController){
    var item1 = ShopItem("Xoroshiy tovaaar, pokupayteee!!!", "125$", "160$", "50% OFF", "4.3", 160, R.drawable.img, false)
    var item2 = ShopItem("Ne ploxoy tovaaar, pokupayteee!!!", "135$", "163$", "60% OFF", "4.5", 120, R.drawable.img, true)
    var item3 = ShopItem("Otlichniy tovaaar, pokupayteee!!!", "115$", "140$", "35% OFF", "4.1", 180, R.drawable.img, false)
    var items = mutableListOf<ShopItem>()
    for (i in 1..10){
        items.add(item1)
        items.add(item2)
        items.add(item3)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ){
            items(items) { item ->
                Card(item = item, navController = navController)
            }
        }
    }
}