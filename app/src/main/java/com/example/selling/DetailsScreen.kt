package com.example.selling

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.selling.ui.theme.SellingTheme
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
@Composable
fun DetailsScreen(navController: NavController) {
    val navBackStackEntry = navController.currentBackStackEntry
    val serializedUser = navBackStackEntry?.arguments?.getString("product") ?: ""
    val product = json.decodeFromString<ShopItem>(serializedUser)
    Column {
        Text(product.desc)
        Text(product.cost)
    }
}